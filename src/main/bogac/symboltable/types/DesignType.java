package symboltable.types;

import symboltable.SymbolTable;

import java.util.Objects;

public class DesignType implements TypeDenoter {

    public final String name;
    public SymbolTable fields;
    public final String parrent;

    public DesignType(String name, SymbolTable fields) {
        this.name = name;
        this.fields = fields;
        this.parrent = null;
    }

    public DesignType(String name, String parrent, SymbolTable fields) {
        this.name = name;
        this.fields = fields;
        this.parrent = parrent;
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
