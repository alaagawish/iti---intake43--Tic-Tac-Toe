package tictactoe.screens.splash;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SplashBase extends AnchorPane {

    protected final ImageView logoImage;
    protected final Text ticTacToeText;

    public SplashBase() {

        logoImage = new ImageView();
        ticTacToeText = new Text();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(to bottom, #1E595C, #3BB2B8);;");

        logoImage.setFitHeight(410.0);
        logoImage.setFitWidth(390.0);
        logoImage.setLayoutX(445.0);
        logoImage.setLayoutY(108.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);
        logoImage.setImage(new Image(getClass().getResource("//F:/ITI/Java/Final%20Project/iti---intake43--Tic-Tac-Toe/src/assets/images/logo.png").toExternalForm()));

        ticTacToeText.setFill(javafx.scene.paint.Color.valueOf("#ffdf59"));
        ticTacToeText.setLayoutX(297.0);
        ticTacToeText.setLayoutY(660.0);
        ticTacToeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticTacToeText.setStrokeWidth(0.0);
        ticTacToeText.setText("TicTacToe");
        ticTacToeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ticTacToeText.setWrappingWidth(724.13671875);
        ticTacToeText.setFont(new Font("Comic Sans MS Bold", 96.0));

        getChildren().add(logoImage);
        getChildren().add(ticTacToeText);

    }
}
