package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ModNode implements ASTNode{

    public final ASTNode left;
    public final ASTNode right;

    public ModNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
