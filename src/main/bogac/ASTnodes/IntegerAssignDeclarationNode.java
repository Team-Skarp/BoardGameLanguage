package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.IntType;
import symboltable.types.TypeDenoter;

public class IntegerAssignDeclarationNode implements ASTNode<Object>, Assignment, Declaration {

    public final String name;
    public final Expression expr;

    public IntegerAssignDeclarationNode(String name, Expression expr) {
        this.name = name;
        this.expr = expr;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public IdNode getLeft() {
        return new IdNode(name);
    }

    @Override
    public Expression getRight() {
        return expr;
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
