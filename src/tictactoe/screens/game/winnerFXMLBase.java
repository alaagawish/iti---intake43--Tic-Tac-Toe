package tictactoe.screens.game;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class winnerFXMLBase extends AnchorPane {

    protected final Text headerTextView;
    protected final MediaView winMediaView;
    protected final Button cancelButton;

    public winnerFXMLBase() {

        headerTextView = new Text();
        winMediaView = new MediaView();
        cancelButton = new Button();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        headerTextView.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        headerTextView.setLayoutX(100.0);
        headerTextView.setLayoutY(113.0);
        headerTextView.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        headerTextView.setStrokeWidth(0.0);
        headerTextView.setText("Winner Winner Chicken Dinner");
        headerTextView.setFont(new Font("Comic Sans MS Bold", 70.0));

        winMediaView.setFitHeight(400.0);
        winMediaView.setFitWidth(500.0);
        winMediaView.setLayoutX(390.0);
        winMediaView.setLayoutY(170.0);

        Media media = new Media(getClass().getResource("/assets/images/winnerVideo.mp4").toExternalForm());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        winMediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setAutoPlay(true);

        cancelButton.setLayoutX(567.0);
        cancelButton.setLayoutY(612.0);
        cancelButton.setMnemonicParsing(false);
        cancelButton.setStyle("-fx-background-color: #3dc0c2; -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        cancelButton.setText("Cancel");
        cancelButton.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        cancelButton.setFont(new Font("Comic Sans MS", 50.0));

        getChildren().add(headerTextView);
        getChildren().add(winMediaView);
        getChildren().add(cancelButton);

        cancelButton.setOnAction(e -> {
            
          winMediaView.getMediaPlayer().stop();

        });

    }
}
