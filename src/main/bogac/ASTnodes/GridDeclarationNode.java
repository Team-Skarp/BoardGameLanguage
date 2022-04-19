package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GridDeclarationNode implements ASTNode {
    public final IdNode id;
    public final int x_size;
    public final int y_size;

    public GridDeclarationNode(IdNode id, int x_size, int y_size) {
        this.id = id;
        this.x_size = x_size;
        this.y_size = y_size;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
