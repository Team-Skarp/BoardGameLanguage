package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GreaterThanNode implements ASTNode {
    public ASTNode left;
    public ASTNode right;

    public GreaterThanNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
