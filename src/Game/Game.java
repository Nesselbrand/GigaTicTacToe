package Game;

import IO.In;
import IO.Out;
import util.Board;
import util.NotValidMoveException;
import util.Players;

public class Game {
    private boolean running;

    private Board board;
    private In in;
    private Out out;

    public void start() {
        init();
        gameLoop();
    }

    private void init() {
        running = true;
        board = new Board();
        in = new In();
        out = new Out();
    }

    private void gameLoop() {
        while (running) {
            try {
                board.addMove(1, 1, Players.player1);

            } catch (NotValidMoveException e) {

            }
        }
    }
}