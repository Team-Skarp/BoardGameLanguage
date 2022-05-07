package SymbolTable;

import org.junit.Test;
import SymbolTable.types.IntType;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTableTest {

    SymbolTable ST;
    /**
     * int a; {a}
     */
    @Test
    public void canRetrieveSymbolFromWithinScope() {

        //int a; { a = 3 }
        ST = new SymbolTable();

        ST.enterSymbol(
                new Symbol(
                        "a",
                        new IntType()
                )
        );

        ST.openScope();

        Symbol symbol = ST.retrieveSymbol("a");

        assertNotNull(symbol);
        assertEquals("a", symbol.name);

    }

    /**
     * Test in code:
     * a
     */
    @Test
    public void cannotReferenceVariableBeforeDeclaration() {


        ST = new SymbolTable();

        assertThrows(ReferenceErrorException.class, () -> ST.retrieveSymbol("a"));


    }

    /**
     * Test in code:
     * {int a;} reference a
     */
    @Test
    public void cannotReferenceVariableDeclaredInInnerScope() {

        ST = new SymbolTable();

        ST.openScope();
        ST.enterSymbol(new Symbol("a", new IntType()));
        ST.closeScope();

        assertThrows(ReferenceErrorException.class, ()-> ST.retrieveSymbol("a"));

    }

    /**
     * Tests the code:
     * {int a}
     */
    @Test
    public void canAccessVariableUsingDiveAfterAllSymbolsHasBeenDeclared() {

        ST = new SymbolTable();
        ST.openScope();
        ST.enterSymbol(
                new Symbol(
                        "a",
                        new IntType()
                )
        );
        ST.closeScope();

        assertThrows(ReferenceErrorException.class, () ->
                ST.retrieveSymbol("a"));

        ST.dive();

        Symbol sym = ST.retrieveSymbol("a");

        assertNotNull(sym);
        assertEquals("a", sym.name);

    }

    /**
     * Tests the code:
     * {int a; {}{can get from here!}}
     */
    @Test
    public void canFindVariableFromSymbolTableTreeAfterCreation() {

        ST = new SymbolTable();
        ST.openScope();
        ST.enterSymbol(
                new Symbol(
                        "a",
                        new IntType()
                )
        );
        ST.openScope();
        ST.closeScope();
        ST.openScope();
        ST.closeScope();
        ST.closeScope();

        assertThrows(ReferenceErrorException.class, () ->
                ST.retrieveSymbol("a"));

        ST.dive();
        ST.dive();
        ST.climb();
        ST.dive();

        Symbol sym = ST.retrieveSymbol("a");

        assertNotNull(sym);
        assertEquals("a", sym.name);

    }


}
