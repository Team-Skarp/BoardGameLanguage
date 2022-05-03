package SymbolTable;

public class ReferenceErrorException extends RuntimeException {

    public ReferenceErrorException(String message) {
        super(message);
    }
}
