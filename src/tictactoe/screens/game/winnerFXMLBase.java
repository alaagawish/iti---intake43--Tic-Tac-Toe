package tictactoe.screens.game;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.screens.dualmode.DualModeBase;

public class winnerFXMLBase extends AnchorPane {

    protected final Text headerTextView;
    protected final MediaView winMediaView;
    protected final Button backButton;

    public winnerFXMLBase(Stage stage) {

        headerTextView = new Text();
        winMediaView = new MediaView();
        backButton = new Button();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        headerTextView.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        headerTextView.setLayoutX(319.0);
        headerTextView.setLayoutY(113.0);
        headerTextView.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        headerTextView.setStrokeWidth(0.0);
        headerTextView.setText("Player X is Winner");
        headerTextView.setFont(new Font("Comic Sans MS Bold", 70.0));
        
        

        winMediaView.setFitHeight(400.0);
        winMediaView.setFitWidth(500.0);
        winMediaView.setLayoutX(390.0);
        winMediaView.setLayoutY(170.0);

        Media media = new Media(getClass().getResource("/assets/images/winnerVideo.mp4").toExternalForm());  


         
        MediaPlayer mediaPlayer = new MediaPlayer(media); 
        winMediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setAutoPlay(true);

        backButton.setLayoutX(567.0);
        backButton.setLayoutY(612.0);
        backButton.setMnemonicParsing(false);
        backButton.setStyle("-fx-background-color: #3dc0c2; -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        backButton.setText("Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#fffefe"));
        backButton.setFont(new Font("Comic Sans MS", 50.0));
        
        backButton.setOnMousePressed(e -> {
            Parent pane = new DualModeBase(stage);
            stage.getScene().setRoot(pane);
            mediaPlayer.stop();

        });

        getChildren().add(headerTextView);
        getChildren().add(winMediaView);
        getChildren().add(backButton);

    }
}
