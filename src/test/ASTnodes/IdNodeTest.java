package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.attributes.PrimitiveAttributes;
import SymbolTable.types.StringType;

import static org.junit.jupiter.api.Assertions.*;

class IdNodeTest {
    IdNode idNode;

    @Test
    void acceptsIdNodeWithOnlyName() {
        idNode = new IdNode("Player 1");

        idNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsIdNodeWithNameAndAttr() {
        idNode = new IdNode("Player 1", new PrimitiveAttributes(new StringType()));

        idNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsIdNodeWithNameAndType() {
        idNode = new IdNode("Player 1", new StringType());

        idNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsPlayer() {
        idNode = new IdNode("Player2");

        SymbolTable symbolTable = new SymbolTable().
                enterSymbol(idNode.name, new PrimitiveAttributes(new StringType()));

        idNode.accept(new TypeChecker(symbolTable));
    }
}