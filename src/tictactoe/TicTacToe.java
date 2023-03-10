package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.game.winnerFXMLBase;
import tictactoe.screens.splash.SplashBase;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new SplashBase(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        if (DualModeBase.networkFlag) {
            DualModeBase.network.closeConnection();
        }

    }

}
