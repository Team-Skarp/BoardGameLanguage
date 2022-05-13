package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import CodeGeneration.GNUASMCodeGenerator;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;

public class GNUASMGenerationDemo {
    public static void main(String[] args) {

        // Setup
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        /*
         * use this string starting from gamestart, before pushing any changes.
         * no errors must occur when parsing this string.
         */
        String bglCodeExample = """
                SETUP {
                    str player1 = "Hans";
                    int player1attack = 1;
                    int player1health = 10000;
                    int decision = 1;
                    str player2 = "Jakob";
                    int player2attack = 1;
                    int player2health = 10000;
                    print("Welcome to the greatest game ever!");
                }
                RULES {
                }
                GAMELOOP {
                    print("It is ",player1," turn");
                    print("enter 1 to double your attackpower, or type 0 to expend your attackpower to attack");
                    input(decision);
                    if(decision == 1){
                        print("Doubled your attack!");
                        player1attack = player1attack*2;
                    }else{
                        print("Attacked!");
                        player2health = player2health-player1attack;
                        player1attack = 1;
                    }
                    print(player1,", health: ",player1health ,", attack: ",player1attack);
                    print(player2,", health: ",player2health ,", attack: ",player2attack);
                    print("It is ",player2," turn");
                    input(decision);
                    if(decision == 1){
                        print("Doubled your attack!");
                        player2attack = player2attack*2;
                    }else{
                        print("Attacked!");
                        player1health = player1health-player2attack;
                        player2attack = 1;
                    }
                    if(player2health <= 0){print("You winn!"); input(decision);}
                    if(player1health <= 0){print("You winn!"); input(decision);}

                }
                """;


        // Parse Input
        input = CharStreams.fromString(bglCodeExample);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);



        // Symmbol harvester
        SymbolHarvester SH = new SymbolHarvester();
        SymbolTable ST = (SymbolTable) ast.accept(SH);

        // GNU GAS assembly - code generation
        GNUASMCodeGenerator generator = new GNUASMCodeGenerator(ST);

        // Pass generator to ast
        String code = (String) ast.accept(generator);
        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.s", false);
            fw.write(code);
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
