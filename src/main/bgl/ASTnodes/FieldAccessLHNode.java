package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class FieldAccessLHNode implements ASTNode, Expression {

    public List<String> children;
    public List<ASTNode> fields;

    public FieldAccessLHNode(List<ASTNode> fields, List<String> children) {
        this.children = children;
        this.fields = fields;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
