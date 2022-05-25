package STDLIB;

import ASTnodes.*;
import SymbolTable.types.VoidType;

import java.util.List;

public class Piece implements PredefinedDesign {

    /**
     * 'Not a Piece' instance is an empty instance of a Tile design
     * with uninitialised values, used to fill in blanks in a piece list.
     */
    /*public DesignDeclarationNode NAP() {
        return new DesignDeclarationNode(
          "Piece",
          "_NAP",
          List.of(new IntNode(0).toString())
        );
    }*/
    /**
     * design Piece {
     *   int id;                    //Uniquie identifier
     *   Tile position;             //Points to the tile that this piece is in
     *   action move(int steps);    //Action to move a specified number of steps.
     *   action jump(Tile to);      //Action to jump to a specified tile
     */
    @Override
    public DesignDefinitionNode getDesign() {
        return new DesignDefinitionNode(
                "Piece",
                new IntegerDeclarationNode(
                  "id"
                ),
                new DesignDeclarationNode(
                  "Tile", "position"
                ),
                new ActionDeclarationNode(
                    "move",
                  new VoidType(),
                  new IntegerDeclarationNode(
                    "steps"
                  )
                ),
                new ActionDeclarationNode(
                    "jump",
                  new VoidType(),
                  new DesignDeclarationNode(
                      "Tile", "to"
                  )
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {

        /**
         * @Action to jump to a piece from one position to another.
         * action jump(Piece self, Tile to) {
         *   self.position = to;                    //Update position to destination tile
         *   to.p_count = to.p_count + 1;           //Update piece count of destination
         * }
         */
        ActionDefinitionNode jump = new ActionDefinitionNode(
          "jump",
          new VoidType(),
          new ParameterBlock(
            new DotAssignmentNode(
              new FieldAccessLHNode(
                List.of(new IdNode("self"), new IdNode("position"))
              ),
              new IdNode("to")
            ),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("to"), new IdNode("p_count"))),
              new PlusNode(
                new FieldAccessNode(List.of(new IdNode("to"), new IdNode("p_count"))),
                new IntNode(1)
              )
            )
          ),
          new DesignDeclarationNode(
            "Piece", "self"
          ),
          new DesignDeclarationNode(
            "Tile", "to"
          )
        );

        /**
         * @Action to move a number of steps following the flow of the path this piece is in.
         * action move(Piece self, int steps) {
         *   int i = 0;
         *   while (i < steps) {
         *     self.jump(self.position.next);       //Jumps to the tile pointed to by next on the current position
         *   }
         * }
         */
        ActionDefinitionNode move = new ActionDefinitionNode(
          "move",
          new VoidType(),
          new ParameterBlock(
            new IntegerDeclarationNode("i", new IntNode(0)),
            new WhileNode(
              new LessThanNode(new IdNode("i"), new IdNode("steps")),
              new BlockNode(
                new FieldAccessNode(
                  List.of(
                    new IdNode("self"),
                    new MethodCallNode("jump", "self",
                      List.of(new FieldAccessNode(List.of(new IdNode("self"), new IdNode("position"), new IdNode("next"))))))
                )
              )
            )
          ),
          new DesignDeclarationNode(
            "Piece", "self"
          ),
          new IntegerDeclarationNode(
            "steps"
          )
        );

        return List.of(move, jump);
    }
}
