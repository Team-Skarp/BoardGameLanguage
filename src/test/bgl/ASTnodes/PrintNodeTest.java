package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PrintNodeTest {
    PrintNode printNode;
    List<ASTNode> prints;
    IntNode intNode;
    StringNode stringNode;
    BooleanNode booleanNode;
    IdNode idNode;

    @BeforeEach
    void setup() {
        intNode = new IntNode(100);
        stringNode = new StringNode("redPiece");
        booleanNode = new BooleanNode(true);
        idNode = new IdNode("rollDice");
        prints = new ArrayList<>();
    }


    @Test
    void shouldAcceptAnyTypeOfPrimitiveNodesAnd() {
        prints.add(intNode);
        prints.add(stringNode);
        prints.add(booleanNode);
        prints.add(idNode);

        printNode = new PrintNode(prints);

        printNode.accept(new PrettyPrinter());
    }
}