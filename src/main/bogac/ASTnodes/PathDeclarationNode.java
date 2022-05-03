package ASTnodes;

import ASTvisitors.ASTvisitor;
import symboltable.types.DesignRef;
import symboltable.types.PathType;
import symboltable.types.TypeDenoter;

public class PathDeclarationNode implements ASTNode<Object>, Declaration {

    public final String name;
    public final Integer length;
    public final String direction;

    public PathDeclarationNode(String name, Integer length) {
        this.name = name;
        this.length = length;
        this.direction = "uni";
    }

    public PathDeclarationNode(String name, Integer length, String direction) {
        this.name = name;
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
        return new PathType("Tile");
    }
}
