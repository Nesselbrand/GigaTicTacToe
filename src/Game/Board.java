package Game;

import util.NotValidMoveException;
import util.Players;

public class Board {
    private int[][] content;

    public Board() {
        content = new int[9][9];

        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                content[i][j] = -1;
            }
        }
    }

    public void addMove(int x_raw, int y_raw, Players player) throws NotValidMoveException { //x and y not 0 based
        int currentPlayer = player == Players.player1 ? 0 : 1;
        int x = x_raw - 1;
        int y = y_raw - 1;

        if (content[x][y] == -1){
            content[x][y] = currentPlayer;
        } else {
            throw new NotValidMoveException();
        }
    }
}