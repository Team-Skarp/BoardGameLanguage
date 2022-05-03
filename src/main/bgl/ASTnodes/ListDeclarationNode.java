package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ListType;
import SymbolTable.types.TypeDenoter;

public class ListDeclarationNode implements ASTNode<Object>, Declaration {

    public String name;
    public TypeDenoter elementType;

    public ListDeclarationNode(TypeDenoter elementType, String name) {
        this.elementType = elementType;
        this.name = name;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String varName() {
        return name;
    }

    @Override
    public TypeDenoter type() {
        return new ListType(elementType);
    }
}
