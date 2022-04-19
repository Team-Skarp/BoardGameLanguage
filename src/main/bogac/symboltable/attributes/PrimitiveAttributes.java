package symboltable.attributes;

import symboltable.types.Primitive;
import symboltable.types.TypeDenoter;

/**
 * Attributes used to describe a simple primitive type declaration containing only identifier type
 *
 * ex. int, bool, str
 */
public class PrimitiveAttributes implements Attributes {

    public Primitive type; //Reference to one of the primitive type denoters

    public PrimitiveAttributes(Primitive type) {
        this.type = type;
    }

    @Override
    public TypeDenoter thisType() {
        return this.type;
    }
}
