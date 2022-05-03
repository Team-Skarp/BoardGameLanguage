package ASTnodes;

public interface Assignment extends ASTNode<Object> {

    String getLeft();
    ASTNode getRight();

}


