package bogac.ASTnodes;

import ASTnodes.BlockNode;
import ASTnodes.BooleanNode;
import ASTnodes.ElifConditionalNode;
import ASTnodes.PredicateNode;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElifConditionalNodeTest {
    ElifConditionalNode elifConditionalNode;
    BlockNode blockNode;
    PredicateNode predicateNode;
    BooleanNode booleanNode;

    @Test
    void acceptElifConditionalWithParameters() {
        booleanNode = new BooleanNode(true);
        predicateNode = new PredicateNode(booleanNode);
        blockNode = new BlockNode();
        elifConditionalNode = new ElifConditionalNode(predicateNode, blockNode);
        elifConditionalNode.accept(new PrettyPrinter());
    }
}
