package ASTnodes;

public interface BinaryOperator extends ASTNode {

    Expression getLeft();
    Expression getRight();
}
