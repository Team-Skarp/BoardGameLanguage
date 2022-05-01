package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockNode implements ASTNode {

    public final List<ASTNode> children = new ArrayList<>();
    public final String blockType;

    public BlockNode(String blockType) {
        this.blockType = blockType;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
