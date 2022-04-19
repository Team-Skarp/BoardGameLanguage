package symboltable;

import ASTnodes.ASTNode;

public class TypeErrorException extends RuntimeException {

    public TypeErrorException(String msg) {
        super(msg);

    }
}
