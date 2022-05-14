package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.ArrayList;
import java.util.List;

public class ListNode implements ASTNode<Object>{

    public List<ASTNode> children;

    public ListNode(List<ASTNode> children) {
        this.children = children;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
