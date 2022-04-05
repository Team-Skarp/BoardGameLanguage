package ASTnodes;

import ASTvisitors.ASTvisitor;

public class NegationNode implements ASTNode {
    public ASTNode child;

    public NegationNode(ASTNode child) {
        this.child = child;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
