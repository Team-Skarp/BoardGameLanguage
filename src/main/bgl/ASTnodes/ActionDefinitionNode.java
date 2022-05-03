package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ActionType;
import SymbolTable.types.TypeDenoter;

import java.util.List;

public class ActionDefinitionNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final List<Declaration> formalParameters;
    public final TypeDenoter returnType;
    public final ActionBodyNode body;

    public ActionDefinitionNode(String name, TypeDenoter returnType, ActionBodyNode body, Declaration... formalParameters) {
        this.name = name;
        this.formalParameters = List.of(formalParameters);
        this.returnType = returnType;
        this.body = body;
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
