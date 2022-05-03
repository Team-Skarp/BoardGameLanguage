package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.IntType;
import symboltable.types.TypeDenoter;

public class IntegerDeclarationNode implements ASTNode<Object>, Declaration {

    public String name;
    // public ASTNode value; // Why does this hava a value? commented out because it doesn't make sense

    public IntegerDeclarationNode(String name) {
        this.name = name;
    }

    /*
    public IntegerDeclarationNode(String name, ASTNode value) {
        this.name = name;
        this.value = value;
    }
    */

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
        return new IntType();
    }

}
