package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntNode implements ASTNode, ArithmeticExpression {

    public int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                '}';
    }
}
