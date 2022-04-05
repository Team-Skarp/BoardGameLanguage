package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntNode implements ASTNode{

    public int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
