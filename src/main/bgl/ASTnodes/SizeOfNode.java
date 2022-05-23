package ASTnodes;

import ASTvisitors.ASTvisitor;

public class SizeOfNode implements ASTNode, Expression {

    public final String var;

    public SizeOfNode(String var) {
        this.var = var;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
