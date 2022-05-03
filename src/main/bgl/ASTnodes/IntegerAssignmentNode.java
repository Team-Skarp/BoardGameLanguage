package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerAssignmentNode implements ASTNode<Object>, Assignment{

    public String name;
    public ASTNode aexpr;

    public IntegerAssignmentNode(String name, ASTNode aexpr) {
        this.name = name;
        this.aexpr = aexpr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String getLeft() {
        return name;
    }

    @Override
    public ASTNode<?> getRight() {
        return aexpr;
    }
}
