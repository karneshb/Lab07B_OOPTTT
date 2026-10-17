public class Move {
    private int row;
    private int col;
    private String player;

    public Move(int row, int col, String player){
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public String getPlayer(){
        return player;
    }
}
