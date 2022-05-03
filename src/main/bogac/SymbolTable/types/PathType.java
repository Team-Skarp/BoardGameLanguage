package SymbolTable.types;

public class PathType implements TypeDenoter {

    public final DesignRef type;        //Tile type of the path

    public PathType(String type) {
        this.type = new DesignRef(type);
    }
}
