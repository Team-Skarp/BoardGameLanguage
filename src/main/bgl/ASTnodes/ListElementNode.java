package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ListElementNode implements ASTNode{

    public List<ASTNode> children;

    public ListElementNode(List<ASTNode> children) {
        this.children = children;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
