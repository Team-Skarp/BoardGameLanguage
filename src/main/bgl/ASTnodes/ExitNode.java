package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ExitNode implements ASTNode<Object> {

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
