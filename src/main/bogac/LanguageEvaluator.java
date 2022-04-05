import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.Evaluator;
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

        input = CharStreams.fromString("5>3 and False");

        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        BoardParser.BooleanExpressionContext cst = parser.booleanExpression();
        ASTNode ast = new ASTbuilder().visitBooleanExpression(cst);

        Evaluator evaluator = new Evaluator();
        Object result = ast.accept(evaluator);

        System.out.println(result);
    }
}
