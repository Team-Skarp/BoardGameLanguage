package SymbolTable.types;

import ASTnodes.Declaration;

import java.util.List;

public class ActionType implements TypeDenoter {

    public final TypeDenoter returnType;
    public List<Declaration> formalParameters;

    public ActionType(TypeDenoter returnType, List<Declaration> formalParams) {
        this.returnType = returnType;
        this.formalParameters = formalParams;
    }
    public ActionType(TypeDenoter returnType, Declaration... param) {
        this.returnType = returnType;
        this.formalParameters = List.of(param);
    }

    @Override
    public String toString() {
        return "action";
    }
}
