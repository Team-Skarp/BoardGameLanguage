package STDLIB;

import ASTnodes.*;
import SymbolTable.types.BoolType;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;

import java.util.List;

public class Tile implements PredefinedDesign {

    @Override
    public DesignType getType() {
        //return new DesignType();
        return null;
    }

    @Override
    public DesignDefinitionNode getDesign() {
        /**
         * design Tile {
         *     Tile next;
         *     Tile prev;
         *     action isEmpty() : bool;
         *     list:Piece pieces;
         * }
         */
        return new DesignDefinitionNode(
                "Tile",
                new DesignDeclarationNode(
                        "Tile",
                        "next"
                ),
                new DesignDeclarationNode(
                        "Tile",
                        "prev"
                ),
                new ActionDeclarationNode(
                        "isEmpty",
                        new BoolType()
                ),
                new ListDeclarationNode(
                        "pieces",
                        new DesignRef("Piece")
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        /**
         * action isEmpty(Tile self) : bool {
         *     return self.pieces.length < 0
         * }
         */
        ActionDefinitionNode isEmpty = new ActionDefinitionNode(
                "isEmpty",
                new BoolType(),
                new ParameterBlock(
                        new LessThanNode(
                                new ReturnNode(
                                        new FieldAccessNode(List.of(
                                                new IdNode("self"),
                                                new IdNode("pieces"),
                                                new IdNode("length"))
                                        )
                                ),
                                new IntNode(0)
                        )
                )
        );

        return List.of(isEmpty);
    }

}
