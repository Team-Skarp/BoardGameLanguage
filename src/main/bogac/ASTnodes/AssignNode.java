package ASTnodes;

import ASTvisitors.ASTvisitor;
import antlr.BoardVisitor;

public class AssignNode implements ASTNode{

    public final IdNode id;
    public final ExprNode expr;

    public AssignNode(IdNode id, ExprNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "AssignNode{" +
                "id=" + id +
                ", expr=" + expr +
                '}';
    }
}
