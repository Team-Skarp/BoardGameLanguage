package symboltable;

import org.junit.jupiter.api.Test;
import symboltable.types.DesignType;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TypeEnvironmentTest {

    TypeEnvironment typeEnvironment;

    @Test
    void canCreateNewTypeWithNoParent() {

        typeEnvironment = new TypeEnvironment();

        DesignType testType = new DesignType(
                "LudoPiece",
                new SymbolTable()
        );

        typeEnvironment.enterType(testType);

    }

    @Test
    void cannotCreateTypeTwice() {

        typeEnvironment = new TypeEnvironment();

        DesignType ludoPiece = new DesignType(
                "LudoPiece",
                new SymbolTable()
        );


        typeEnvironment.enterType(ludoPiece);

        assertThrows(TypeDefinitionException.class,
                () -> typeEnvironment.enterType(ludoPiece));

    }

    @Test
    void cannotCreateTypeWithParrentTypeThatDoesNotExist() {

        typeEnvironment = new TypeEnvironment();

        DesignType testType = new DesignType(
                "testType",
                "doesNotExistType",
                new SymbolTable()
        );

        assertThrows(TypeDefinitionException.class, () -> typeEnvironment.enterType(testType));

    }

}