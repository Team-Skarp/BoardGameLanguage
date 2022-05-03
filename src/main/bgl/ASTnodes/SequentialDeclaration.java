package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.SequentiallyDeclared;
import java.util.List;

public class SequentialDeclaration implements ASTNode<Object> {

    public SequentiallyDeclared type;
    public List<Declaration> declarations;

    public SequentialDeclaration(SequentiallyDeclared type, Declaration... declarations) {
        this.type = type;
        this.declarations = List.of(declarations);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
