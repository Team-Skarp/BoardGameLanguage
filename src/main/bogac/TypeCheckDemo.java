import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeEnvironment;
import symboltable.types.TypeDenoter;

public class TypeCheckDemo {

    public static void main(String[] args) {
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("int a, b = false, c;");

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.AdditiveContext cst = parser.additive();
        ASTNode ast = new ASTbuilder().visitAdditive(cst);

        //Give it an empty symbol table and type env
        SymbolTable ST = new SymbolTable();
        TypeEnvironment TENV = new TypeEnvironment();

        TypeChecker typeChecker = new TypeChecker(ST, TENV);
        TypeDenoter resultType = (TypeDenoter) ast.accept(typeChecker);

        System.out.println(resultType.getClass().getName());
    }
}
