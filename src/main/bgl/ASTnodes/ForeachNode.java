package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ForeachNode implements ASTNode{
    public IdNode newId;
    public IdNode mainId;
    public ASTNode foreachBlock;

    //if(){}
    public ForeachNode(IdNode newId, IdNode mainId, ASTNode foreachBlock) {
        this.newId = newId;
        this.mainId = mainId;
        this.foreachBlock = foreachBlock;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
