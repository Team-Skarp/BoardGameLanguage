package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockNode implements ASTNode {

    public final List<ASTNode> children = new ArrayList<>();

    public BlockNode() {}

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
