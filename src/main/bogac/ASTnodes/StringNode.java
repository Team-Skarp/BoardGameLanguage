package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringNode implements ASTNode<Object>{

    public final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return null;
    }
}
