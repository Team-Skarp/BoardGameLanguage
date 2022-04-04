package ASTnodes;

import ASTvisitors.ASTvisitor;

public class DivNode implements ASTNode{

    public final ASTNode left;
    public final ASTNode right;

    public DivNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "DivNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
