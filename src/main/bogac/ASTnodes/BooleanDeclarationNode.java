package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanDeclarationNode implements ASTNode {
    public IdNode id;
    public ASTNode booleanExpressionChild;

    public BooleanDeclarationNode(IdNode id, ASTNode booleanExpressionChild) {
        this.id = id;
        this.booleanExpressionChild = booleanExpressionChild;
    }

    public BooleanDeclarationNode(IdNode id) {
        this.id = id;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
