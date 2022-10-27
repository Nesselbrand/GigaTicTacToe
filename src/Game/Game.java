package Game;

import IO.In;
import IO.Out;
import util.IntTupel;
import util.NotValidMoveException;
import util.Players;

public class Game {
    private boolean running;
    private Players currentPlayer;

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
        currentPlayer = Players.player1;
    }

    private void gameLoop() {//TODO einzelne Operationen als Methoden um zwischen Methoden jumpen zu können
        while (running) {
            try {
                out.print(board);
                IntTupel input = in.readMove(); //x1 = x && x2 = y
                board.addMove(input.getX1(), input.getX2(), Players.player1);

                currentPlayer = currentPlayer == Players.player1 ? Players.player2 : Players.player1;
            } catch (NotValidMoveException e) {

            }
        }
    }
}