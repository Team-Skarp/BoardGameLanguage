package SymbolTable.types;

public class ListType implements TypeDenoter {

    public TypeDenoter elementType;

    public ListType(TypeDenoter elementType) {
        this.elementType = elementType;
    }

    @Override
    public String toString() {
        return "list:"+elementType;
    }
}
