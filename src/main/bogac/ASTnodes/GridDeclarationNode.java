package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.GridType;
import SymbolTable.types.TypeDenoter;

public class GridDeclarationNode implements ASTNode<Object>, Declaration {
    public final String name;
    public final int x_size;
    public final int y_size;

    public GridDeclarationNode(String name, int x_size, int y_size) {
        this.name = name;
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
        return new GridType("Tile");
    }
}
