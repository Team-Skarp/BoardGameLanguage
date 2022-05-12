package ASTnodes;

import ASTvisitors.ASTvisitor;

public class DotAssignmentNode implements ASTNode<Object>{

    public FieldAccessNode fieldAccessNode;
    public ASTNode expr;

    public DotAssignmentNode(FieldAccessNode fieldAccessNode, ASTNode expr) {
        this.fieldAccessNode = fieldAccessNode;
        this.expr = expr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    public FieldAccessNode getLeft() {
        return fieldAccessNode;
    }

    public ASTNode getRight() {
        return expr;
    }
}
