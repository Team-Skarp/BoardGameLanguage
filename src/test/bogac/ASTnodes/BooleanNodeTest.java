package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeEnvironment;

class BooleanNodeTest {
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @Test
    void acceptsABoolean() {
        TENV = new TypeEnvironment();
        booleanNode = new BooleanNode(false);

        booleanNode.accept(new PrettyPrinter());
        booleanNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }
}