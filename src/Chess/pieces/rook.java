package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;

public class rook extends ChessPiece {

    public rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "r" ;
    }

}
