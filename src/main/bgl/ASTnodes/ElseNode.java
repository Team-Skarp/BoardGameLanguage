package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ElseNode implements ASTNode{
    public ASTNode elseBlock;

    public ElseNode(ASTNode elseBlock){
        this.elseBlock = elseBlock;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
