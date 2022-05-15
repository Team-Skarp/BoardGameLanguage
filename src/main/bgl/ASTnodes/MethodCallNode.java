package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class MethodCallNode extends ActionCallNode implements Accessable {

    public final String calledBy;

    public MethodCallNode(ActionCallNode action, String calledBy) {
        super(action.actionName, action.actualParameters);
        this.calledBy = calledBy;
    }

    public MethodCallNode(String actionName, String calledBy) {
        super(actionName);
        this.calledBy = calledBy;
    }

    public MethodCallNode(String actionName, String calledBy, List<Expression> actualParameters) {
        super(actionName, actualParameters);
        this.calledBy = calledBy;
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
