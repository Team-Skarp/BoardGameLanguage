package symboltable.attributes;

import symboltable.SymbolTable;
import symboltable.types.DesignType;
import symboltable.types.TypeDenoter;

/**
 * Describes the attributes necassary to store information for a design.
 *
 * Consists of a seperate symbol table for storing field information.
 */
public class DesignAttributes implements Attributes {

    public SymbolTable fields;

    public DesignAttributes(SymbolTable fields) {
        this.fields = fields;
    }

    @Override
    public TypeDenoter thisType() {
        return new DesignType();
    }
}
