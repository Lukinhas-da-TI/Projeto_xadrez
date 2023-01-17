package application;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.util.Scanner;

public class program {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);


        ChessMatch chessMatch = new ChessMatch();
        while(true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source : ");
            ChessPosition source = UI.ReadChessPosition(sc);

            System.out.println("Target : ");
            ChessPosition target = UI.ReadChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.PerfomChessMove(source, target);
        }
    }
}
