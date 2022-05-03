package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class IntNodeTest {
    IntNode intNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNode = new IntNode(22);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        intNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsInt() {
        intNode.accept(new PrettyPrinter());
        intNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }
}