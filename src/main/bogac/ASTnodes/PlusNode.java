package ASTnodes;

import ASTvisitors.ASTvisitor;

public class PlusNode implements ASTNode{

    public final ASTNode left;
    public final ASTNode right;

    public PlusNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "PlusNode";
    }
}
