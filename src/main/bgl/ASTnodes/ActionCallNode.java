package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ActionCallNode implements ASTNode, ArithmeticExpression, Accessable {

    public final String             actionName;
    public List<Expression>   actualParameters;

    public ActionCallNode(String actionName, Expression... actualParameters) {
        this.actionName = actionName;
        this.actualParameters = List.of(actualParameters);
    }

    public ActionCallNode(String actionName, List<Expression> actualParameters) {
        this.actionName = actionName;
        this.actualParameters = actualParameters;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String getAccessName() {
        return actionName;
    }
}
