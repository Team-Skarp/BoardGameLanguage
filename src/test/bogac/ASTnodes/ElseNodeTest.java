package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

class ElseNodeTest {
    ElseNode elseNode;
    BlockNode blockNode;

    @Test
    void accept() {
        blockNode = new BlockNode();
        elseNode = new ElseNode(blockNode);

        elseNode.accept(new PrettyPrinter());
    }
}