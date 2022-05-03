package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ElifConditionalNode implements ASTNode {
    public ASTNode predicate;
    public ASTNode ifBlock;

    //elseif(){}
    public ElifConditionalNode(ASTNode boolExpr, ASTNode ifBlock) {
        this.predicate = boolExpr;
        this.ifBlock = ifBlock;
    }

    //empty, used for population in if node
    /**
     * Skal det her slettes??? Hilsen Hans og Ming
     */
    public ElifConditionalNode() {
        this.predicate = null;
        this.ifBlock = null;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}