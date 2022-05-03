package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

class ElifConditionalNodeTest {
    ElifConditionalNode elifConditionalNode;
    BlockNode elseIfBlockNode;
    PredicateNode predicateNode;
    BooleanNode booleanNode;

    @Test
    void acceptElifConditionalWithParameters() {
        booleanNode = new BooleanNode(true);
        predicateNode = new PredicateNode(booleanNode);
        elseIfBlockNode = new BlockNode(new StringNode("\"elseIfBlock\""));
        elifConditionalNode = new ElifConditionalNode(predicateNode, elseIfBlockNode);
        elifConditionalNode.accept(new PrettyPrinter());
    }

    /*@Test
    void acceptElifConditionalWithOutParameters() {
        elifConditionalNode = new ElifConditionalNode();
        elifConditionalNode.accept(new PrettyPrinter());
    }*/
}
