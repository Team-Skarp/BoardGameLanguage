package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;


/**
 *
 */
public class ActionBodyNode implements ASTNode<Object> {

    List<ASTNode> body;

    public ActionBodyNode(ASTNode... node) {
        this.body = List.of(node);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
