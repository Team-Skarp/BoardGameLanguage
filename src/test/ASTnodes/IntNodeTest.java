package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class IntNodeTest {
    IntNode intNode;

    @Test
    void accept() {
        intNode = new IntNode(-2);

        intNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsInt() {
        intNode = new IntNode(2);

        intNode.accept(new PrettyPrinter());
        intNode.accept(new TypeChecker(new SymbolTable()));
    }
}