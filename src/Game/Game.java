package Game;

import IO.In;
import IO.Out;
import util.IntTupel;
import util.Logic;
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
            int add_move_return_code;
            do {
                out.print("Turn: " + currentPlayer.name() + "\nYour move: ");
                add_move_return_code = addMove(currentPlayer);
                if (add_move_return_code == -1) {
                    out.print("The chosen move is invalid. Try again!\n");
                }
            } while (add_move_return_code != 1);
            if (Logic.testForWin(board) != -1) {
                printBoard();
                running = false;
                if (Logic.testForWin(board) == -2) {
                    out.print("its a draw!");
                } else {
                    out.print(currentPlayer + " has won!");
                }
            }
            currentPlayer = currentPlayer == Players.player1 ? Players.player2 : Players.player1;
        }
    }

    private void printBoard() {
        out.print(board);
    }

    private IntTupel readMove() throws NotValidMoveException {
        IntTupel input = in.readMove();//x1 = x && x2 = y
        return input;
    }

    private int addMove(Players currentPlayer) {
        try {
            IntTupel input = readMove();
            board.setActiveField(Logic.findActiveField(input));
            board.addMove(input.getX1(), input.getX2(), currentPlayer);
            board.setNextActiveField(Logic.findNextBigField(input, board));
            return 1;
        } catch (NotValidMoveException e) {
            return -1;
        }
    }
}