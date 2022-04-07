package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ArithmeticNode implements ASTNode {
    public ASTNode child;

    public ArithmeticNode(ASTNode child) {
        this.child = child;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
