package boardgame;

public class position {

    private int row;
    private int column;

    public position(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString(){
        return row + ", " + column;
    }

}
