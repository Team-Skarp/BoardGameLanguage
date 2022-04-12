package ASTnodes;

import ASTvisitors.ASTvisitor;

public class PathTypedDeclarationNode implements ASTNode {
    public final IdNode   id;
    public final String tile_type;
    public final int length;
    public final String direction;

    public PathTypedDeclarationNode(IdNode id, String tile_type, int length) {
        this.id = id;
        this.tile_type = tile_type;
        this.length = length;
        this.direction = "uni";
    }

    public PathTypedDeclarationNode(IdNode id, String tile_type, int length, String direction) {
        this.id = id;
        this.tile_type = tile_type;
        this.length = length;
        this.direction = direction;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
