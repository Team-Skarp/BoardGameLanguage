package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

/**
 * Block used for setup, rules and gameloop to share the same scope
 */
public class NonScopeBlockNode implements ASTNode<Object> {

    public List<ASTNode> children;

    public NonScopeBlockNode(ASTNode... children) {
        this.children = List.of(children);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
