package ASTnodes;

import ASTvisitors.ASTvisitor;

/**
 * Action definitions should have a non empty return node.
 *
 * If the action is supposed to return void, then the return value should be null
 */
public class ReturnNode implements ASTNode<Object> {

    public final Expression      returnVal;

    public ReturnNode(Expression returnVal) {
        this.returnVal = returnVal;
    }

    public ReturnNode() {
        this.returnVal = null;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
