package STDLIB;

import ASTnodes.*;
import SymbolTable.types.DesignRef;
import SymbolTable.types.DesignType;
import SymbolTable.types.PathType;

import java.util.List;

public class Path implements PredefinedDesign {

    @Override
    public DesignType getType() {
        return null;
    }

    @Override
    public DesignDefinitionNode getDesign() {


        /*
         * design Path {
         *      Tile tile;
         *      str direction;
         *      Path:MyTile next;
         *      Path prev;
         *      action getNext() : Path;
         *      action getPrev() : Path;
         */
        return new DesignDefinitionNode(
                new IdNode("Path"),
                new DesignDeclarationNode(
                        "Tile",
                        "tile"
                ),
                new DesignDeclarationNode(
                        "str",
                        "direction"
                ),
                new DesignDeclarationNode(
                        "Path",
                        "next"
                ),
                new DesignDeclarationNode(
                        "Path",
                        "prev"
                ),
                new ActionDeclarationNode(
                        "getNext",
                        new PathType("") // TODO: ask jakob about string param
                ),
                new ActionDeclarationNode(
                        "getPrev",
                        new PathType("") // TODO: ask jakob about string param
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {


        /*
         * // return pointer to prev node
         * bi_node* get_prev_bi_node(bi_node node) {
         *     if (node.prev != NULL) {
         *         return node.prev;
         *     }
         *     return node.prev;
         * }
         */

        ActionDefinitionNode getNext = new ActionDefinitionNode(
                "getNext",
                new PathType(""), // TODO: ask jakob about string param
                new ParameterBlock() // TODO: Implement rest of action
        );


        /*
         * // return pointer to next node
         * bi_node* get_next_bi_node(bi_node node) {
         *      if (node.next != NULL) {
         *          return node.next;
         *      }
         *      return node.prev;
         * }
         * */
        ActionDefinitionNode getPrev = new ActionDefinitionNode(
                "getPrev",
                new PathType(""), // TODO: ask jakob about string param
                new ParameterBlock(

                ) // TODO: ask jakob about string param
        );
        return null;
    }
}
