package ASTnodes;

import ASTvisitors.ASTvisitor;

public class DotAssignmentNode implements ASTNode<Object>{

    public FieldAccessLHNode fieldAccessLHNode;
    public ASTNode expr;

    public DotAssignmentNode(FieldAccessLHNode fieldAccessLHNode, ASTNode expr) {
        this.fieldAccessLHNode = fieldAccessLHNode;
        this.expr = expr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    public FieldAccessLHNode getLeft() {
        return fieldAccessLHNode;
    }

    public ASTNode getRight() {
        return expr;
    }
}
