package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.ActionType;
import symboltable.types.TypeDenoter;

import java.util.List;

public class ActionDefinitionNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final List<Declaration> formalParameters;
    public final TypeDenoter returnType;
    public final BlockNode body;

    public ActionDefinitionNode(String name, List<Declaration> formalParameters, TypeDenoter returnType, BlockNode body) {
        this.name = name;
        this.formalParameters = formalParameters;
        this.returnType = returnType;
        this.body = body;
    }

    public ActionDefinitionNode(String name, TypeDenoter returnType, BlockNode body) {
        this.name = name;
        this.formalParameters = null;
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
