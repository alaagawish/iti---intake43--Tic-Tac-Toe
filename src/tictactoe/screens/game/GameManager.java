package tictactoe.screens.game;

import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.Random;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.GameModel;
import tictactoe.models.Move;
import tictactoe.models.Player;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import tictactoe.utils.Dialogs;
import tictactoe.utils.UtilsFunctions;

public class GameManager {

    private static Player xPlayer;
    private static Player oPlayer;
    private static char turn;
    private static char[][] board;
    public static Level level;
    private static Player winner;
    private static int computerRound;
    private List<Move> moves;
    private GameModel gameModel;
    private boolean recordFlag;
    private File fileName;

    public GameManager() {

    }

    public GameManager(Player xPlayer, Player oPlayer, char[][] board, Level level) {
        this.moves = new ArrayList<>();
        computerRound = 1;
        turn = Constants.X;
        GameManager.board = board;
        recordFlag = false;
        GameManager.xPlayer = xPlayer;
        GameManager.oPlayer = oPlayer;
        GameManager.level = level;
        gameModel = new GameModel();
    }

    public boolean isRecorded() {
        return recordFlag;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public void setRecorded(boolean recordFlag) {
        this.recordFlag = recordFlag;
    }

    public void createFile() {
        String gameDirectoryName = Constants.RECORDEDGAMEPATH;

        File gameDirectory = new File(gameDirectoryName);

        if (!gameDirectory.exists()) {
            gameDirectory.mkdir();
        }
        
        File playerDirectory;
        String playerDirectoryName = "";
        
        if (level == Level.ONLINE) {
            playerDirectoryName = Constants.RECORDEDGAMEPATH.concat(xPlayer.getUsername());
            playerDirectory = new File(playerDirectoryName);
            if (!playerDirectory.exists()) {
                playerDirectory.mkdir();
            }
        } else if (level == Level.LOCAL || level == Level.Easy || level == Level.HARD || level == Level.MEDIUM) {
            playerDirectoryName = Constants.RECORDEDGAMEPATH.concat(Constants.RECORDEDGAMEPATH_LOCAL);
            playerDirectory = new File(playerDirectoryName);
            if (!playerDirectory.exists()) {
                playerDirectory.mkdir();
            }
        }

        String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
        String timeStampAfterReplace = timeStamp.replace(":", "-");
        fileName = new File(playerDirectoryName
                + "\\" + xPlayer.getUsername()
                + "-" + oPlayer.getUsername()
                + "-" + timeStampAfterReplace + ".txt");
        try {
            if (fileName.createNewFile()) {
                System.out.println("File created: " + fileName.getName());
            } else {
                Dialogs.showAlertDialog(Alert.AlertType.INFORMATION,
                        "File Info",
                        "File already Exist",
                        fileName.getAbsolutePath());
                System.out.println("File already exists.");
            }

        } catch (IOException ex) {
            Dialogs.showAlertDialog(Alert.AlertType.ERROR,
                    "Error",
                    "Error in Create File",
                    ex.getMessage());
            System.out.println("IOException from File :" + ex);
            ex.printStackTrace();
        }
    }

    public void saveGame() {
        try {
            gameModel.setxPlayer(xPlayer);
            gameModel.setoPlayer(oPlayer);
            gameModel.setMovesList(moves);
            System.out.println(gameModel);
            System.out.println(moves.get(0).getRow() + "inside save game");
            System.out.println(gameModel.getoPlayer());
            System.out.println(gameModel.getxPlayer());

            try (FileWriter writer = new FileWriter(fileName.getAbsolutePath())) {
                new Gson().toJson(gameModel, writer);
                /*
                writer.write(gameModel.getxPlayer().getUsername());
                writer.write("\r\n");
                writer.write(gameModel.getoPlayer().getUsername());
                writer.write("\r\n");
                System.err.println(moves.get(0).getSymbol() + "symbol inside 0 cell at " + moves.get(0).getRow() + " " + moves.get(0).getColumn());
                System.out.println(gameModel.toString());
                for (int i = 0; i < moves.size(); i++) {
                writer.write(Integer.toString(moves.get(i).getRow()).concat("-").
                concat(Integer.toString(moves.get(i).getColumn())).concat("-").
                concat(moves.get(i).getSymbol() + ""));
                writer.write("\r\n");
                }
                 */
            }
        } catch (IOException ex) {
            Dialogs.showAlertDialog(Alert.AlertType.ERROR,
                    "Error",
                    "Error happin in Save Gson File",
                    ex.getMessage());
            System.out.println("Error from IOException in saveGame" + ex.getLocalizedMessage());
        }
    }

    public void addMove(int i, int j, char turn) {
        System.out.println(turn);
        Move move = new Move(i, j, turn);
        moves.add(move);
    }

    public void printArray() {
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.get(i).getSymbol());
            System.out.println(moves.get(i).getRow());
            System.out.println(moves.get(i).getColumn());
        }
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

    private Move findBestMove(char board[][]) {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move();
        bestMove.setRow(-1);
        bestMove.setColumn(-1);
        bestMove.setSymbol(turn);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    board[i][j] = Constants.O;
                    int moveVal = minimax(100, false, board);
                    board[i][j] = ' ';
                    if (moveVal > bestVal) {
                        bestMove.setRow(i);
                        bestMove.setColumn(j);
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
                        board[i][j] = Constants.O;
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
                        board[i][j] = Constants.X;
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
        move.setRow(-1);
        move.setColumn(-1);
        move.setSymbol(turn);

        if (computerRound < 5) {
            Random rand = new Random();

            int x;
            int y;

            do {
                x = rand.nextInt(3);
                y = rand.nextInt(3);
            } while (board[x][y] != ' ');

            move.setRow(x);
            move.setColumn(y);
        }

        computerRound++;
        return move;
    }

    private Move findMediumMove(char board[][]) {

        Move move = new Move();
        move.setRow(-1);
        move.setColumn(-1);
        move.setSymbol(turn);

        if (computerRound == 3) {
            move = findRandomMove(board);
        } else {
            move = findBestMove(board);
        }
        computerRound++;
        return move;
    }

}
