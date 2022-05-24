package SymbolTable;

import ASTnodes.*;
import org.junit.Test;

import SymbolTable.types.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SymbolHarvesterTest {

    SymbolHarvester symbolHarvester;

    /**
     * Tests the code;
     * int a, b;
     */
    @Test
    public void entersSequentialIntegerDeclarationCorrectly() {


        symbolHarvester = new SymbolHarvester();

        SequentialDeclaration sequence = new SequentialDeclaration(
                new IntType(),
                new IntegerDeclarationNode("a"),
                new IntegerDeclarationNode("b")
        );

        symbolHarvester.visit(sequence);
    }

    /**
     * Tests the code:
     * int a, b = false
     */
    @Test
    public void shouldThrowTypeErrorWhenExpressionTypeDoesNotMatchInSequenceDeclaration() {

        symbolHarvester = new SymbolHarvester();

        SequentialDeclaration sequence = new SequentialDeclaration(
                new IntType(),
                new IntegerDeclarationNode("a"),
                new IntegerDeclarationNode(
                        "b",
                        new BooleanNode(false)
                )
        );


        assertThrows(TypeErrorException.class, () -> symbolHarvester.visit(sequence));

    }

    @Test
    public void canEnterDesignDefinitionIntoSymbolTable() {       //design Player {str name;}

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode playerDefinition = new DesignDefinitionNode(
                "Player",
                new StringDeclarationNode("name")
        );

        symbolHarvester.visit(playerDefinition);

    }

    @Test
    public void canDefineDesignWithDesignField() {       //design Player {Color color;}

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode Color = new DesignDefinitionNode(
                "Color",
                new StringDeclarationNode("name")
        );

        DesignDefinitionNode Player = new DesignDefinitionNode(
                "Player",
                new DesignDeclarationNode(
                        "Color",
                        "color")
        );

        symbolHarvester.visit(Color);
        symbolHarvester.visit(Player);

    }

    /**
     * Tests the code:
     * a -> {                #Variable a have been passed down to this block
     *     int a;       #should fail to redeclare
     * }
     */
    @Test
    public void shouldThrowErrorWhenRedeclaringVariableFromParameterizedBlock() {

        symbolHarvester = new SymbolHarvester();

        ParameterBlock parameterBlock = new ParameterBlock(
                new IntegerDeclarationNode("a")
        );

        parameterBlock.variables = List.of(new Symbol(
                "a",
                new IntType())
        );

        assertThrows(DuplicateSymbolException.class, () ->
                symbolHarvester.visit(parameterBlock));

    }

    @Test
    /**
     *
     * action foo(int a, int b) {
     *     #here we should be able to reference a and b
     * }
     *
     * a and b, should be written to symbol table
     */
    public void shouldWriteFormalParamsIntoSymbolTable() {

        symbolHarvester = new SymbolHarvester();

        ActionDefinitionNode foo = new ActionDefinitionNode(
                "foo",
                new VoidType(),
                new ParameterBlock(),
                new IntegerDeclarationNode(
                        "a"
                ),
                new IntegerDeclarationNode(
                        "b"
                )
        );

        SymbolTable ST = symbolHarvester.visit(foo);
        ST.resetScopePointers();

        //Expect that a new scope for the action body have been created
        assertEquals(1, ST.getActiveBlock().getChildren().size());

        //Expect that within the action body scope we can retrieve the two declarations
        ST.dive();
        ST.retrieveSymbol("a");
        ST.retrieveSymbol("b");

    }

    @Test
    public void actionDeclarationsSavesFirstArgumentAsSelf() {

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode Animal = new DesignDefinitionNode(
                "Animal",
                new ActionDeclarationNode(
                        "isMammal",
                        new BoolType()
                )
        );

        symbolHarvester.visit(Animal);
        TypeEnvironment TENV = symbolHarvester.TENV;

        //Grab action within design
        SymbolTable AnimalST = TENV.receiveType("Animal").fields;
        ActionType isMammal = (ActionType) AnimalST.retrieveSymbol("isMammal").type;

        //We hope to find that the action have one formal parameter, namely 'self' of type Animal;
        assertEquals(1, isMammal.formalParameters.size());
        assertEquals("self", isMammal.formalParameters.get(0).varName());
        assertEquals("Animal", isMammal.formalParameters.get(0).type().toString());


    }

}
