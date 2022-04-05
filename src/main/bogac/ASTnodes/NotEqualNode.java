package ASTnodes;

import ASTvisitors.ASTvisitor;

public class NotEqualNode implements ASTNode {
    public ASTNode left;
    public ASTNode right;

    public NotEqualNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
