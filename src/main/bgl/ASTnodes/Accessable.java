package ASTnodes;

/**
 * Interface for AST nodes that can be accessed
 *
 * Current implementations: IdNode & ActionCall
 *
 */
public interface Accessable extends ASTNode {

    String getAccessName();
}
