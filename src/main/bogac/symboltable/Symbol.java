package symboltable;

import symboltable.attributes.Attributes;

public class Symbol {

    public final String name;
    public final Attributes attrs;

    public Symbol(String name, Attributes attrs) {
        this.name = name;
        this.attrs = attrs;
    }
}
