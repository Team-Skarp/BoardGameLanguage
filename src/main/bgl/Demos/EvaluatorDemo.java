package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.Evaluator;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class EvaluatorDemo {

    public static void main(String[] args) {

        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("if(true){if(false){}else{bool asd = true;}}else{ bool eqw = false;}");

        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // BoardParser.IntegerDeclarationContext cst = parser.integerDeclaration();
        // ASTNode ast = new ASTbuilder().visitIntegerDeclaration(cst);

        BoardParser.IfStatementContext cst = parser.ifStatement();
        ASTNode ast = new ASTbuilder().visitIfStatement(cst);

        Evaluator evaluator = new Evaluator();
        Object result = ast.accept(evaluator);

        System.out.println(result);
    }
}
