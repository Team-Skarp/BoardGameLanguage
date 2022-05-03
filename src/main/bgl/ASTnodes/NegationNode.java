package ASTnodes;

import ASTvisitors.ASTvisitor;

public class NegationNode implements ASTNode, BooleanExpression {
    public ASTNode child;

    public NegationNode(ASTNode child) {
        this.child = child;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
