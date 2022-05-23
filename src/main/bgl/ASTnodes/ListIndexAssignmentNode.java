package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ListIndexAssignmentNode implements ASTNode<Object>, Assignment {
    public List<String> children;
    public IdNode left;
    public ASTNode right;
    public String varNameOfIndex;
    public int valueOfIndex;

    public ListIndexAssignmentNode(List<String> children, String varNameOfIndex, int valueOfIndex) {
        this.children = children;
        this.varNameOfIndex = varNameOfIndex;
        this.valueOfIndex = valueOfIndex;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }


    @Override
    public IdNode getLeft() {
        return left;
    }

    @Override
    public ASTNode getRight() {
        return right;
    }
}
