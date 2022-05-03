package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.PathType;
import SymbolTable.types.TypeDenoter;

public class PathTypedDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final String tile_type;
    public final int length;
    public final String direction;

    public PathTypedDeclarationNode(String name, String tile_type, int length) {
        this.name = name;
        this.tile_type = tile_type;
        this.length = length;
        this.direction = "uni";
    }

    public PathTypedDeclarationNode(String name, String tile_type, int length, String direction) {
        this.name = name;
        this.tile_type = tile_type;
        this.length = length;
        this.direction = direction;
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
        return new PathType(tile_type);
    }
}
