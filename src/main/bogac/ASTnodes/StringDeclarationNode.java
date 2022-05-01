package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringDeclarationNode implements Declaration {
    public IdNode id;
    public ASTNode value;

    public StringDeclarationNode(IdNode id) {
        this.id = id;
    }

    public StringDeclarationNode(IdNode id, ASTNode value) {
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
