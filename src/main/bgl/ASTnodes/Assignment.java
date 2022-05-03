package ASTnodes;

public interface Assignment extends ASTNode<Object> {

    IdNode getLeft();
    ASTNode getRight();

}


