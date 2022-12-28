package Game;

import util.IntTupel;
import util.NotValidMoveException;
import util.Players;

public class Board {
    private int[][] content;
    private int[][] smallWinTracker;

    private IntTupel nextActiveField;
    private IntTupel activeField;


    public IntTupel getActiveField() {
        return activeField;
    }

    public void setActiveField(IntTupel activeField) {
        this.activeField = activeField;
    }

    public Board() {
        content = new int[9][9];
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                content[i][j] = -1;
            }
        }

        smallWinTracker = new int[3][3];
        for (int i = 0; i < smallWinTracker.length; i++) {
            for (int j = 0; j < smallWinTracker.length; j++) {
                smallWinTracker[i][j] = -1;
            }
        }

        nextActiveField = new IntTupel(-1, -1);
        activeField = new IntTupel(-1, -1);
    }

    public void addMove(int y_raw, int x_raw, Players player) throws NotValidMoveException { //x and y not 0 based
        int currentPlayer = player == Players.player1 ? 0 : 1;
        int x = y_raw - 1;
        int y = x_raw - 1;

        if (nextActiveField.getX1() != -1){
            if (!(nextActiveField.getX1() == activeField.getX1() && nextActiveField.getX2() == activeField.getX2())){
                throw new NotValidMoveException();
            }
        }
        if (content[x][y] == -1) {
            content[x][y] = currentPlayer;
        } else {
            throw new NotValidMoveException();
        }
    }

    public int[][] getSmallWinTracker() {
        return smallWinTracker;
    }

    public void setXYValueSmallWinTracker(IntTupel activeeField, int input) {
        smallWinTracker[activeeField.getX1() - 1][activeeField.getX2() - 1] = input;
    }

    public int[][] getContent() {
        return content;
    }

    public IntTupel getNextActiveField() {
        return nextActiveField;
    }

    public void setNextActiveField(IntTupel nextActiveField) {
        this.nextActiveField = nextActiveField;
    }
}