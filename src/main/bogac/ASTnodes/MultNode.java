package ASTnodes;

import ASTvisitors.ASTvisitor;

public class MultNode implements ASTNode {

    public final ASTNode left;
    public final ASTNode right;

    public MultNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
