package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

class InputNodeTest {
    InputNode inputNode;
    IdNode idNode;

    @Test
    void accept() {
        idNode = new IdNode("redPiece");
        inputNode = new InputNode(idNode);

        inputNode.accept(new PrettyPrinter());
    }
}