package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReturnNodeTest {
    ReturnNode returnNode;
    ReturnNode returnNodeEmpty;
    IntNode intNode;
    BooleanNode booleanNode;
    StringNode stringNode;

    @BeforeEach
    void setup() {
        intNode = new IntNode(50);
        booleanNode = new BooleanNode(true);
        stringNode = new StringNode("Tile");
    }

    @Test
    void shouldAcceptAnyExpression() {
        // returnNode can return any of the three initialised nodes at the setup
        returnNode = new ReturnNode(intNode);
        returnNodeEmpty = new ReturnNode();

        returnNodeEmpty.accept(new PrettyPrinter());
        returnNode.accept(new PrettyPrinter());
    }
}