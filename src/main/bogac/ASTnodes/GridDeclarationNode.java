package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GridDeclarationNode implements ASTNode {
    public final IdNode id;
    public final int xSize;
    public final int ySize;

    public GridDeclarationNode(IdNode id, int xSize, int ySize) {
        this.id = id;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
