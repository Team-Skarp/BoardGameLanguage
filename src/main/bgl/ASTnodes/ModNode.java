package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ModNode implements ASTNode, ArithmeticExpression {

    public final ASTNode left;
    public final ASTNode right;

    public ModNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
