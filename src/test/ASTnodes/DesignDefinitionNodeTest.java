package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignDefinitionNodeTest {
    DesignDefinitionNode designDefinitionNode;
    IdNode typeDefinition;
    IdNode idNodeParent;

    @Test
    void acceptsWithDesignDefinitionNode() {
        typeDefinition = new IdNode("StarTile");
        idNodeParent = new IdNode("Tile");
        designDefinitionNode = new DesignDefinitionNode(typeDefinition, idNodeParent);

        designDefinitionNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsWithoutDesignDefinitionNode() {
        typeDefinition = new IdNode("StarTile");
        designDefinitionNode = new DesignDefinitionNode(typeDefinition);

        designDefinitionNode.accept(new PrettyPrinter());
    }
}