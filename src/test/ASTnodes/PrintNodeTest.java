package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.types.ActionType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        idNode = new IdNode("rollDice", new ActionType());
        prints = new ArrayList<>();
    }


    @Test
    void accept() {
        prints.add(intNode);
        prints.add(stringNode);
        prints.add(booleanNode);
        prints.add(idNode);

        printNode = new PrintNode(prints);

        printNode.accept(new PrettyPrinter());
    }
}