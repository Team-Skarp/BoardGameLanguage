package ASTnodes;

import ASTvisitors.ASTvisitor;

public class AndNode implements ASTNode, BooleanExpression {
    public ASTNode left;
    public ASTNode right;

    public AndNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
