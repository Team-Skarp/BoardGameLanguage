package SymbolTable.types;

public class ListNodeType implements TypeDenoter {

    public TypeDenoter elementType;

    public ListNodeType(TypeDenoter elementType) {
        this.elementType = elementType;
    }

    @Override
    public String toString() {
        return ""+elementType;
    }
}
