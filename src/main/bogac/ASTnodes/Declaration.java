package ASTnodes;

import symboltable.types.TypeDenoter;

public interface Declaration extends ASTNode<Object> {

    String varName();
    TypeDenoter type();

}
