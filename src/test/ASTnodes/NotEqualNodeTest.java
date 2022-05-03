package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class NotEqualNodeTest {
    NotEqualNode notEqualNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNode;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
    }

    @Test
    void accept() {
        notEqualNode = new NotEqualNode(intNodeLeft, intNodeRight);

        notEqualNode.accept(new PrettyPrinter());
    }

    @Test
    void typeChecksIfTwoOperatorsIsTwoOfTheSame() {
        // Deliberately declared a variable that will give an error at runtime
        booleanNode = new BooleanNode(true);

        notEqualNode = new NotEqualNode(intNodeLeft, intNodeRight);

        notEqualNode.accept(new TypeChecker(new SymbolTable()));
    }


    @Test
    void equalNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);

        notEqualNode = new NotEqualNode(booleanNode, intNodeRight);

        notEqualNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> notEqualNode.accept(new TypeChecker(new SymbolTable())));
    }
}