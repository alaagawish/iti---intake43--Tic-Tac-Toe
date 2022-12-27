/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.screens.dualmode.OnlineListBase;

/**
 *
 * @author moazk
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new OnlineListBase();
        
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
