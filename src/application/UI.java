package application;

import Chess.ChessPiece;

public class UI {

    public static void printBoard(ChessPiece[][] pieces){
         for(int i=0; i<pieces.length; i++){
             System.out.print((8 - i) + " ");
             for(int y=0; y<pieces.length;y++){
                 printPiece(pieces[i][y]);
             }
             System.out.println();
        }
        System.out.println("  a b c d e f g h ");
    }

    public static void printPiece(ChessPiece piece){
        if(piece == null){
            System.out.print("_ ");
        }
        else{
            System.out.print(piece);
        }
    }

}
