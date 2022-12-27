
package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.screens.singlemode.LevelsBase;

import tictactoe.screens.game.GameBase;

import tictactoe.screens.profile.ProfileBase;



public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {


        Parent root = new GameBase();

        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
//        stage.setWidth(1280);
//        stage.setHeight(800);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
