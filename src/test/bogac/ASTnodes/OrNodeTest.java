package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class OrNodeTest {
    OrNode orNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    StringNode stringNodeTest;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);
        TENV = new TypeEnvironment();

        // Initialised to test the type checker of orNode
        stringNodeTest = new StringNode("Test");
    }

    @Test
    void accept() {
        orNode = new OrNode(booleanNodeLeft, booleanNodeRight);

        orNode.accept(new PrettyPrinter());
        orNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void orNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        orNode = new OrNode(intNodeLeft, intNodeRight);

        orNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> orNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}