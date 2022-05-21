package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class IndexAccessNode implements ASTNode, ArithmeticExpression {
    public List<String> childrenAsString;
    public List<ASTNode> childrenAsASTNode;

    public IndexAccessNode(List<String> childrenAsString, List<ASTNode> childrenAsASTNode) {
        this.childrenAsString = childrenAsString;
        this.childrenAsASTNode = childrenAsASTNode;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return childrenAsString.toString();
    }
}
