package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class BlockNodeTest {
    BlockNode blockNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        blockNode = new BlockNode();
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        blockNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {
        blockNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }
}