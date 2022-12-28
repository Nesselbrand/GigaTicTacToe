package util;

import Game.Board;

public class Logic {
    public static IntTupel findNextBigField(IntTupel input, Board board) {
        IntTupel result = new IntTupel(-1, -1);
        int rx1 = input.getX1() % 3;
        int rx2 = input.getX2() % 3;
        rx1 = rx1 == 0 ? 3 : rx1;
        rx2 = rx2 == 0 ? 3 : rx2;
        result.setX1(rx1);
        result.setX2(rx2);

        int[][] smallWinTracker = board.getSmallWinTracker();
        int[] smallWinsRow = new int[9];
        int ii = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                smallWinsRow[ii] = smallWinTracker[i][j];
                ii++;
            }
        }

        while (smallWinTracker[result.getX1() - 1][result.getX2() - 1] != -1) {
            double positionInRow = (result.getX1() - 1) * 3 + result.getX2();
            positionInRow %= 9;
            positionInRow++;
            result.setX1((int) Math.ceil(positionInRow / 3));
            result.setX2((int) (positionInRow % 3));
        }
        return result;
    }

    public static IntTupel findActiveField(IntTupel intTupel) {
        IntTupel result = new IntTupel(-1, -1);
        int rx1 = (int) Math.ceil((double) (intTupel.getX1()) / 3);
        int rx2 = (int) Math.ceil((double) (intTupel.getX2()) / 3);
        result.setX1(rx1);
        result.setX2(rx2);
        return result;
    }

    public static boolean isString(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static int testForWin(Board board) {
        IntTupel activeField = board.getActiveField();
        int x1 = activeField.getX1();
        int x2 = activeField.getX2();
        int[][] subBoard = new int[3][3];
        int ii = 0;
        int jj = 0;
        for (int i = x1 * 3; i > ((x1 * 3) - 3); i--) {
            for (int j = x2 * 3; j > ((x2 * 3) - 3); j--) {
                subBoard[ii][jj] = board.getContent()[i - 1][j - 1];
                jj++;
            }
            ii++;
            jj = 0;
        }
        board.setXYValueSmallWinTracker(activeField, test3x3(subBoard));
        return test3x3(board.getSmallWinTracker());
    }

    private static int test3x3(int[][] input) {
        if (input.length == 3 && input[0].length == 3) {

            boolean possibleDraw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (input[i][j] == -1) {
                        possibleDraw = false;
                        break;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                int ret = test3tupels(new IntTupel(i, 0), new IntTupel(i, 1), new IntTupel(i, 2), input);
                if (ret != -1) {
                    return ret;
                }
                ret = test3tupels(new IntTupel(0, i), new IntTupel(1, i), new IntTupel(2, i), input);
                if (ret != -1) {
                    return ret;
                }
            }
            int ret = test3tupels(new IntTupel(0, 0), new IntTupel(1, 1), new IntTupel(2, 2), input);
            if (ret != -1) {
                return ret;
            }
            ret = test3tupels(new IntTupel(0, 2), new IntTupel(1, 1), new IntTupel(2, 0), input);
            if (ret == -1 && possibleDraw){
                return -2;
            }
            return ret;
        }
        return -1;
    }

    private static int test3tupels(IntTupel t1, IntTupel t2, IntTupel t3, int[][] field) {
        if (field[t1.getX1()][t1.getX2()] == field[t2.getX1()][t2.getX2()] && field[t2.getX1()][t2.getX2()] == field[t3.getX1()][t3.getX2()] && field[t1.getX1()][t1.getX2()] != -1) {
            return field[t1.getX1()][t1.getX2()];
        } else {
            return -1;
        }
    }
}