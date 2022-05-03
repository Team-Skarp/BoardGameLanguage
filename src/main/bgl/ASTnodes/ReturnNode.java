package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ReturnNode implements ASTNode<Object> {

    public final Expression      returnVal;

    public ReturnNode(Expression returnVal) {
        this.returnVal = returnVal;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
