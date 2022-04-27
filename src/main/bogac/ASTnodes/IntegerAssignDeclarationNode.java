package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerAssignDeclarationNode implements ASTNode<Object>, Assignment, Declaration {

    public IdNode     id;
    public Expression expr;

    public IntegerAssignDeclarationNode(IdNode id, Expression expr) {
        this.id = id;
        this.expr = expr;
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
    public Expression getRight() {
        return expr;
    }

    @Override
    public IdNode getIdentifier() {
        return id;
    }
}
