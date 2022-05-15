package SymbolTable;

/**
 * Class used when wanting to throw a classic type error
 */
public class TypeErrorException extends RuntimeException {

    public TypeErrorException(String msg) {
        super(msg);

    }
}
