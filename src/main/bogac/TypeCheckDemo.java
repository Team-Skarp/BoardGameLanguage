import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.types.TypeDenoter;

public class TypeCheckDemo {

    public static void main(String[] args) {
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("2 + 2");

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.AdditiveContext cst = parser.additive();
        ASTNode ast = new ASTbuilder().visitAdditive(cst);

        //Give it an empty symbol table
        SymbolTable ST = new SymbolTable();

        TypeChecker typeChecker = new TypeChecker(ST);
        TypeDenoter resultType = (TypeDenoter) ast.accept(typeChecker);

        System.out.println(resultType.getClass().getName());
    }
}
