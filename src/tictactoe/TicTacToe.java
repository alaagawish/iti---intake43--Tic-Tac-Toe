package tictactoe;

import com.sun.javafx.applet.Splash;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.screens.splash.SplashBase;

public class TicTacToe extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new SplashBase();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
