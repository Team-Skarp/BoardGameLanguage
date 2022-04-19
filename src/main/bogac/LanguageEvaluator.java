import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.Evaluator;
import ASTvisitors.PrettyPrinter;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class LanguageEvaluator {

    public static void main(String[] args) {

        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("path main[24];");

        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // BoardParser.IntegerDeclarationContext cst = parser.integerDeclaration();
        // ASTNode ast = new ASTbuilder().visitIntegerDeclaration(cst);

        BoardParser.PathDeclarationContext cst = parser.pathDeclaration();
        ASTNode ast = new ASTbuilder().visitPathDeclaration(cst);

        Evaluator evaluator = new Evaluator();
        Object result = ast.accept(evaluator);

        System.out.println(result);
    }
}
