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
                "Player",
                new StringDeclarationNode(
                        "name"
                ),
                new ListDeclarationNode("pieces",
                        new DesignRef("Piece")
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        return null;
    }
}
