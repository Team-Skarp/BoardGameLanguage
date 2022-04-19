package ASTnodes;

import ASTvisitors.ASTvisitor;

public class OrNode implements ASTNode, BooleanExpression {
    public ASTNode left;
    public ASTNode right;

    public OrNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
