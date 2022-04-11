package ASTnodes;

import ASTvisitors.ASTvisitor;

public class IntegerDeclarationNode implements ASTNode {

    public final IdNode    id;

    public IntegerDeclarationNode(IdNode identifier) {
        this.id = identifier;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
