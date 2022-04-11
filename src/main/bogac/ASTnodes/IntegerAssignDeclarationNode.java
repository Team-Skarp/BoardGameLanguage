package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerAssignDeclarationNode implements ASTNode {

    public final IdNode     id;
    public final ASTNode expr;

    public IntegerAssignDeclarationNode(IdNode id, ASTNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
