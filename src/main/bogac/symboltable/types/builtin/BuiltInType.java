package symboltable.types.builtin;

import ASTnodes.ActionDefinitionNode;
import ASTnodes.DesignDefinitionNode;
import symboltable.types.DesignType;

import java.util.List;

public interface BuiltInType {

    DesignType                  getType();
    DesignDefinitionNode        getDesign();
    List<ActionDefinitionNode>  getImplementedActions();

}
