package STDLIB;

import ASTnodes.*;
import SymbolTable.types.BoolType;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;

import java.util.List;

public class Tile implements PredefinedDesign {

    @Override
    public DesignDefinitionNode getDesign() {
        /**
         * design Tile {
         *     bool back_track_allowed;   //Flag for specifying if back track is allowed for pieces
         *     int p_count                //Counter for how many pieces are on this tile
         *     Tile next;                 //Points to the next tile in the chain
         *     Tile prev;                 //Points to the previous tile in the chain
         * }
         */
        return new DesignDefinitionNode(
                "Tile",
                new BooleanDeclarationNode(
                  "back_track_allowed"
                ),
                new IntegerDeclarationNode(
                  "p_count"
                ),
                new DesignDeclarationNode(
                        "Tile",
                        "next"
                ),
                new DesignDeclarationNode(
                        "Tile",
                        "prev"
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        return List.of();
    }

}
