package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElseNodeTest {
    ElseNode elseNode;
    BlockNode blockNode;

    @Test
    void accept() {
        blockNode = new BlockNode("elseBlock");
        elseNode = new ElseNode(blockNode);

        elseNode.accept(new PrettyPrinter());
    }
}