package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class OrNodeTest {
    OrNode orNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    StringNode stringNodeTest;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        // Initialised to test the type checker of orNode
        stringNodeTest = new StringNode("Test");
    }

    @Test
    void accept() {
        orNode = new OrNode(booleanNodeLeft, booleanNodeRight);

        orNode.accept(new PrettyPrinter());
        orNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void orNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        orNode = new OrNode(intNodeLeft, intNodeRight);

        orNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> orNode.accept(new TypeChecker(new SymbolTable())));
    }
}