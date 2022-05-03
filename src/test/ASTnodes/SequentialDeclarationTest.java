package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.types.ActionType;
import symboltable.types.BoolType;
import symboltable.types.IntType;
import symboltable.types.StringType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequentialDeclarationTest {
    SequentialDeclaration sequentialDeclaration;
    List<Declaration> declarations;
    IdNode idNodeString;
    IdNode idNodeBoolean;
    IdNode idNodeInt;
    IdNode idNodeList;

    @BeforeEach
    void setup() {
        idNodeString = new IdNode("redPiece", new StringType());
        idNodeBoolean = new IdNode("true", new BoolType());
        idNodeInt = new IdNode("pieceCounter", new IntType());
        idNodeList = new IdNode("List", new IntType());
        declarations = new ArrayList<>();
    }

    @Test
    void accept() {
        declarations.add(new IntegerDeclarationNode(idNodeInt));
        declarations.add(new StringDeclarationNode(idNodeString));
        declarations.add(new BooleanDeclarationNode(idNodeBoolean));
        declarations.add(new ListDeclarationNode(new IntType(), idNodeList));

        sequentialDeclaration = new SequentialDeclaration();

        sequentialDeclaration.accept(new PrettyPrinter());
    }
}