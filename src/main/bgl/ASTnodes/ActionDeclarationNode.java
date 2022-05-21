package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ActionType;
import SymbolTable.types.TypeDenoter;

import java.util.List;

public class ActionDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public List<Declaration> formalParameters;
    public final TypeDenoter returnType;

    public ActionDeclarationNode(String name, TypeDenoter returnType, Declaration... formalParameters) {
        this.name = name;
        this.returnType = returnType;
        this.formalParameters = List.of(formalParameters);
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
        return new ActionType(returnType, formalParameters);
    }

}
