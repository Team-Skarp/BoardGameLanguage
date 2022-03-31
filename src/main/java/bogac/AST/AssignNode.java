package AST;

import autogen.BoardVisitor;

public class AssignNode implements ASTNode{

    public final IdNode id;
    public final ExprNode expr;

    public AssignNode(IdNode id, ExprNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public void accept(BoardVisitor v) {

    }
}
