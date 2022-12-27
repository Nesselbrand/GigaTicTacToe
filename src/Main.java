import Game.Game;
import Game.Board;
import IO.Out;

public class Main {
    private static Game game;
    public static void main(String[] args) {
        //game = new Game();
        //game.start();
        Board board = new Board();
        Out out = new Out();
        out.print(board);
    }
}