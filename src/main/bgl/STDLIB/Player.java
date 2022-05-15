package STDLIB;

import ASTnodes.*;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;

import java.util.List;

public class Player implements PredefinedDesign {
    @Override
    public DesignType getType() {
        return null;
    }

    /*
     * design Player {
     *     str name;
     *     list:Piece pieces;
     * }
     */
    @Override
    public DesignDefinitionNode getDesign() {
        return new DesignDefinitionNode(
                new IdNode("Player"),
                new StringDeclarationNode(
                        "name"
                ),
                new ListDeclarationNode("Piece",
                        new DesignRef("pieces")
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        return null;
    }
}
