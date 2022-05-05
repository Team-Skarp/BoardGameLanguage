package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerAssignmentNodeTest {
    IntegerAssignmentNode integerAssignmentNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    IdNode idNode;
    PlusNode plusNode;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(1);
        intNodeRight = new IntNode(2);
        plusNode = new PlusNode(intNodeLeft, intNodeRight);
        idNode = new IdNode("pieceCounter");
    }

    @Test
    void accept() {
        integerAssignmentNode = new IntegerAssignmentNode(idNode, plusNode);

        integerAssignmentNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {

        integerAssignmentNode = new IntegerAssignmentNode(idNode, plusNode);
        assertEquals(idNode.name, integerAssignmentNode.getLeft().name);
    }

    @Test
    void getRight() {
        integerAssignmentNode = new IntegerAssignmentNode(idNode, plusNode);

        assertEquals(plusNode, integerAssignmentNode.getRight());
    }
}