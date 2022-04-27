import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.SymbolHarvester;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import symboltable.SymbolTable;

public class SymbolTableDemo {

    public static void main(String[] args) {
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("SETUP {{int a;} {int a;} {int a;} {int a;}}");

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.SetupContext cst = parser.setup();
        ASTNode ast = new ASTbuilder().visitSetup(cst);

        SymbolHarvester sh = new SymbolHarvester();
        SymbolTable symbolTable = (SymbolTable) ast.accept(sh);
    }
}
