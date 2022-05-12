package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class DesignAssignmentNode implements ASTNode<Object>, Assignment {

    public final IdNode parentType;              //*Optional parent type when extending from another type
    public List<Declaration> fields;             //Fields of the design definition

    public DesignAssignmentNode(IdNode parentType, Declaration... fields) {
        this.parentType = parentType;
        this.fields = List.of(fields);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return parentType;
    }

    @Override
    public ASTNode getRight() {
        return (ASTNode) fields;
    }
}
