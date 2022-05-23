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
                "Piece",
                new StringDeclarationNode(
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
         * action move(Piece self): void {
         *     piece.tile.next TODO: write correct code
         * }
         */
        ActionDefinitionNode move = new ActionDefinitionNode(
                "move",
                new VoidType(),
                new ParameterBlock()
        );

        /*
         * action jump(piece): void {
         *     piece.tile.next TODO: write correct code
         * }
         */
        ActionDefinitionNode jump = new ActionDefinitionNode(
                "jump",
                new VoidType(),
                new ParameterBlock()
        );

        return List.of(move, jump);
    }
}
