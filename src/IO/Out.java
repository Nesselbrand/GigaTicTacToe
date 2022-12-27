package IO;

import Game.Board;

import java.util.Arrays;

public class Out {
    public void print(Board board) {
        System.out.println(board.getContent()[1][1]);
        System.out.println("   a  b  c  |  d  e  f  |  g  h  i");
        for (int i = 0; i < 9; i++) {
            int zeile = i + 1;

            if (i == 3 || i == 6) {
                System.out.println("-----------------------------------");
            }
            if (zeile != 4 || zeile != 7) {
                System.out.print(zeile + " ");
            }
            for (int j = 0; j < 9; j++) {
                System.out.print("[" + board.getContent()[i][j] + "]");
                if (j == 2 || j == 5) {
                    System.out.print(" | ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
}