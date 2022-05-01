package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ActionCallNode implements ASTNode<Object> {

    public final IdNode             actionName;
    public final List<Expression>   actualParameters;

    public ActionCallNode(IdNode actionName, List<Expression> actualParameters) {
        this.actionName = actionName;
        this.actualParameters = actualParameters;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
