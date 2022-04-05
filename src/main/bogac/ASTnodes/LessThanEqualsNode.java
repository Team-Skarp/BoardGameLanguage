package ASTnodes;

import ASTvisitors.ASTvisitor;

public class LessThanEqualsNode implements ASTNode {
    public ASTNode left;
    public ASTNode right;

    public LessThanEqualsNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
