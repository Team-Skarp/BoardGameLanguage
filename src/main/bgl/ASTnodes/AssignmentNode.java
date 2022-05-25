package ASTnodes;

import ASTvisitors.ASTvisitor;

public class AssignmentNode implements ASTNode<Object>, Assignment {

    public final String name;
    public final Expression expression;

    public AssignmentNode(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return new IdNode(name); // Todo: change to String at some point
    }

    @Override
    public ASTNode getRight() {
        return expression;
    }
}
