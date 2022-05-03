package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;


import static org.junit.jupiter.api.Assertions.*;

class MinusNodeTest {
    MinusNode minusNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        booleanNodeRight = new BooleanNode(false);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        minusNode = new MinusNode(intNodeLeft, intNodeRight);

        minusNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {
        minusNode = new MinusNode(intNodeLeft, intNodeRight);

        minusNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void minusNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        minusNode = new MinusNode(intNodeLeft, booleanNodeRight);

        assertThrows(TypeErrorException.class, () -> minusNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}