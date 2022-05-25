package STDLIB;

import ASTnodes.*;
import SymbolTable.types.DesignRef;
import SymbolTable.types.VoidType;

import java.util.List;

/**
 * This class serves to create a linked path of tiles to act as a game surface for your game
 */
public class Path implements PredefinedDesign {

    @Override
    public DesignDefinitionNode getDesign() {

      /**
       * design Path {
       *      int dirType;      // uni->0, bi->1, static->2
       *      int length;       // Size of path
       *      Tile head;        // Points to the first tile on the path
       *      Tile tail;        // Points to the last tile on the path
       *      action _pinit();  // Action to initialise the path
       *      list:Tile tiles;  // List of tiles contained in the path
       */
        return new DesignDefinitionNode(
                "Path",
                new IntegerDeclarationNode(
                        "dirType"
                ),
                new IntegerDeclarationNode(
                        "length"
                ),
                new DesignDeclarationNode(
                        "Tile",
                        "head"
                ),
                new DesignDeclarationNode(
                        "Tile",
                        "tail"
                ),
                new ActionDeclarationNode(
                        "_pinit",
                        new VoidType()
                ),
                new ListDeclarationNode(
                  "tiles",
                  new DesignRef("Tile")
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {

        /**
         * //Initialises the path with given amount of tiles following a specified direction
         * action _pinit (Path self) {
         *     bool bta = false;    //Flag if back traversal is allowed
         *     if (dirType == 1) { bta = true }
         *     else { bta = false }
         *     Tile tile = {bta}
         *
         *     self.head = tile;
         *     self.tail = tile;
         *     self.tiles[1] = tile; <--
         *
         *     int i = 2;
         *     while (i <= self.length) {
         *         tile.prev = self.tail;
         *         self.tail.next = tile;
         *         self.tail = tile
         *         self.tiles[i] = tile;
         *     }
         *     int len = self.length;
         *     self.tiles[1].prev = self.tiles[len]; <--
         *     self.tiles[len].next = self.tiles[1]; <--
         * }
         */
        ActionDefinitionNode _pinit = new ActionDefinitionNode(
          "_pinit",
          new VoidType(),
          new ParameterBlock(
            new BooleanDeclarationNode(
              "bta",
              new BooleanNode(false)
            ),
            new ConditionalNode(
              new EqualNode(new IdNode("dirType"), new IntNode(1)),
              new BlockNode(new AssignmentNode("bta", new BooleanNode(true))),
              new BlockNode(new AssignmentNode("bta", new BooleanNode(false)))
            ),
            new DesignDeclarationNode("Tile", "tile", List.of("bta")),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("head"))),
              new IdNode("tile")
            ),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tail"))),
              new IdNode("tile")
            ),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles", List.of(new IntNode(1))))),
              new IdNode("tile")
            ),
            new IntegerDeclarationNode("i", new IntNode(2)),
            new WhileNode(
              new LessThanEqualsNode(new IdNode("i"), new FieldAccessNode(List.of(new IdNode("self"), new IdNode("length")))),
              new BlockNode(
                new DotAssignmentNode(
                  new FieldAccessLHNode(List.of(new IdNode("tile"), new IdNode("prev"))),
                  new FieldAccessNode(List.of(new IdNode("self"), new IdNode("tail")))
                ),
                new DotAssignmentNode(
                  new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tail"), new IdNode("next"))),
                  new IdNode("tile")
                ),
                new DotAssignmentNode(
                  new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tail"))),
                  new IdNode("tile")
                ),
                new DotAssignmentNode(
                  new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles",List.of(new IdNode("i"))), new IdNode("next"))),
                  new IdNode("tile")
                )
              )
            ),
            new IntegerDeclarationNode(
              "len",
              new FieldAccessNode(List.of(new IdNode("self"), new IdNode("length")))
            ),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles", List.of(new IntNode(1))), new IdNode("prev"))),
              new FieldAccessNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles",List.of(new IdNode("len")))))
            ),
            new DotAssignmentNode(
              new FieldAccessLHNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles",List.of(new IdNode("len"))), new IdNode("next"))),
              new FieldAccessNode(List.of(new IdNode("self"), new IdNode("tiles"), new IndexAccessNode("tiles",List.of(new IntNode(1)))))
            )
          ),
          new DesignDeclarationNode(
            "Path", "self"
          )
        );

        return List.of(_pinit);
    }
}
