package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.IntType;
import SymbolTable.types.TypeDenoter;

public class IntegerAssignDeclarationNode implements ASTNode<Object>, Assignment, Declaration {

    public final String name;
    public final ASTNode aexpr;

    public IntegerAssignDeclarationNode(String name, ASTNode aexpr) {
        this.name = name;
        this.aexpr = aexpr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String getLeft() {
        return name;
    }

    @Override
    public ASTNode getRight() {
        return aexpr;
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
