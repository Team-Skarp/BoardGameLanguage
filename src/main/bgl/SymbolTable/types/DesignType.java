package SymbolTable.types;

import SymbolTable.SymbolTable;

import java.util.Objects;

public class DesignType implements TypeDenoter {

    public final String name;
    public SymbolTable fields;
    public final String parent;

    public DesignType(String name, SymbolTable fields) {
        this.name = name;
        this.fields = fields;
        this.parent = null;
    }

    public DesignType(String name, String parent, SymbolTable fields) {
        this.name = name;
        this.fields = fields;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "%s".formatted(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignType that = (DesignType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
