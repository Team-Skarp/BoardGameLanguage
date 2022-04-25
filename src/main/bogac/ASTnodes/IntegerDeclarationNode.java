package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerDeclarationNode implements ASTNode<Object>, Declaration {

    public final IdNode    id;

    public IntegerDeclarationNode(IdNode identifier) {
        this.id = identifier;
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
