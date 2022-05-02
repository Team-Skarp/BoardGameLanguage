package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTypedDeclarationNodeTest {
    PathTypedDeclarationNode pathTypedDeclarationNode;
    IdNode idNode;

    @BeforeEach
    void setup() {
        idNode = new IdNode("Path");
    }

    @Test
    void acceptWithSelfDesignedPathDirection() {
        pathTypedDeclarationNode = new PathTypedDeclarationNode(idNode, "normal", 52);

        pathTypedDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptWithoutSelfDesignedPathDirection() {
        pathTypedDeclarationNode = new PathTypedDeclarationNode(idNode, "special", 52, "uni");

        pathTypedDeclarationNode.accept(new PrettyPrinter());
    }
}