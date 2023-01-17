package Chess;

import Chess.pieces.King;
import Chess.pieces.rook;
import boardgame.Board;
import boardgame.Piece;
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

    public ChessPiece PerfomChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsaPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.RemovePiece(source);
        Piece capturedPiece = board.RemovePiece(target);
        board.PlacePiece(p, target);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.PlacePiece(piece, new ChessPosition(column, row).toPosition());
    }



    private void initialsetup(){

        placeNewPiece('c', 1, new rook(board, Color.WHITE));
        placeNewPiece('c', 2, new rook(board, Color.WHITE));
        placeNewPiece('d', 2, new rook(board, Color.WHITE));
        placeNewPiece('e', 2, new rook(board, Color.WHITE));
        placeNewPiece('e', 1, new rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new rook(board, Color.BLACK));
        placeNewPiece('c', 8, new rook(board, Color.BLACK));
        placeNewPiece('d', 7, new rook(board, Color.BLACK));
        placeNewPiece('e', 7, new rook(board, Color.BLACK));
        placeNewPiece('e', 8, new rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }


}
