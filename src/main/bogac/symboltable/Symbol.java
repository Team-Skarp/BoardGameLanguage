package symboltable;

import symboltable.types.TypeDenoter;

public class Symbol {

    public final String name;
    public final TypeDenoter type;

    public Symbol(String name, TypeDenoter type) {
        this.name = name;
        this.type = type;
    }

}
