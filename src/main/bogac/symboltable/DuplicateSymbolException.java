package symboltable;

public class DuplicateSymbolException extends RuntimeException {

    public DuplicateSymbolException(String message) {
        super(message);
    }
}