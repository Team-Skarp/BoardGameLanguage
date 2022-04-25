package ASTnodes;

import ASTvisitors.ASTvisitor;

public class WhileNode implements ASTNode {
    public ASTNode predicate;
    public ASTNode whileBlock;

    //if(){}
    public WhileNode(ASTNode predicate, ASTNode whileBlock) {
        this.predicate = predicate;
        this.whileBlock = whileBlock;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
