package Chess;

import Chess.pieces.King;
import Chess.pieces.rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialsetup();
    }

    public  ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
       for(int i = 0; i<board.getRows();i++){
           for (int y=0; y< board.getColumns();y++){
               mat[i][y] = (ChessPiece) board.piece(i, y);
           }
       }
       return mat;
    }

    private void initialsetup(){
        board.PlacePiece(new rook(board, Color.WHITE), new Position(2,1));
        board.PlacePiece(new King(board, Color.WHITE), new Position(2, 1));
    }


}
