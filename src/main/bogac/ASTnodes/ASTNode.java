package ASTnodes;

import ASTvisitors.ASTvisitor;
import antlr.BoardVisitor;

public interface ASTNode {

    void accept(ASTvisitor v);
}
