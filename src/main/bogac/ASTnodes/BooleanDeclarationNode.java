package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.BoolType;
import SymbolTable.types.TypeDenoter;

public class BooleanDeclarationNode implements ASTNode<Object>, Declaration {
    public String name;
    public ASTNode value;

    public BooleanDeclarationNode(String name) {
        this.name = name;
    }
    public BooleanDeclarationNode(String name, ASTNode value) {
        this.name = name;
        this.value = value;
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
        return new BoolType();
    }


}
