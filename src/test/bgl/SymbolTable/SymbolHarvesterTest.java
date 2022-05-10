package SymbolTable;

import ASTnodes.*;
import org.junit.Test;

import SymbolTable.types.*;

import java.util.List;

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
                new IntegerAssignDeclarationNode(
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
                new IdNode("Player"),
                new StringDeclarationNode("name")
        );

        symbolHarvester.visit(playerDefinition);

    }

    @Test
    public void canDefineDesignWithDesignField() {       //design Player {Color color;}

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode Color = new DesignDefinitionNode(
                new IdNode("Color"),
                new StringDeclarationNode("name")
        );

        DesignDefinitionNode Player = new DesignDefinitionNode(
                new IdNode("Player"),
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

}
