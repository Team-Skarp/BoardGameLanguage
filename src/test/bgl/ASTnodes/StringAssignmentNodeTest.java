package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAssignmentNodeTest {
    StringAssignmentNode stringAssignmentNode;

    @BeforeEach
    void setup() {
        stringAssignmentNode = new StringAssignmentNode("a", "b");
    }

    @Test
    void accept() {
        stringAssignmentNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        assertEquals(stringAssignmentNode.varName, stringAssignmentNode.getLeft().name);
    }

    @Test
    void getRight() {
        assertEquals(stringAssignmentNode.literal, stringAssignmentNode.getRight().name);
    }
}