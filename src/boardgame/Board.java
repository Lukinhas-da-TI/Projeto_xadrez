package boardgame;

public class Board {

    private Piece[][] pieces;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1 ){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece (int row, int column){
        if(!positionexists(row,column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionexists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void PlacePiece(Piece piece, Position position){
        if(thereIsaPiece(position)){
            throw new BoardException("there is already a piece on position " + position);
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionexists(int row, int column){
       return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionexists(Position position){
        return positionexists(position.getRow(), position.getColumn());
    }

    public boolean thereIsaPiece(Position position){
        if (!positionexists(position)){
            throw new BoardException("this position doesnt exists");
        }
        return piece(position) != null;
    }

    public Piece RemovePiece(Position position){
        if (!positionexists(position)){
            throw new BoardException("this position doesnt exists");
        }else{
            if (piece(position) == null){
                return null;
            }
            Piece aux = piece(position);
            aux.position = null;
            pieces[position.getRow()][position.getColumn()] = null;
            return aux;
        }
    }

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


}
