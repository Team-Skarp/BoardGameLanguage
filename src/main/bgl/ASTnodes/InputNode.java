package ASTnodes;

import ASTvisitors.ASTvisitor;

public class InputNode implements ASTNode{

    public IdNode inputVariableName;

    public InputNode(IdNode inputVariableName){
        this.inputVariableName = inputVariableName;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
