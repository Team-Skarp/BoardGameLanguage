package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanNode implements ASTNode{
    public boolean value;

    public BooleanNode(boolean value){
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
