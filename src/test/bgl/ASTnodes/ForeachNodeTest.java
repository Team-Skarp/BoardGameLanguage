package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

class ForeachNodeTest {
    IdNode idNodeNew;
    IdNode idNodeMain;
    ForeachNode foreachNode;
    BlockNode blockNodeForeach;

    @Test
    void accept() {
        idNodeNew = new IdNode("piece");
        idNodeMain = new IdNode("redPieces");
        blockNodeForeach = new BlockNode(new StringNode("\"forEachBlock\""));
        foreachNode = new ForeachNode(idNodeNew, idNodeMain, blockNodeForeach);

        foreachNode.accept(new PrettyPrinter());
    }
}