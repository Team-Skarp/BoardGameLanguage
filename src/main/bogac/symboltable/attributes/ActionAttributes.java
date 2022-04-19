package symboltable.attributes;

import symboltable.Symbol;
import symboltable.types.ActionType;
import symboltable.types.TypeDenoter;

import java.util.List;

/**
 * Stores information about an action declaration such as formal parameters and return type
 */
public class ActionAttributes implements Attributes {

    public List<Symbol>   formalParameters;
    public TypeDenoter         returnType;
    //Perhaps an action body attribute to remember what.

    public ActionAttributes(List<Symbol> formalParameters, TypeDenoter returnType) {
        this.formalParameters = formalParameters;
        this.returnType = returnType;
    }

    @Override
    public TypeDenoter thisType() {
        return new ActionType();
    }
}
