package ASTnodes;

import SymbolTable.types.TypeDenoter;

public interface Declaration extends ASTNode<Object> {

    String varName();
    TypeDenoter type();

}
