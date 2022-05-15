package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.types.DesignRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.types.IntType;

import java.util.ArrayList;
import java.util.List;

class SequentialDeclarationTest {
    SequentialDeclaration sequentialDeclaration;
    List<Declaration> declarations;
    IdNode idNodeString;
    IdNode idNodeBoolean;
    IdNode idNodeInt;
    IdNode idNodeList;

    @BeforeEach
    void setup() {
        idNodeString = new IdNode("redPiece");
        idNodeBoolean = new IdNode("true");
        idNodeInt = new IdNode("pieceCounter");
        idNodeList = new IdNode("List");
        declarations = new ArrayList<>();
    }

    @Test
    void accept() {
        declarations.add(new IntegerDeclarationNode(idNodeInt.name, new IntNode(4)));
        declarations.add(new StringDeclarationNode(idNodeString.name));
        declarations.add(new BooleanDeclarationNode(idNodeBoolean.name));
        declarations.add(new ListDeclarationNode(idNodeList.name, new IntType()));

        sequentialDeclaration = new SequentialDeclaration(new DesignRef("pieces"), declarations.get(2));

        sequentialDeclaration.accept(new PrettyPrinter());
    }
}