package ASTnodes;

import ASTvisitors.ASTvisitor;
import java.util.List;

public class FieldAccessNode implements ASTNode, Expression {

    public IdNode origin;
    public List<String> originFields;

    public FieldAccessNode(IdNode origin, List<String> originFields) {
        this.origin = origin;
        this.originFields = originFields;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
