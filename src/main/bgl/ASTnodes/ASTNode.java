package ASTnodes;

import ASTvisitors.ASTvisitor;
import antlr.BoardVisitor;

public interface ASTNode<T> {

    T accept(ASTvisitor v);
}
