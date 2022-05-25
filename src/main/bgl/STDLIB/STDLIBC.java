package STDLIB;

import ASTnodes.ASTNode;
import ASTnodes.NonScopeBlockNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class STDLIBC {

    public static String imports =
            """
            #include <stdio.h>
            #include <stdbool.h>
            #include <math.h>
            #include <string.h>
            #include <stdlib.h>
            """;

    public static String defines =
            """
            #define foreach(item, array)                         \\
                for (int keep = 1,                               \\
                         count = 0,                              \\
                         size = __builtin_types_compatible_p(typeof(array), char*) ? (strlen(array)): (sizeof(array) / sizeof *(array));\\
                     keep && count != size;                      \\
                     keep = !keep, count++)                      \\
                    for (item = (array) + count; keep; keep = !keep)\\
                    
            """;

    public static NonScopeBlockNode getAST() {

        // All predefined designs
        Path stdPath     = new Path();
        Piece stdPiece   = new Piece();
        Player stdPlayer = new Player();
        Tile stdTile     = new Tile();

        // PATH
        List<ASTNode> PathAST = new ArrayList<>();
        PathAST.add(stdPath.getDesign());
        PathAST.addAll(stdPath.getImplementedActions());

        // Piece
        List<ASTNode> PieceAST = new ArrayList<>();
        PieceAST.add(stdPiece.getDesign());
        PieceAST.addAll(stdPiece.getImplementedActions());

        // Player
        List<ASTNode> PlayerAST = new ArrayList<>();
        PlayerAST.add(stdPlayer.getDesign());
        PlayerAST.addAll(stdPlayer.getImplementedActions());

        // Tile
        List<ASTNode> TileAST = new ArrayList<>();
        TileAST.add(stdTile.getDesign());
        TileAST.addAll(stdTile.getImplementedActions());

        // Collected Nodes
        List<ASTNode> nodes = new ArrayList<>();

        //Order matters here, as there is dependencies between the designs
        nodes.addAll(TileAST);
        nodes.addAll(PieceAST);
        nodes.addAll(PlayerAST);
        nodes.addAll(PathAST);

        return new NonScopeBlockNode(nodes.toArray(new ASTNode[0]));
    }
}
