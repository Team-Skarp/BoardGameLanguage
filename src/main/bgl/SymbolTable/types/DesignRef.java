package SymbolTable.types;

/**
 * Class used to bind a variable to a name inside the type environment
 */
public class DesignRef implements TypeDenoter, SequentiallyDeclared {

    public final String name;

    public DesignRef(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
