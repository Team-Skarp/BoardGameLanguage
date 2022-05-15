package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ListNode implements ASTNode<Object>{

    public List<ASTNode> elements;

    public ListNode(List<ASTNode> elements) {
        this.elements = elements;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return "ListNode[" + elements + ']';
    }
}
