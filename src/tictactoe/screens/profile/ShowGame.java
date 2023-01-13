/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.screens.profile;

import java.util.logging.Logger;
import javafx.stage.Stage;
import tictactoe.constants.Level;
import tictactoe.models.GameModel;
import tictactoe.models.Move;
import tictactoe.screens.game.GameBase;

/**
 *
 * @author moazk
 */
public class ShowGame implements Runnable{

    GameBase gameBase;
    GameModel recordedGame;
    public ShowGame(Stage stage, GameModel game) {
        gameBase = new GameBase(stage, Level.HARD, game.getxPlayer(), game.getoPlayer());
        
        
        
        recordedGame = game;
        
    }
    
    @Override
    public void run() {
        
        if(gameBase != null){
            gameBase.disableButtons();
            try {
                for(int i=0;i<recordedGame.getMovesList().size();i++){
                    System.out.println("move"+recordedGame.getMovesList().get(i));
                    gameBase.computerMove(recordedGame.getMovesList().get(i));
                    
                    
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(GameBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
    
    public void computerMove(Move move) {
        if (move.getRow() == 0 && move.getColumn() == 0) {
            gameBase.button00.setText(move.getSymbol() + "");
            gameBase.button00.setDisable(true);

        } else if (move.getRow() == 0 && move.getColumn() == 1) {
            gameBase.button01.setText(move.getSymbol() + "");
            gameBase.button01.setDisable(true);

        } else if (move.getRow() == 0 && move.getColumn() == 2) {
            gameBase.button02.setText(move.getSymbol() + "");
            gameBase.button02.setDisable(true);

        } else if (move.getRow() == 1 && move.getColumn() == 0) {
            gameBase.button10.setText(move.getSymbol() + "");
            gameBase.button10.setDisable(true);

        } else if (move.getRow() == 1 && move.getColumn() == 1) {
            gameBase.button11.setText(move.getSymbol() + "");
            gameBase.button11.setDisable(true);

        } else if (move.getRow() == 1 && move.getColumn() == 2) {
            gameBase.button12.setText(move.getSymbol() + "");
            gameBase.button12.setDisable(true);

        } else if (move.getRow() == 2 && move.getColumn() == 0) {
            gameBase.button20.setText(move.getSymbol() + "");
            gameBase.button20.setDisable(true);

        } else if (move.getRow() == 2 && move.getColumn() == 1) {
            gameBase.button21.setText(move.getSymbol() + "");
            gameBase.button21.setDisable(true);

        } else if (move.getRow() == 2 && move.getColumn() == 2) {
            gameBase.button22.setText(move.getSymbol() + "");
            gameBase.button22.setDisable(true);

        }
    }
    
    
}
