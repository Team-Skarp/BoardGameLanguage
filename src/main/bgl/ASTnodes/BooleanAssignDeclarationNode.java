package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.BoolType;
import SymbolTable.types.TypeDenoter;

public class BooleanAssignDeclarationNode implements ASTNode<Object>, Assignment, Declaration {

    public final String name;
    public final BooleanExpression bexpr;

    public BooleanAssignDeclarationNode(String name, BooleanExpression bexpr) {
        this.name = name;
        this.bexpr = bexpr;
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
    public Expression getRight() {
        return bexpr;
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
