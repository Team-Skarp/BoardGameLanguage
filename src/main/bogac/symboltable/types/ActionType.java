package symboltable.types;

import symboltable.FormalParameter;

import java.util.Arrays;
import java.util.List;

public class ActionType implements TypeDenoter {

    public final TypeDenoter returnType;
    public final List<FormalParameter> formalParameters;

    public ActionType(TypeDenoter returnType, List<FormalParameter> formalParams) {
        this.returnType = returnType;
        this.formalParameters = formalParams;
    }
    public ActionType(TypeDenoter returnType, FormalParameter... param) {
        this.returnType = returnType;
        this.formalParameters = (List<FormalParameter>) Arrays.asList(param);
    }

    @Override
    public String toString() {
        return "action";
    }
}
