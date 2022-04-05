package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntNode implements ASTNode{

    public int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
