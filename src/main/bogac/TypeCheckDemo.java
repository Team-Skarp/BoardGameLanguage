import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.SymbolHarvester;
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

        //input = CharStreams.fromString("{int a, b = false, c;}");
        input = CharStreams.fromString("bool a = true;");

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);
/*
        BoardParser.AdditiveContext cst = parser.additive();
        ASTNode ast = new ASTbuilder().visitAdditive(cst);
*/
        BoardParser.NormalDeclarationContext cst = parser.normalDeclaration();
        ASTNode<?> ast = new ASTbuilder().visitNormalDeclaration(cst);
        //Give it an empty symbol table //todo: why is empty?
        SymbolTable ST = new SymbolTable();

        SymbolHarvester sh = new SymbolHarvester();
        SymbolTable symbolTable = (SymbolTable) ast.accept(sh);

        TypeChecker typeChecker = new TypeChecker(symbolTable);
        TypeDenoter resultType = (TypeDenoter) ast.accept(typeChecker);

        System.out.println(resultType.getClass().getName());
    }
}
