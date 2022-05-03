package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.GridType;
import SymbolTable.types.TypeDenoter;

public class GridTypedDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final String tile_type;
    public final int x_size;
    public final int y_size;

    public GridTypedDeclarationNode(String name, String tile_type, int x_size, int y_size) {
        this.name = name;
        this.tile_type = tile_type;
        this.x_size = x_size;
        this.y_size = y_size;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String varName() {
        return name;
    }

    @Override
    public TypeDenoter type() {
        return new GridType(tile_type);
    }
}
