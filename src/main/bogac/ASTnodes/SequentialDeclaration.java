package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.TypeDenoter;

import java.util.ArrayList;
import java.util.List;

public class SequentialDeclaration implements ASTNode<Object> {

    public TypeDenoter type;
    public List<Declaration> declarations = new ArrayList<>();

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
