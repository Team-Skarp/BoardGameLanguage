package ASTnodes;

import ASTvisitors.ASTvisitor;

public class PathDeclarationNode implements ASTNode {
    public final IdNode   id;
    public final int length;
    public final String direction;

    public PathDeclarationNode(IdNode id, int length) {
        this.id = id;
        this.length = length;
        this.direction = "uni";
    }

    public PathDeclarationNode(IdNode id, int length, String direction) {
        this.id = id;
        this.length = length;
        this.direction = direction;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
