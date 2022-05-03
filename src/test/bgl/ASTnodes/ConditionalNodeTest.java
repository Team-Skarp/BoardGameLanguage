package ASTnodes;

import ASTnodes.*;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalNodeTest {
    ConditionalNode conditionalNode;
    PredicateNode predicateNodeTrue;
    PredicateNode predicateNodeFalse;
    BlockNode blockNodeIf;
    List<ASTNode> blockNodeElseIfList;
    BlockNode BlockNodeElseIf;
    BlockNode blockNodeElse;

    @BeforeEach
    void setup() {
        predicateNodeTrue = new PredicateNode(new BooleanNode(true));
        predicateNodeFalse = new PredicateNode(new BooleanNode(false));
    }

    @Test
    void acceptsOnlyIfStatement() {
        blockNodeIf = new BlockNode(new StringNode("\"ifBlock\""));

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf);
        conditionalNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsIfAndElseStatements() {
        blockNodeIf = new BlockNode(new StringNode("\"ifBlock\""));
        blockNodeElse = new BlockNode(new StringNode("\"elseIfBlock\""));

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElse);

        conditionalNode.accept(new PrettyPrinter());
    }


    @Test
    void acceptsIfAndAListOfElseIfStatements() {
        blockNodeIf = new BlockNode(new StringNode("\"ifBlock\""));
        blockNodeElseIfList = new ArrayList<>();

        BlockNodeElseIf = new BlockNode(new StringNode("\"elseIfBlock\""));
        blockNodeElseIfList.add(BlockNodeElseIf);

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElseIfList);

        conditionalNode.accept(new PrettyPrinter());
        assertEquals(1, blockNodeElseIfList.size());
    }

    @Test
    void acceptsIfAndAListOfElseIfAndElseStatements() {
        blockNodeIf = new BlockNode(new StringNode("\"ifBlock\""));
        blockNodeElse = new BlockNode(new StringNode("\"elseBlock\""));
        blockNodeElseIfList = new ArrayList<>();

        BlockNodeElseIf = new BlockNode(new StringNode("\"elseIfBlock\""));
        blockNodeElseIfList.add(BlockNodeElseIf);

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElseIfList, blockNodeElse);

        conditionalNode.accept(new PrettyPrinter());
        assertEquals(1, blockNodeElseIfList.size());
    }
}