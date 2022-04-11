import org.junit.Test;
import symboltable.ReferenceErrorException;
import symboltable.Symbol;
import symboltable.SymbolTable;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTableTest {

    @Test
    public void canRetrieveSymbolFromTable() {

        //int a; { a = 3 }
        SymbolTable symbolTable = new SymbolTable();

        symbolTable.enterSymbol("a", "int");
        symbolTable.openScope();

        Symbol symbol = symbolTable.retrieveSymbol("a");
        assertNotNull(symbol);
        assertEquals("a", symbol.name);

    }

    @Test
    public void cannotReferenceVariableBeforeDeclaration() {

        //a = 3;
        SymbolTable symbolTable = new SymbolTable();

        assertThrows(ReferenceErrorException.class, () -> symbolTable.retrieveSymbol("a"));


    }

    @Test
    public void cannotReferenceVariableDeclaredInInnerScope() {

        // ((int a;)) a = 3;
        SymbolTable symbolTable = new SymbolTable();

        symbolTable.openScope();
        symbolTable.enterSymbol("a", "int");
        symbolTable.closeScope();

        assertThrows(ReferenceErrorException.class, ()-> symbolTable.retrieveSymbol("a"));

    }

}
