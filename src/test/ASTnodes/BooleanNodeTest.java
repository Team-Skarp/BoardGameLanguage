package ASTnodes;

import ASTvisitors.ASTvisitor;
import ASTvisitors.PrettyPrinter;
import ASTvisitors.SymbolHarvester;
import Logging.Logger;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BooleanNodeTest {

    BooleanNode booleanNode;

    @Test
    void acceptsABoolean() {
        booleanNode = new BooleanNode(false);

        booleanNode.accept(new PrettyPrinter());
        booleanNode.accept(new TypeChecker(new SymbolTable()));
    }
}