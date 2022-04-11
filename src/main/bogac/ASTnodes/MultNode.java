package ASTnodes;

import ASTvisitors.ASTvisitor;

public class MultNode implements ASTNode, ArithmeticExpression {

    public final ASTNode left;
    public final ASTNode right;

    public MultNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
