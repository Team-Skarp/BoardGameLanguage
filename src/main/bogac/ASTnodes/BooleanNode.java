package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanNode implements ASTNode{
    public boolean value;

    public BooleanNode(boolean value){
        this.value = value;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
