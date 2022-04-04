package ASTnodes;

import ASTvisitors.ASTvisitor;

public class MinusNode implements ASTNode{

    public final ASTNode left;
    public final ASTNode right;

    public MinusNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}
