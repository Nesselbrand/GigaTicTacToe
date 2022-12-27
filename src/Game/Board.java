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

    public void addMove(int y_raw, int x_raw, Players player) throws NotValidMoveException { //x and y not 0 based
        int currentPlayer = player == Players.player1 ? 0 : 1;
        int x = y_raw - 1;
        int y = x_raw - 1;

        if (content[x][y] == -1) {
            content[x][y] = currentPlayer;
        } else {
            throw new NotValidMoveException();
        }
    }

    public int[][] getContent() {
        return content;
    }



}