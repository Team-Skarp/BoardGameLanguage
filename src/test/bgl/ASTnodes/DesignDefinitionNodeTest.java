package ASTnodes;

import ASTnodes.DesignDefinitionNode;
import ASTnodes.IdNode;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignDefinitionNodeTest {
    DesignDefinitionNode designDefinitionNode;
    IdNode typeDefinition;
    IdNode idNodeParent;

    @Test
    void acceptsWithDesignDefinitionNode() {
        designDefinitionNode = new DesignDefinitionNode("StarTile", "Tile");

        designDefinitionNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsWithoutDesignDefinitionNode() {
        designDefinitionNode = new DesignDefinitionNode("StarTile");

        designDefinitionNode.accept(new PrettyPrinter());
    }
}