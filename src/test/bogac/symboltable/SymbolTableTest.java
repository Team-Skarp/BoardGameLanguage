package symboltable;

import org.junit.Test;
import symboltable.types.IntType;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTableTest {

    /**
     * int a; {a}
     */
    @Test
    public void canRetrieveSymbolFromWithinScope() {

        //int a; { a = 3 }
        SymbolTable symbolTable = new SymbolTable();

        symbolTable.enterSymbol(
                new Symbol(
                        "a",
                        new IntType()
                )
        );

        symbolTable.openScope();

        Symbol symbol = symbolTable.retrieveSymbol("a");

        assertNotNull(symbol);
        assertEquals("a", symbol.name);

    }

    /**
     * Test in code:
     * a
     */
    @Test
    public void cannotReferenceVariableBeforeDeclaration() {


        SymbolTable symbolTable = new SymbolTable();

        assertThrows(ReferenceErrorException.class, () -> symbolTable.retrieveSymbol("a"));


    }

    /**
     * Test in code:
     * {int a;} reference a
     */
    @Test
    public void cannotReferenceVariableDeclaredInInnerScope() {

        SymbolTable symbolTable = new SymbolTable();

        symbolTable.openScope();
        symbolTable.enterSymbol(new Symbol("a", new IntType()));
        symbolTable.closeScope();

        assertThrows(ReferenceErrorException.class, ()-> symbolTable.retrieveSymbol("a"));

    }

}
