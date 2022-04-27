package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerDeclarationNode implements ASTNode<Object>, Declaration {

    public  IdNode id;
    public ASTNode value;

    public IntegerDeclarationNode(IdNode id) {
        this.id = id;
    }
    public IntegerDeclarationNode(IdNode id, ASTNode value) {
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
