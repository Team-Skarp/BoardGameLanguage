package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhileNodeTest {
    WhileNode whileNode;
    PredicateNode predicateNodeTrue;
    PredicateNode predicateNodeFalse;

    BlockNode blockNodeWhile;


    @BeforeEach
    void setup() {
        predicateNodeTrue = new PredicateNode(new BooleanNode(true));
        predicateNodeFalse = new PredicateNode(new BooleanNode(false));
        blockNodeWhile = new BlockNode();
    }

    @Test
    void Accept() {
        whileNode = new WhileNode(predicateNodeTrue, blockNodeWhile);

        whileNode.accept(new PrettyPrinter());
    }
}