package Demos;

import ASTnodes.ASTNode;
import CodeGeneration.CCodeGenerator;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ASTvisitors.ASTbuilder;

import java.io.FileWriter;
import java.io.IOException;

public class CGenerationDemo {
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
        String bglCodeExample =
                """
                  SETUP{
                      list: list: int board = [[0,0,0],[0,0,0],[0,0,0]];
                  }
                  RULES{
                        action printBoard(list: int board){
                            int j = 1;
                            int i11,i21,i31,i12,i22,i32,i13,i23,i33;
                            i11 = board[1][1];
                            i21 = board[2][1];
                            i31 = board[3][1];
                            i12 = board[1][2];
                            i22 = board[2][2];
                            i32 = board[3][2];
                            i13 = board[1][3];
                            i23 = board[2][3];
                            i33 = board[3][3];
                            print(i11,i21,i31);
                            print(i12,i22,i32);
                            print(i13,i23,i33);
                        }
                        action playerTurn(int player){
                            int x = 0;
                            int y = 0;
                            if(player == 0){
                                print("Player Cross turn:");
                            }else{
                                print("Player Circle turn:");
                            }
                            print("please type in your x coordinate to move a piece to");
                            input(x);
                            print("please type in your y coordinate to move a piece to");
                            input(y);
                            
                        }
                  }
                  GAMELOOP{
                      printBoard(board);
                      playerTurn(1);
                      exit;
                  }
                  """;

        // Parse Input
        input   = CharStreams.fromString(bglCodeExample);
        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        // Symmbol harvester
        SymbolHarvester SH = new SymbolHarvester();
        SymbolTable ST = (SymbolTable) ast.accept(SH);
        ST.resetScopePointers();

        // C - code generation
        CCodeGenerator generator = new CCodeGenerator(ST, SH.TENV);

        // Pass generator to ast
        String code = (String) ast.accept(generator);
        System.out.println(code);
        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.c",false);
            fw.write(code);
            System.out.println("Compiled successfully");
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
