package ASTnodes;

import ASTvisitors.ASTvisitor;
import java.util.List;

public class FieldAccessNode implements ASTNode, Expression, ArithmeticExpression {

    public List<ASTNode> fields;

    public FieldAccessNode(List<ASTNode> fields) {

        this.fields = fields;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
