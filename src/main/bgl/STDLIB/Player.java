package STDLIB;

import ASTnodes.*;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;

import java.util.List;

public class Player implements PredefinedDesign {

    /**
     * design Player {
     *     int id;
     *     str name;
     *     list:Piece pieces;
     * }
     */
    @Override
    public DesignDefinitionNode getDesign() {
        return new DesignDefinitionNode(
                "Player",
                new IntegerDeclarationNode(
                  "id"
                ),
                new StringDeclarationNode(
                        "name"
                ),
                new ListDeclarationNode(
                  "pieces",
                  new DesignRef("Piece")
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        return List.of();
    }
}
