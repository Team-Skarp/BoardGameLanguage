package ASTnodes;

import ASTvisitors.ASTvisitor;

public class PathDeclarationNode implements ASTNode {
    public final IdNode   id;
    public final Integer length;
    public final String direction;

    public PathDeclarationNode(IdNode id, Integer length) {
        this.id = id;
        this.length = length;
        this.direction = "uni";
    }

    public PathDeclarationNode(IdNode id, Integer length, String direction) {
        this.id = id;
        this.length = length;
        this.direction = direction;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
