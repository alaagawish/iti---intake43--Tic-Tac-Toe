package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.network.Network;
import tictactoe.screens.splash.SplashBase;

public class TicTacToe extends Application {

    Network network;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new SplashBase(stage);
        Scene scene = new Scene(root);
        network = new Network();
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void stop() throws Exception {
        network.closeConnection();

    }

}
