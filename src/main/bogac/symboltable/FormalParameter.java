package symboltable;

import symboltable.types.TypeDenoter;

public class FormalParameter {

    public final String name;
    public final TypeDenoter type;

    public FormalParameter(String name, TypeDenoter type) {
        this.name = name;
        this.type = type;
    }
}
