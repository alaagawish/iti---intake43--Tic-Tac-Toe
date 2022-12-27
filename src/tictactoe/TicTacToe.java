
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.screens.authentication.SignUpBase;

import tictactoe.screens.authentication.LoginBase;

import tictactoe.screens.dualmode.LocalBase;



public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SignUpBase();

        
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
