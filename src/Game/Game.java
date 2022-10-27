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

    private void gameLoop() {
        while (running) {
            printBoard();
            IntTupel input = readMove();
            addMove(input, currentPlayer);

            currentPlayer = currentPlayer == Players.player1 ? Players.player2 : Players.player1;
        }
    }

    private void printBoard(){
        out.print(board);
    }

    private IntTupel readMove(){
        IntTupel input = in.readMove();//x1 = x && x2 = y
        return input;
    }

    private void addMove(IntTupel input, Players currentPlayer){
        try {
            board.addMove(input.getX1(), input.getX2(), currentPlayer);
        } catch (NotValidMoveException e) {
            //TODO add new input
        }
    }
}