package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GreaterThanEqualsNode implements ASTNode, BooleanExpression {
    public ASTNode left;
    public ASTNode right;

    public GreaterThanEqualsNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
