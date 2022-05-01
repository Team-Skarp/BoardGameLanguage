package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathDeclarationNodeTest {
    PathDeclarationNode pathDeclarationNode;
    IdNode idNode;

    @BeforeEach
    void setup() {
        idNode = new IdNode("Path");
    }

    @Test
    void acceptWithSelfDesignedPathDirection() {
        pathDeclarationNode = new PathDeclarationNode(idNode, 52, "uni");

        pathDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptWithoutSelfDesignedPathDirection() {
        pathDeclarationNode = new PathDeclarationNode(idNode, 52);

        pathDeclarationNode.accept(new PrettyPrinter());
    }
}