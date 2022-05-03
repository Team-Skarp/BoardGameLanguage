package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.types.StringType;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;

class IdNodeTest {
    IdNode idNode;
    TypeEnvironment TENV;

    @Test
    void acceptsIdNodeWithName() {
        idNode = new IdNode("Player 1");

        idNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsPlayer() {
        idNode = new IdNode("Player2");
        TENV = new TypeEnvironment();

        SymbolTable symbolTable = new SymbolTable().
                enterSymbol(new Symbol(idNode.name, new StringType()));

        idNode.accept(new TypeChecker(symbolTable, TENV));
    }
}