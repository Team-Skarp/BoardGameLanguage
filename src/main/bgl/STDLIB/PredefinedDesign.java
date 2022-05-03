package STDLIB;

import ASTnodes.ActionDefinitionNode;
import ASTnodes.DesignDefinitionNode;
import SymbolTable.types.DesignType;

import java.util.List;

public interface PredefinedDesign {

    DesignType                  getType();
    DesignDefinitionNode        getDesign();
    List<ActionDefinitionNode>  getImplementedActions();

}
