package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class BlockNode implements ASTNode {

    public final List<ASTNode> children;

    public BlockNode(ASTNode... children) {
        this.children = List.of(children);
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
