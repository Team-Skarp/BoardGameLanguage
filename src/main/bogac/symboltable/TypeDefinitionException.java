package symboltable;

/**
 * Class used when wanting to throw a classic type error
 */
public class TypeDefinitionException extends RuntimeException {

    public TypeDefinitionException(String message) {
        super(message);

    }
}
