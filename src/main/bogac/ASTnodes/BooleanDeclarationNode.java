package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanDeclarationNode implements Declaration {
    public IdNode id;
    public ASTNode value;
    public BooleanDeclarationNode(IdNode id) {
        this.id = id;
    }
    public BooleanDeclarationNode(IdNode id, ASTNode value) {
        this.id = id;
        this.value = value;
    }
    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getIdentifier() {
        return id;
    }
}
