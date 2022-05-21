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
                        SETUP {
                            int b = 5;
                            int a = random(5);
                            int dice = random(6);
                            
                            design piece {
                        str name;
                        }
                        design player {
                        list:tile tiles;
                        }
                        design tile {
                        list:piece pieces;
                        }
                                        
                        list:Path endPaths;
                                        
                                        
                        int i = 1;
                                        
                        piece p1 = {"hdhd"};
                                        
                         p1.name;
                                        
                           list:int theList = [1];
                           
                           theList[i] = theList[i];
                           path player1EndPath[6];
                            
                        }
                                        
                                RULES {
                                    action selectPiece(): int {
                                        int number = 0;
                                        while (number < 1 || number > 4) {
                                            print("Select a piece number between 1 and 4");
                                            input(number);
                                        }
                                        return number;
                                    }
                                                
                                    action checkWinCondition(int i): bool {
                                        tile tempTile;
                                        if (i == 1) {
                                        tempTile = player1EndPath.tiles[6];
                                        piece tempPiece = tempTile[4];
                                        str tempName = tempPiece.name;
                                        }
                                        elseif (i == 2) {
                                                    tempTile = player2EndPath.tiles[6];
                                                    piece tempPiece = tempTile[4];
                                                    str tempName = tempPiece.name;
                                                    }
                                                    elseif (i == 3) {
                                                                tempTile = player3EndPath.tiles[6];
                                                                piece tempPiece = tempTile[4];
                                                                str tempName = tempPiece.name;
                                                                }
                                                                elseif (i == 4) {
                                                                            tempTile = player4EndPath.tiles[6];
                                                                            piece tempPiece = tempTile[4];
                                                                            str tempName = tempPiece.name;
                                                                            }
                                        if (tempName != "") {
                                        return true;
                                        }
                                        else {
                                        return false;
                                        }
                                    }
                              
                            action throwDice(int start, int end):int{
                                return random(end-start+1) +start-1;
                            }
                        }
                                        
                        GAMELOOP {
                            a = throwDice(100,250);
                            print(a);
                            print(random(5));
                            print(random(a));
                            print(random(a+5));
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
