package SymbolTable;

import SymbolTable.types.TypeDenoter;

public class Symbol {

    public final String name;
    public final TypeDenoter type;
    public int value;

    public Symbol(String name, TypeDenoter type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Special constructor just for integer and list symbols
     * entered with a value (or list size)
     */
    public Symbol(String name, TypeDenoter type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }
}
