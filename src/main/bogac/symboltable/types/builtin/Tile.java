package symboltable.types.builtin;

import ASTnodes.*;
import symboltable.types.BoolType;
import symboltable.types.DesignRef;
import symboltable.types.DesignType;

import java.util.List;

public class Tile implements BuiltInType {

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
         *     list:Piece pieces;
         *     action isEmpty() : bool;
         * }
         */
        return new DesignDefinitionNode(
                new IdNode("Tile"),
                new DesignDeclarationNode(
                        new DesignRef("Tile"),
                        "next"
                ),
                new DesignDeclarationNode(
                        new DesignRef("Tile"),
                        "prev"
                ),
                new ListDeclarationNode(
                        new DesignRef("Piece"),
                        "pieces"
                ),
                new ActionDeclarationNode(
                        "isEmpty",
                        new BoolType()
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {

        /**
         * action isEmpty(Tile self) : bool {
         *     return self.peices.length > 0
         * }
         */
        ActionDefinitionNode isEmpty = new ActionDefinitionNode(
                "isEmpty",
                new BoolType(),
                new BlockNode("action")
                //TODO: Implemented rest of the action

        );

        return List.of(isEmpty);
    }

}
