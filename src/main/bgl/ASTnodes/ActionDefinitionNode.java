package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ActionType;
import SymbolTable.types.TypeDenoter;

import java.util.List;

public class ActionDefinitionNode implements ASTNode<Object>, Declaration {

    public final String name;
    public List<Declaration> formalParameters;
    public final TypeDenoter returnType;
    public final ParameterBlock body;

    public boolean isMethodDefinition = false;

    public ActionDefinitionNode(String name, TypeDenoter returnType, ParameterBlock body, Declaration... formalParameters) {
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
