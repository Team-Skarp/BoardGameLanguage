package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDeclarationNodeTest {
    StringDeclarationNode stringDeclarationNode;
    IdNode idNode;

    @BeforeEach
    void setup() {
        idNode = new IdNode("tile");
    }

    @Test
    void acceptStringDeclarationNodeWithOnlyIdNode() {
        stringDeclarationNode = new StringDeclarationNode(idNode);

        stringDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptStringDeclarationNodeWithIdNodeAndValue() {
        stringDeclarationNode = new StringDeclarationNode(idNode, new StringNode("specialTile"));

        stringDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getIdentifier() {
        stringDeclarationNode = new StringDeclarationNode(idNode);

        assertEquals(idNode, stringDeclarationNode.getIdentifier());
    }
}