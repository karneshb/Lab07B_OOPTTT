public class GameRunner {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public GameRunner(){
        board = new Board();
        playerX = new Player("X");
        playerO = new Player("O");
        currentPlayer = playerX;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean makeMove(int row, int col){
        Move move = new Move(row, col, currentPlayer.getPlayer());
        return board.playerMove(move);
    }

    public void switchPlayer(){
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public boolean win(){
        return board.checkWin(currentPlayer.getPlayer());
    }

    public boolean tie(){
        return board.checkTie();
    }

    public void reset(){
        board.resetBoard();
        currentPlayer = playerX;
    }

    public String getCellText(int row, int col){
        return board.getTile(row, col);
    }
}
