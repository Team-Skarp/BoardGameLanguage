package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GridTypedDeclarationNode implements ASTNode {
    public final IdNode id;
    public final String tile_type;
    public final int x_size;
    public final int y_size;

    public GridTypedDeclarationNode(IdNode id, String tile_type, int x_size, int y_size) {
        this.id = id;
        this.tile_type = tile_type;
        this.x_size = x_size;
        this.y_size = y_size;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
