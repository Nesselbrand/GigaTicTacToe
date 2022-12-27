package IO;

import Game.Board;

public class Out {
    public void print(Board board) {

        System.out.println("   a  b  c  |  d  e  f  |  g  h  i");
        for (int i = 0; i < 9; i++) {
            int line = i + 1;

            if (i == 3 || i == 6) {
                System.out.println("-----------------------------------");
            }
            System.out.print(line + " ");
            for (int j = 0; j < 9; j++) {
                String content = " ";
                switch(board.getContent()[i][j]){
                    case 0:
                        content = "X";
                        break;
                    case 1:
                        content = "O";
                        break;
                }

                System.out.print("[" + content + "]");
                if (j == 2 || j == 5) {
                    System.out.print(" | ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
}