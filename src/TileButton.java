import javax.swing.JButton;

public class TileButton extends JButton{
    private int row;
    private int col;

    public TileButton(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
