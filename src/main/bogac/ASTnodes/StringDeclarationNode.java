package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.StringType;
import SymbolTable.types.TypeDenoter;

public class StringDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public ASTNode value;

    public StringDeclarationNode(String name) {
        this.name = name;
    }
    public StringDeclarationNode(String name, ASTNode value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String varName() {
        return name;
    }

    @Override
    public Object accept(ASTvisitor v) { return v.visit(this); }

    @Override
    public TypeDenoter type() {
        return new StringType();
    }


}
