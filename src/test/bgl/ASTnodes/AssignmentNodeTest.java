package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentNodeTest {
    AssignmentNode assignmentNode;
    IntNode intNode;
    BooleanNode booleanNode;
    StringNode stringNode;

    @BeforeEach
    void setup() {
        intNode = new IntNode(32);
        booleanNode = new BooleanNode(false);
        stringNode = new StringNode("dice");
        assignmentNode = new AssignmentNode("dice", intNode);
    }

    @Test
    void accept() {
        assignmentNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        assertEquals(assignmentNode.name, assignmentNode.getLeft().name);
    }

    @Test
    void getRight() {
        assertEquals(assignmentNode.expression, assignmentNode.getRight());
    }
}