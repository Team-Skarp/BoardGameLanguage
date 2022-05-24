package ASTnodes;

import ASTvisitors.ASTvisitor;
import java.util.List;

public class FieldAccessNode implements ASTNode, Expression, ArithmeticExpression {

    public List<Accessable> fields;

    public FieldAccessNode(List<Accessable> fields) {

        this.fields = fields;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
