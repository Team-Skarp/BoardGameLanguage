package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class IndexAccessNode implements ASTNode, ArithmeticExpression, Accessable {

    public String indexIn;                      //The variable to index in
    public final List<ASTNode> value;           //The value to index a[5] or a[5][1]

    public IndexAccessNode(List<ASTNode> value) {
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String getAccessName() {
        return indexIn;
    }
}
