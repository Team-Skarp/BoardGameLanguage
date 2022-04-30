package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTypedDeclarationNodeTest {
    GridTypedDeclarationNode gridTypedDeclarationNode;
    IdNode board;

    @Test
    void accept() {
        board = new IdNode("Board");
        gridTypedDeclarationNode = new GridTypedDeclarationNode(board, "Special tile",8, 8);

        gridTypedDeclarationNode.accept(new PrettyPrinter());
    }
}