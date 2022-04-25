package ASTnodes;

import ASTvisitors.ASTvisitor;

public class UnaryMinusNode implements ASTNode, ArithmeticExpression {

    public ArithmeticExpression operand;

    public UnaryMinusNode(ArithmeticExpression operand) {
        this.operand = operand;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
