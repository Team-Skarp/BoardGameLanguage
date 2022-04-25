package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringDeclarationNode implements ASTNode {

    public final IdNode id;

    public StringDeclarationNode(IdNode id) {
        this.id = id;
    }

    @Override
    public Object accept(ASTvisitor v) { return v.visit(this); }
}
