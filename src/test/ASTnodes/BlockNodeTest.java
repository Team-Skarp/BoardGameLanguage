package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;

import static org.junit.jupiter.api.Assertions.*;

class BlockNodeTest {
    BlockNode blockNode;

    @BeforeEach
    void setup() {
        blockNode = new BlockNode("SETUP");
    }

    @Test
    void accept() {
        blockNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {
        blockNode.accept(new TypeChecker(new SymbolTable()));
    }
}