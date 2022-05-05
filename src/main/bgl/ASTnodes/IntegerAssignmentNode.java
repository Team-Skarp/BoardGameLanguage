package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerAssignmentNode implements ASTNode<Object>, Assignment{

    public IdNode id;
    public ArithmeticExpression aexpr;

    public IntegerAssignmentNode(IdNode id, ArithmeticExpression aexpr) {
        this.id = id;
        this.aexpr = aexpr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return id;
    }

    @Override
    public ASTNode getRight() {
        return aexpr;
    }
}
