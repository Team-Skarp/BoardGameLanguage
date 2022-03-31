package AST;

import autogen.BoardVisitor;

public interface ASTNode {

    void accept(BoardVisitor v);
}
