package STDLIB;

import ASTnodes.ActionDefinitionNode;
import ASTnodes.DesignDeclarationNode;
import ASTnodes.DesignDefinitionNode;
import ASTnodes.IdNode;
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
                new IdNode("Player"),
                new DesignDeclarationNode(
                        "str",
                        "name"
                ),
                new DesignDeclarationNode(
                        "Piece",
                        "pieces"
                )
        );
    }

    @Override
    public List<ActionDefinitionNode> getImplementedActions() {
        return null;
    }
}
