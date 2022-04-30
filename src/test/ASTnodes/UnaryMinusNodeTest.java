package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.types.ActionType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnaryMinusNodeTest {
    UnaryMinusNode unaryMinusNode;
    PowNode powNode;
    PlusNode plusNode;
    MinusNode minusNode;
    MultNode multNode;
    DivNode divNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(3);
        powNode = new PowNode(intNodeLeft, intNodeRight);
        plusNode = new PlusNode(intNodeLeft, intNodeRight);
        minusNode = new MinusNode(intNodeLeft, intNodeRight);
        multNode = new MultNode(intNodeLeft, intNodeRight);
        divNode = new DivNode(intNodeLeft, intNodeRight);
    }

    @Test
    void acceptsAnyOperandWithUnaryMinus() {
        unaryMinusNode = new UnaryMinusNode(powNode);

        unaryMinusNode.accept(new PrettyPrinter());
    }
}