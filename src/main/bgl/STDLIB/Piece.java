package STDLIB;

import ASTnodes.*;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;
import SymbolTable.types.VoidType;

import java.util.List;

public class Piece implements PredefinedDesign {

    @Override
    public DesignType getType() {
        // return new DesignType();
        return null;
    }

    /*
     * design Piece {
     *   str color
     *   action move(): void;
     *   action jump(): void;
     */

    @Override
    public DesignDefinitionNode getDesign() {
        return new DesignDefinitionNode(
                new IdNode("Piece"),
                new DesignDeclarationNode(
                        new DesignRef("Piece"),
                        "color"
                ),
                new ActionDeclarationNode(
                        "move",
                        new VoidType()
                ),
                new ActionDeclarationNode(
                        "jump",
                        new VoidType()
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {

        /*
         * action move(piece): void {
         *     piece.tile.next TODO: write correct code
         * }
         */
        ActionDefinitionNode move = new ActionDefinitionNode(
                "move",
                new VoidType(),
                new ActionBodyNode()
        );

        /*
         * action jump(piece): void {
         *     piece.tile.next TODO: write correct code
         * }
         */
        ActionDefinitionNode jump = new ActionDefinitionNode(
                "jump",
                new VoidType(),
                new ActionBodyNode()
        );

        return List.of(move, jump);
    }
}