package SymbolTable.types;

public class GridType implements TypeDenoter {

    public final DesignRef type;        //Type of the tiles on the grid

    public GridType(String type) {
        this.type = new DesignRef(type);
    } //Todo: Path and Grid types don't overwrite toString(), should they?

}
