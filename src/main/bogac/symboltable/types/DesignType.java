package symboltable.types;

public class DesignType implements TypeDenoter {

    public final String id;

    public DesignType(String id) {
        this.id = id;
    }

    public DesignType() {
        this.id = null;
    }

    @Override
    public String toString() {
        return "design";
    }
}
