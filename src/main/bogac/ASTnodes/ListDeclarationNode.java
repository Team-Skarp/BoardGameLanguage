package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.TypeDenoter;

public class ListDeclarationNode implements ASTNode<Object>, Declaration {

    public TypeDenoter elementType;
    public IdNode      id;

    public ListDeclarationNode(TypeDenoter elementType, IdNode id) {
        this.elementType = elementType;
        this.id = id;
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
