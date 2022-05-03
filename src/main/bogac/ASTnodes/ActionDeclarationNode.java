package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.ActionType;
import symboltable.types.TypeDenoter;

import java.util.List;

public class ActionDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final List<Declaration> formalParameters;
    public final TypeDenoter returnType;

    public ActionDeclarationNode(String name, TypeDenoter returnType, Declaration... formalParameters) {
        this.name = name;
        this.formalParameters = List.of(formalParameters);
        this.returnType = returnType;
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
        return new ActionType(returnType);
    }

}
