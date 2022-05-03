package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class ActionBodyNode implements ASTNode<Object> {

    List<ASTNode>   body;

    public ActionBodyNode(ASTNode... body) {
        this.body = List.of(body);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
