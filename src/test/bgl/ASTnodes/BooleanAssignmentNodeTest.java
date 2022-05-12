package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanAssignmentNodeTest {
    BooleanAssignmentNode booleanAssignmentNode;
    BooleanNode booleanNode;
    IntNode intNode;

    @Test
    void shouldOnlyAcceptABooleanExpression() {
        booleanNode = new BooleanNode(false);
        booleanAssignmentNode = new BooleanAssignmentNode("WinCondition", booleanNode);

        booleanAssignmentNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        booleanNode = new BooleanNode(false);
        booleanAssignmentNode = new BooleanAssignmentNode("WinCondition", booleanNode);

        assertEquals("WinCondition", booleanAssignmentNode.getLeft().name);
    }

    @Test
    void getRight() {
        booleanNode = new BooleanNode(false);
        booleanAssignmentNode = new BooleanAssignmentNode("WinCondition", booleanNode);

        assertEquals(booleanNode, booleanAssignmentNode.getRight());
    }
}