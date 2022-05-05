package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanAssignmentNode implements ASTNode<Object>, Assignment{

    public String varName;
    public BooleanExpression bexpr;

    public BooleanAssignmentNode(String varName, BooleanExpression bexpr) {
        this.varName = varName;
        this.bexpr = bexpr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return new IdNode(varName);
    }

    @Override
    public ASTNode getRight() {
        return bexpr;
    }
}
