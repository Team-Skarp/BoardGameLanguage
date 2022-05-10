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
    public void should_throw_typeerror_when_adding_two_ids_with_different_types() {

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
    public void should_throw_typeerror_when_adding_three_ids_with_different_types() {

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
    public void should_throw_typeDefError_when_declaring_non_defined_type() {

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
    public void should_throw_type_error_when_return_type_does_not_match_returned_type_of_action() {

        ActionDefinitionNode foo = new ActionDefinitionNode(
                "foo",
                new BoolType(),
                new ActionBodyNode(
                        new ReturnNode(
                                new IntNode(5)
                        )
                )
        );
    }

    @Test
    public void should_throw_type_error_when_calling_action_with_too_many_arguments() {

        ST = new SymbolTable();

        ActionDefinitionNode foo = new ActionDefinitionNode(
                "foo",
                new VoidType(),
                new ActionBodyNode(),
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
    public void should_throw_typeerror_when_assigning_wrong_value_type() {

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
}
