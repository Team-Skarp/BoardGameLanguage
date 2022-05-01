package symboltable;

import ASTnodes.*;

import org.junit.Test;
import symboltable.types.DesignRef;
import symboltable.types.IntType;
import symboltable.types.StringType;

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
    public void should_throw_typeDefError_when_declaring_non_defined_type() {

        ST = new SymbolTable();

        DesignDeclarationNode designDcl = new DesignDeclarationNode(
                new DesignRef("NotDefinedType"),
                "a"
        );

        TC = new TypeChecker(ST, TENV);

        //Purposely we do not enter the type into the type environment
        assertThrows(TypeDefinitionException.class, () -> TC.visit(designDcl));

    }

}
