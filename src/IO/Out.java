package IO;

import Game.Board;
import util.Colors;

public class Out {
    public void print(Board board) {
        switch (board.getNextActiveField().getX2()) {
            case 1 ->
                    System.out.println(Colors.GREEN_BRIGHT + "   a  b  c  " + Colors.RESET + "|  d  e  f  |  g  h  i");
            case 2 ->
                    System.out.println("   a  b  c  |" + Colors.GREEN_BRIGHT + "  d  e  f  " + Colors.RESET + "|  g  h  i");
            case 3 ->
                    System.out.println("   a  b  c  |  d  e  f  |" + Colors.GREEN_BRIGHT + "  g  h  i" + Colors.RESET);
        }

        for (int i = 0; i < 9; i++) {
            int line = i + 1;

            if (i == 3 || i == 6) {
                System.out.println("-----------------------------------");
            }
            System.out.print(line + " ");
            for (int j = 0; j < 9; j++) {
                String content = switch (board.getContent()[i][j]) {
                    case 0 -> "X";
                    case 1 -> "O";
                    default -> " ";
                };

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