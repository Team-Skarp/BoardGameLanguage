package ASTnodes;

import ASTvisitors.ASTvisitor;

public class AssignNode implements ASTNode{

    public final IdNode id;
    public final ArithmeticExpression expr;

    public AssignNode(IdNode id, ArithmeticExpression expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                "id=" + id +
                ", expr=" + expr +
                '}';
    }
}
