import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private GameRunner game;
    private TileButton[][] board;

    public GameFrame(){
        game = new GameRunner();
        board = new TileButton[3][3];
        setTitle("Tic Tac Toe");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));

        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board[row][col] = new TileButton(row,col);
                board[row][col].setFont(new Font("Cosmic Sans", Font.BOLD, 50));
                board[row][col].addActionListener(new ButonClickListener());
                add(board[row][col]);
            }
        }
    }

    private void updateBoard(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board[row][col].setText("");
            }
        }
    }

    private class ButonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            TileButton tile = (TileButton) e.getSource();
            if(game.makeMove(tile.getRow(), tile.getCol())){
                tile.setText(game.getCurrentPlayer().getPlayer());

                if(game.win()){
                    JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer().getPlayer() + " wins!");
                    game.reset();
                    updateBoard();
                } else if (game.tie()){
                    JOptionPane.showMessageDialog(null, "It's a tie!");
                    game.reset();
                    updateBoard();
                } else{
                    game.switchPlayer();
                }
            }
        }
    }
}
