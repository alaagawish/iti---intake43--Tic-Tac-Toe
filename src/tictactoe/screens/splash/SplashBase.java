package tictactoe.screens.splash;


import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.screens.modes.ModeBase;

public class SplashBase extends AnchorPane {

    protected final ImageView logoImage;
    protected final Text ticTacToeText;

    public SplashBase(Stage stage) {

        logoImage = new ImageView();
        ticTacToeText = new Text();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(to bottom, #1E595C, #3BB2B8);");

        logoImage.setFitHeight(410.0);
        logoImage.setFitWidth(390.0);
        logoImage.setLayoutX(445.0);
        logoImage.setLayoutY(108.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);
        logoImage.setImage(new Image(getClass().getResource("/assets/images/logo.png").toExternalForm()));

        ticTacToeText.setFill(javafx.scene.paint.Color.valueOf("#ffdf59"));
        ticTacToeText.setLayoutX(297.0);
        ticTacToeText.setLayoutY(660.0);
        ticTacToeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticTacToeText.setStrokeWidth(0.0);
        ticTacToeText.setText("TicTacToe");
        ticTacToeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ticTacToeText.setWrappingWidth(724.13671875);
        ticTacToeText.setFont(new Font("Comic Sans MS Bold", 96.0));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(-10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setColor(Color.color(0, 0, 0, 0.6));

        ticTacToeText.setEffect(dropShadow);

        getChildren().add(logoImage);
        getChildren().add(ticTacToeText);


        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), this);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        fadeIn.play();

        try {
            fadeIn.setOnFinished((e) -> {
                Parent pane = new ModeBase(stage);
                stage.getScene().setRoot(pane);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
