package ASTnodes;

import ASTvisitors.ASTvisitor;

public class LessThanNode implements ASTNode, BooleanExpression {
    public ASTNode left;
    public ASTNode right;

    public LessThanNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
