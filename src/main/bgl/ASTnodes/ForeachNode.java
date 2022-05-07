package ASTnodes;

import ASTvisitors.ASTvisitor;

public class ForeachNode implements ASTNode{
    public IdNode iterator;
    public IdNode iterable;
    public ParameterBlock body;

    public ForeachNode(IdNode iterator, IdNode iterable, ParameterBlock body) {
        this.iterator = iterator;
        this.iterable = iterable;
        this.body = body;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
