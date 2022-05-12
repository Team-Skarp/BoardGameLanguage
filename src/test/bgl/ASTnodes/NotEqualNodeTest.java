package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class NotEqualNodeTest {
    NotEqualNode notEqualNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        TENV = new TypeEnvironment();
    }

    @Test
    void shouldAcceptAnyPrimitiveNodesForComparing() {
        notEqualNode = new NotEqualNode(intNodeLeft, intNodeRight);

        notEqualNode.accept(new PrettyPrinter());
    }

    @Test
    void typeChecksIfTwoOperatorsIsTwoOfTheSame() {
        // Deliberately declared a variable that will give an error at runtime
        booleanNode = new BooleanNode(true);

        notEqualNode = new NotEqualNode(intNodeLeft, intNodeRight);

        notEqualNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }


    @Test
    void equalNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);

        notEqualNode = new NotEqualNode(booleanNode, intNodeRight);

        notEqualNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> notEqualNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}