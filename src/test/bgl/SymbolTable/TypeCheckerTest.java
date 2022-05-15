package SymbolTable;

import ASTnodes.*;

import ASTvisitors.ASTbuilder;
import org.junit.Test;
import SymbolTable.types.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * action foo(int a, int b){}
     *
     * foo(1, 2);
     */
    @Test
    public void canCallActionWithMoreThanTwoActualParameters() {

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
                new IntNode(5),
                new IntNode(10)
        );

        //Initialise type checker with symbol table containing definition of foo
        TC = new TypeChecker(ST, TENV);

        TC.visit(callFoo);
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotABoolean() {

        ST = new SymbolTable();

        BooleanAssignmentNode assignmentNode = new BooleanAssignmentNode(new IdNode("i").name,
          new BooleanNode(true));

        ST.enterSymbol(new Symbol("i", new IntType()));
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotAInt() {
        ST = new SymbolTable();

        IntegerAssignmentNode assignmentNode = new IntegerAssignmentNode(new IdNode("i"),
                new IntNode(8));

        ST.enterSymbol(new Symbol("i", new StringType()));
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }

    @Test
    public void shouldThrowTypeErrorWhenAssigningValueTypeIsNotAString() {
        ST = new SymbolTable();

        StringAssignmentNode assignmentNode = new StringAssignmentNode(new IdNode("piece").name,
                new IdNode("red").name);

        ST.enterSymbol(new Symbol("piece", new BoolType()));
        ST.enterSymbol(new Symbol("red", new IntType()));
        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, () -> TC.visit(assignmentNode));
    }

    @Test
    /**
     * design A {
     *     B b;
     * }
     * design B {
     *     int c;
     * }
     *
     * A a;
     * int i = a.b.c;
     */
    public void intDeclarationAssignOfFieldAccessNodeValue() {
        ST = new SymbolTable();
        TENV = new TypeEnvironment();

        TENV.enterType(
                new DesignType(
                        "A",
                        new SymbolTable().enterSymbol(
                                new Symbol("b", new DesignRef("B"))
                        )
                )
        ).enterType(
                new DesignType(
                        "B",
                        new SymbolTable().enterSymbol(
                                new Symbol("c", new IntType())
                        )
                )
        );

        ST.enterSymbol(new Symbol("a", new DesignRef("A")));

        IntegerDeclarationNode i = new IntegerDeclarationNode(
                "i",
                new FieldAccessNode(
                        List.of(
                                new IdNode("a"),
                                new IdNode("b"),
                                new IdNode("c")
                        )
                )
        );

        TC = new TypeChecker(ST, TENV);

        assertEquals(IntType.class, TC.visit(i).getClass());
    }

    @Test
    /**
     * design A {
     *     action foo() : int;
     * }
     * A a;
     * int i = a.foo();
     */
    public void getsTypeOfMethodCall() {
        ST = new SymbolTable();
        TENV = new TypeEnvironment();

        TENV.enterType(
                new DesignType(
                        "A",
                        new SymbolTable().enterSymbol(
                                new Symbol(
                                        "foo",
                                        new ActionType(
                                                new IntType()
                                        )
                        )
                )
        ));


        ST.enterSymbol(new Symbol(
                "a",
                new DesignRef("A"))
        );

        IntegerDeclarationNode i = new IntegerDeclarationNode(
                "i",
                new FieldAccessNode(
                        List.of(
                                new IdNode("a"),
                                new MethodCallNode(
                                        "foo",
                                        "a"
                                ))
                )
        );

        TC = new TypeChecker(ST, TENV);

        assertEquals(IntType.class, TC.visit(i).getClass());
    }

    @Test
    public void throwsExceptionWhenElementTypeDoesNotMatchListType() {
        ST = new SymbolTable();

        ListNode assignedList = new ListNode(new ArrayList<>());
        assignedList.elements.add(new IntNode(1));
        assignedList.elements.add(new IntNode(4));

        ListDeclarationNode listNode = new ListDeclarationNode("TestNode", new BoolType(), assignedList);

        TC = new TypeChecker(ST, TENV);

        assertThrows(TypeErrorException.class, ()-> TC.visit(listNode));

    }

    @Test
    public void listNestingLevelMatchesAssignedList() {
        ASTbuilder ASTB = new ASTbuilder();

    }
}
