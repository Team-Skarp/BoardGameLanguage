package ASTnodes;

import ASTvisitors.ASTvisitor;

public class UnaryMinusNode implements ASTNode, ArithmeticExpression {

    public ASTNode operand;

    public UnaryMinusNode(ASTNode operand) {
        this.operand = operand;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
