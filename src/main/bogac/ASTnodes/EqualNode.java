package ASTnodes;

import ASTvisitors.ASTvisitor;

public class EqualNode implements ASTNode {
    public ASTNode left;
    public ASTNode right;

    public EqualNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
