package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridDeclarationNodeTest {
    IdNode board;
    GridDeclarationNode gridDeclarationNode;

    @Test
    void accept() {
        board = new IdNode("Board");
        gridDeclarationNode = new GridDeclarationNode(board, 8, 8);

        gridDeclarationNode.accept(new PrettyPrinter());
    }
}