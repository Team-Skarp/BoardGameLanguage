package ASTnodes;

import ASTvisitors.ASTvisitor;

public interface ASTNode<T> {

    T accept(ASTvisitor v);
}
