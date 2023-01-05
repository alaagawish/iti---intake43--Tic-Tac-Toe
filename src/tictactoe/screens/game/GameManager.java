package tictactoe.screens.game;

import tictactoe.models.Player;

class GameSymbol {

    public static char X = 'X';
    public static char O = 'O';
}

enum Level {
    Easy, MEDIUM, HARD, LOCAL, ONLINE
}

public class GameManager {

    private static Player xPlayer;
    private static Player oPlayer;
    private static char turn;

    private static char[][] board;
    public static Level level;

    private static Player winner;

    private static int counter;

    public GameManager(Player xPlayer, Player oPlayer, char[][] board, Level level) {
        counter = 0;
        turn = GameSymbol.X;
        GameManager.board = board;
    }

    public static int checkWinner() {
        //  2: X winner
        // -2: O winner
        //  0: Tie
        //  1: No winner
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValue(board[i][0], board[i][1], board[i][2])) {

                return board[i][0] == 'X' ? 2 : -2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (haveTheSameValue(board[0][i], board[1][i], board[2][i])) {
                return board[0][i] == 'X' ? 2 : -2;
            }
        }

        if (haveTheSameValue(board[0][0], board[1][1], board[2][2])) {
            return board[0][0] == 'X' ? 2 : -2;
        }

        if (haveTheSameValue(board[2][0], board[1][1], board[0][2])) {
            return board[2][0] == 'X' ? 2 : -2;
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

    public static Player getoPlaye() {
        return oPlayer;
    }

    public static void setoPlaye(Player oPlayer) {
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
        return counter;
    }

    public static void setCounter(int counter) {
        GameManager.counter = counter;
    }

    public void reset() {

    }
}