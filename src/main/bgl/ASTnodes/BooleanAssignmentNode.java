package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanAssignmentNode implements ASTNode<Object>, Assignment{

    public String name;
    public ASTNode bexpr;

    public BooleanAssignmentNode(String name, ASTNode bexpr) {
        this.name = name;
        this.bexpr = bexpr;
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
        return bexpr;
    }
}
