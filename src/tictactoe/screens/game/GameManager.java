package tictactoe.screens.game;

import java.util.Random;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.Move;
import tictactoe.models.Player;

public class GameManager {

    private static Player xPlayer;
    private static Player oPlayer;

    private static char turn;

    private static char[][] board;
    public static Level level;

    private static Player winner;

    private static int computerRound;

    public GameManager(Player xPlayer, Player oPlayer, char[][] board, Level level) {
        computerRound = 1;
        turn = Constants.X;
        GameManager.board = board;

    }

    public static int checkWinner() {
        //  2: X winner
        // -2: O winner
        //  0: Draw
        //  1: Countinue
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValue(board[i][0], board[i][1], board[i][2])) {
                if (board[i][0] == Constants.O) {
                    setWinner(oPlayer);
                    return 2;
                } else {
                    setWinner(xPlayer);
                    return -2;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValue(board[0][i], board[1][i], board[2][i])) {
                if (board[0][i] == Constants.O) {
                    setWinner(oPlayer);
                    return 2;
                } else {
                    setWinner(xPlayer);
                    return -2;
                }
            }
        }

        if (haveTheSameValue(board[0][0], board[1][1], board[2][2])) {
            if (board[0][0] == Constants.O) {
                setWinner(oPlayer);
                return 2;
            } else {
                setWinner(xPlayer);
                return -2;
            }
        }

        if (haveTheSameValue(board[2][0], board[1][1], board[0][2])) {
            if (board[2][0] == Constants.O) {
                setWinner(oPlayer);
                return 2;
            } else {
                setWinner(xPlayer);
                return -2;
            }
        }

        boolean tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    tie = false;
                }
            }
        }
        if (tie) {
            return 0;
        }

        return 1;

    }

    public static boolean haveTheSameValue(char x, char y, char z) {
        return x == y && x == z && x != ' ';
    }

    public static Player getxPlayer() {
        return xPlayer;
    }

    public static void setxPlayer(Player xPlayer) {
        GameManager.xPlayer = xPlayer;
    }

    public static Player getoPlayer() {
        return oPlayer;
    }

    public static void setoPlayer(Player oPlayer) {
        GameManager.oPlayer = oPlayer;

    }

    public static char getTurn() {
        return turn;
    }

    public static void setTurn(char turn) {
        GameManager.turn = turn;
    }

    public static char[][] getBoard() {
        return board;
    }

    public static void setBoard(char[][] board) {
        GameManager.board = board;
    }

    public static Level getLevel() {
        return level;
    }

    public static void setLevel(Level level) {
        GameManager.level = level;
    }

    public static Player getWinner() {
        return winner;
    }

    public static void setWinner(Player winner) {
        GameManager.winner = winner;
    }

    public static int getCounter() {
        return computerRound;
    }

    public static void setCounter(int counter) {
        GameManager.computerRound = counter;
    }

    public void reset() {

    }

    private Move findBestMove(char board[][]) {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.column = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int moveVal = minimax(100, false, board);
                    board[i][j] = ' ';
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.column = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(int depth, boolean isMaximizing, char board[][]) {
        int gameState = GameManager.checkWinner();
        if (gameState != 1 || depth == 0) {
            return gameState;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the cell available?
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(depth - 1, false, board);
                        bestScore = Integer.max(score, bestScore);
                        board[i][j] = ' ';
                    }
                }
            }

            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the cell available?
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(depth - 1, true, board);
                        bestScore = Integer.min(score, bestScore);
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        }
    }

    public Move playComputer(char[][] board, Level levelMode) {
        Move bestMove = new Move();
        switch (levelMode) {
            case Easy:
                bestMove = findRandomMove(board);
                break;
            case MEDIUM:
                bestMove = findMediumMove(board);
                break;
            case HARD:
                bestMove = findBestMove(board);
                break;
            default:
                break;
        }
        return bestMove;
    }


    private Move findRandomMove(char board[][]) {
        Move move = new Move();
        move.row = -1;
        move.column = -1;
        if (computerRound < 5) {
            Random rand = new Random();

            int x;
            int y;

            do {
                x = rand.nextInt(3);
                y = rand.nextInt(3);
            } while (board[x][y] != ' ');

            move.row = x;
            move.column = y;
        }

        computerRound++;
        return move;
    }
    
       private Move findMediumMove(char board[][]) {

        Move move = new Move();
        move.row = -1;
        move.column = -1;

        if (computerRound == 3 ) {
            move = findRandomMove(board);
        } else {
            move = findBestMove(board);
        }
        computerRound++;
        return move;
    }

}
