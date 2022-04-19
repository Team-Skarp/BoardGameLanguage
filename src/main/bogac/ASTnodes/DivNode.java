package ASTnodes;

import ASTvisitors.ASTvisitor;

public class DivNode implements ASTNode, ArithmeticExpression {

    public final ASTNode left;
    public final ASTNode right;

    public DivNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "DivNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
