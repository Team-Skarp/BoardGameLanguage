package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringAssignmentNode implements ASTNode<Object>, Assignment{

    public String varName;
    public String literal;

    public StringAssignmentNode(String varName, String literal) {
        this.varName = varName;
        this.literal = literal;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return null;
    }

    @Override
    public IdNode getLeft() {
        return new IdNode(varName);
    }

    @Override
    public ASTNode getRight() {
        return new IdNode(literal);
    }
}
