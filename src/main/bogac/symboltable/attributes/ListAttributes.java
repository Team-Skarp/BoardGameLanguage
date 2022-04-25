package symboltable.attributes;

import symboltable.types.ListType;
import symboltable.types.TypeDenoter;

/**
 * Attributes to describe a list declaration
 */
public class ListAttributes implements Attributes {

    public TypeDenoter elementType;     //Type of the elements found in the list
    public int size;                    //Size of the list at any given moment

    public ListAttributes(TypeDenoter elementType, int size) {
        this.elementType = elementType;
        this.size = size;
    }

    @Override
    public TypeDenoter thisType() {
        return new ListType(elementType);
    }
}

//list:int b = [1,2,3]
//