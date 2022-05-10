package SymbolTable;

import ASTnodes.*;

import ASTvisitors.ASTvisitor;
import org.junit.Test;
import SymbolTable.types.*;

import static org.junit.jupiter.api.Assertions.*;

public class TypeCheckerTest {

    SymbolTable ST;
    TypeEnvironment TENV = new TypeEnvironment();
    TypeChecker TC;

    @Test
    public void shouldThrowTypeerrorWhenAddingTwoIdsWithDifferentTypes() {

        ST = new SymbolTable();

        PlusNode plus = new PlusNode(
                new IdNode("a"),
                new IdNode("b")
        );

        ST.enterSymbol(new Symbol("a", new IntType()));
        ST.enterSymbol(new Symbol("b", new StringType()));

        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(plus));
    }

    @Test
    public void shouldThrowTypeErrorWhenAddingThreeIdsWithDifferentTypes() {

        ST = new SymbolTable();

        Expression extPlus = new PlusNode(
          new IdNode("a"),
          new PlusNode(
            new IdNode("b"),
            new IdNode("c")
          )
        );


        ST.enterSymbol(new Symbol("a", new IntType()));
        ST.enterSymbol(new Symbol("b", new BoolType()));
        ST.enterSymbol(new Symbol("c", new StringType()));

        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(extPlus));
    }

    @Test
    public void shouldThrowTypeDefErrorWhenDeclaringNonDefinedType() {

        ST = new SymbolTable();

        DesignDeclarationNode designDcl = new DesignDeclarationNode(
                "NotDefinedType",
                "a"
        );

        TC = new TypeChecker(ST, TENV);

        //Purposely we do not enter the type into the type environment
        assertThrows(TypeDefinitionException.class, () -> TC.visit(designDcl));

    }

    /**
     * Tests the code:
     *
     * action foo() : bool {return 5}
     *
     */
    @Test
    public void shouldThrowTypeErrorWhenReturnTypeDoesNotMatchReturnedTypeOfAction() {

        SymbolHarvester SH = new SymbolHarvester();

        ActionDefinitionNode foo = new ActionDefinitionNode(
                "foo",
                new BoolType(),
                new ParameterBlock(
                        new ReturnNode(
                                new IntNode(5)
                        )
                )
        );

        assertThrows(TypeErrorException.class, () ->
                SH.visit(foo));

    }

    @Test
    public void shouldThrowTypeErrorWhenCallingActionWithTooManyArguments() {

        ST = new SymbolTable();

        ActionDefinitionNode foo = new ActionDefinitionNode(
                "foo",
                new VoidType(),
                new ParameterBlock(),
                new IntegerDeclarationNode("a"),
                new IntegerDeclarationNode("b")
        );

        ST.enterSymbol(new Symbol(
                "foo",
                new ActionType(
                        foo.returnType,
                        foo.formalParameters
                )
        ));

        ActionCallNode callFoo = new ActionCallNode(
                "foo",
                new IntNode(1)      //Give the call to foo only one argument
        );

        //Initialise type checker with symbol table containing definition of foo
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class,
                () ->  TC.visit(callFoo)
        );
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotABoolean() {

        ST = new SymbolTable();

        BooleanAssignmentNode assignmentNode = new BooleanAssignmentNode(new IdNode("i").name,
          new BooleanNode(true));

        // ST.openScope();
        ST.enterSymbol(new Symbol("i", new IntType()));
        // ST.climb();
        // ST.closeScope();
        // ST.dive();
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotAInt() {
        ST = new SymbolTable();

        IntegerAssignmentNode assignmentNode = new IntegerAssignmentNode(new IdNode("i"),
                new IntNode(8));

        // ST.openScope();
        ST.enterSymbol(new Symbol("i", new StringType()));
        // ST.climb();
        // ST.closeScope();
        // ST.dive();
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotAString() {
        ST = new SymbolTable();

        StringAssignmentNode assignmentNode = new StringAssignmentNode(new IdNode("piece").name,
                new IdNode("red").name);

        // ST.openScope();
        ST.enterSymbol(new Symbol("piece", new BoolType()));
        ST.enterSymbol(new Symbol("red", new IntType()));
        // ST.climb();
        // ST.closeScope();
        // ST.dive();
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }
}
