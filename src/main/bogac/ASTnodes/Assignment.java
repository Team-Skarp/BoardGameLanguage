package ASTnodes;

public interface Assignment extends ASTNode<Object> {

    ASTNode getLeft();
    ASTNode getRight();

}
