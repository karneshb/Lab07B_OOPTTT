public class Board{
    private String[][] game;

    public Board(){
        game = new String[3][3];
        resetBoard();
    }

    public void resetBoard(){
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                game[row][col] = "";
            }
        }
    }

    public boolean playerMove(Move move){
        if(game[move.getRow()][move.getCol()].equals("")){
            game[move.getRow()][move.getCol()] = move.getPlayer();
            return true;
        }
        return false;
    }

    public String getTile(int row, int col){
        return game[row][col];
    }

    public boolean checkWin(String symbol){
        for (int i = 0; i < 3; i++) {
            if (symbol.equals(game[i][0]) && symbol.equals(game[i][1]) && symbol.equals(game[i][2])){
                return true;
            }
            if (symbol.equals(game[0][i]) && symbol.equals(game[1][i]) && symbol.equals(game[2][i])){
                return true;
            }
            if (symbol.equals(game[0][0]) && symbol.equals(game[1][1]) && symbol.equals(game[2][2])){
                return true;
            }
        }
        return symbol.equals(game[0][2]) && symbol.equals(game[1][1]) && symbol.equals(game[2][0]);
    }

    public boolean checkTie(){
        for(int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if(game[row][col].equals("")){
                    return false;
                }
            }
        }
        return true;
    }
}
