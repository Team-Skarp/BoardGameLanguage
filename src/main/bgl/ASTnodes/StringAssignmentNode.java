package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringAssignmentNode implements ASTNode<Object>, Assignment{

    public String varName;
    public String literal; //TODO Should this be an expression? So a function call can be the assign value

    public StringAssignmentNode(String varName, String literal) {
        this.varName = varName;
        this.literal = literal;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return new IdNode(varName);
    }

    @Override
    public IdNode getRight() {
        return new IdNode(literal);
    }
}
