package ASTnodes;

import ASTvisitors.ASTvisitor;

public class RandomNode implements ASTNode,ArithmeticExpression {

    public final ArithmeticExpression diceSize;

    public RandomNode(ArithmeticExpression diceSize) {
        this.diceSize = diceSize;
    }
    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
