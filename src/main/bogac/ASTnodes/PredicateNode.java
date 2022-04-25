package ASTnodes;

import ASTvisitors.ASTvisitor;

public class PredicateNode implements ASTNode{
    public ASTNode value;

    public PredicateNode(ASTNode value){
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
