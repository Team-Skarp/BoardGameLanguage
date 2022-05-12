package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ActionCallNode implements ASTNode, ArithmeticExpression {

    public final String             actionName;
    public final List<Expression>   actualParameters;

    public ActionCallNode(String actionName, Expression... actualParameters) {
        this.actionName = actionName;
        this.actualParameters = List.of(actualParameters);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
