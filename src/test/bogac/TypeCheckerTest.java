package bogac;

import ASTnodes.*;
import org.junit.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;
import symboltable.attributes.PrimitiveAttributes;
import symboltable.types.BoolType;
import symboltable.types.IntType;
import symboltable.types.StringType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TypeCheckerTest {

    SymbolTable ST;

    @Test
    public void should_throw_typeerror_when_adding_two_ids_with_different_types() {

        ST = new SymbolTable();

        IdNode a = new IdNode("a", new IntType());
        IdNode b = new IdNode("b", new StringType());
        PlusNode plus = new PlusNode(a, b);

        ST.enterSymbol("a", new PrimitiveAttributes(new IntType()));
        ST.enterSymbol("b", new PrimitiveAttributes(new StringType()));

        TypeChecker typeChecker = new TypeChecker(ST);

        assertThrows(TypeErrorException.class, () -> typeChecker.visit(plus));
    }

    @Test
    public void should_throw_typeerror_when_expression_type_does_not_match() {

        ST = new SymbolTable();

        //int a, b = false
        IntegerDeclarationNode a = new IntegerDeclarationNode(new IdNode("a", new IntType()));
        IntegerAssignDeclarationNode b = new IntegerAssignDeclarationNode(new IdNode("b"), new BooleanNode(false));

        ST.enterSymbol("a", new PrimitiveAttributes(new IntType()));
        ST.enterSymbol("b", new PrimitiveAttributes(new BoolType()));

        SequentialDeclaration sequence = new SequentialDeclaration();
        sequence.declarations = List.of(a, b);
        sequence.type = new IntType();

        TypeChecker typeChecker = new TypeChecker(ST);

        assertThrows(TypeErrorException.class, () -> typeChecker.visit(sequence));

    }


}
