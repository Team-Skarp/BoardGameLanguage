import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.ArithmeticEvaluator;
import ASTvisitors.PrettyPrinter;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class ArithmeticEvaluatorDemo {

    public static void main(String[] args) {

        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("4 * 10^2");

        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        BoardParser.ArithmeticExpressionContext cst = parser.arithmeticExpression();
        ASTNode ast = new ASTbuilder().visitArithmeticExpression(cst);

        ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
        int result = (int) ast.accept(evaluator);

        System.out.println(result);
    }
}
