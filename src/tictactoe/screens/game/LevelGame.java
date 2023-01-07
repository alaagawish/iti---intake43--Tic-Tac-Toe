
package tictactoe.screens.game;

import tictactoe.constants.Level;
import tictactoe.models.Move;
import tictactoe.models.Player;


public class LevelGame {
    
    public GameManager gameManager;
    Player playerOne, playerTwo;
    
    public LevelGame(Player playerOne, Player playerTwo, char board[][]) {

        gameManager = new GameManager(playerOne, playerTwo, board, Level.HARD);

    }
    
    public Move findBestMove(char board[][]) {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.column = -1;
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int moveVal = minimax(100, false,board);
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

    public int minimax(int depth, boolean isMaximizing,char board[][]) {
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
                        int score = minimax(depth - 1, false,board);
                        bestScore = Integer.max(score, bestScore);
                        board[i][j] = ' ';
                    }
                }
            }

            return bestScore;
        } 
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the cell available?
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(depth - 1, true,board);
                        bestScore = Integer.min(score, bestScore);
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        }
    }
    
    public Move playComputer(char [][]board , Level levelMode) {
        Move bestMove = new Move();
        if(levelMode == Level.HARD){
            bestMove = findBestMove(board);
        }
//        else if(levelMode == "Easy"){
//            
//        }else if(levelMode == "Medium"){
//            
//        }
        return bestMove;
    }

    
}

//class Move {
//    public int row;
//    public int column;
//}
