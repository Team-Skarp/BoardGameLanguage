package ASTnodes;

import ASTvisitors.ASTvisitor;

public class RandomNode implements ASTNode {

    public final IntNode diceSize;

    public RandomNode(IntNode diceSize) {
        this.diceSize = diceSize;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
