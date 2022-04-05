package ASTnodes;

import ASTvisitors.ASTvisitor;

public class AndNode implements ASTNode {
    public ASTNode left;
    public ASTNode right;

    public AndNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
