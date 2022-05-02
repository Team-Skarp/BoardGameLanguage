package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GridTypedDeclarationNode implements ASTNode {
    public final IdNode id;
    public final String tileType;
    public final int xSize;
    public final int ySize;

    public GridTypedDeclarationNode(IdNode id, String tileType, int xSize, int ySize) {
        this.id = id;
        this.tileType = tileType;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
