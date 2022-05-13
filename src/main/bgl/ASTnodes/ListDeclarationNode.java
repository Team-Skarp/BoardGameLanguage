package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ListType;
import SymbolTable.types.TypeDenoter;

import java.util.List;

public class ListDeclarationNode implements ASTNode<Object>, Declaration {

    public String name;
    public TypeDenoter elementType;
    public List<ASTNode> children;

    public ListDeclarationNode(String name, TypeDenoter elementType) {
        this.name = name;
        this.elementType = elementType;
    }

    public ListDeclarationNode(String name, TypeDenoter elementType, List<ASTNode> children) {
        this.name = name;
        this.elementType = elementType;
        this.children = children;
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
