package tictactoe.screens.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.screens.modes.ModeBase;
import tictactoe.screens.singlemode.LevelsBase;
import tictactoe.theme.CustomStyles;

public class winnerFXMLBase extends AnchorPane {

    public static String video;
    public static String message;
    protected final Text headerTextView;
    protected final MediaView winMediaView;
    protected final Button backButton;
    protected final Button PlayAgainButton;
    protected final Level level;
    public char playerTurn;

    public winnerFXMLBase(Stage stage, Level level, Player firstPlayer, Player secondPlayer, char playerSymbol) {
        headerTextView = new Text();
        winMediaView = new MediaView();
        backButton = new Button();
        PlayAgainButton = new Button();
        this.level = level;
        this.playerTurn = playerSymbol;
        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle(CustomStyles.GRADIENTBACKGROUND);

        headerTextView.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        headerTextView.setLayoutX(114.0);
        headerTextView.setLayoutY(139.0);
        headerTextView.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        headerTextView.setStrokeWidth(0.0);

        headerTextView.setText(message);
        headerTextView.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerTextView.setWrappingWidth(1050.01171875);
        headerTextView.setFont(new Font(Constants.COMICFONTBOLD, 70.0));

        winMediaView.setFitHeight(400.0);
        winMediaView.setFitWidth(500.0);
        winMediaView.setLayoutX(410.0);
        winMediaView.setLayoutY(170.0);

        Media media = new Media(getClass().getResource(video).toExternalForm());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        winMediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setAutoPlay(true);
        backButton.setLayoutX(676.0);
        backButton.setLayoutY(616.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(104.0);
        backButton.setPrefWidth(311.0);
        backButton.setStyle(CustomStyles.DROPDOWNSHADOW);
        backButton.setText(Constants.BACK);
        backButton.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.OFFWHITE));
        backButton.setFont(new Font(Constants.COMICFONT, 50.0));

        PlayAgainButton.setLayoutX(291.0);
        PlayAgainButton.setLayoutY(616.0);
        PlayAgainButton.setMnemonicParsing(false);
        PlayAgainButton.setPrefHeight(104.0);
        PlayAgainButton.setPrefWidth(311.0);
        PlayAgainButton.setStyle(CustomStyles.DROPDOWNSHADOW);
        PlayAgainButton.setText(Constants.PLAYAGAIN);
        PlayAgainButton.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.OFFWHITE));
        PlayAgainButton.setFont(new Font(Constants.COMICFONT, 50.0));
        backButton.setOnMousePressed(e -> {
            if (level == Level.LOCAL) {
                Parent pane = new DualModeBase(stage);
                stage.getScene().setRoot(pane);
            } else if (level == Level.Easy || level == Level.MEDIUM || level == Level.HARD) {
                Parent pane = new LevelsBase(stage);
                stage.getScene().setRoot(pane);
            } else if (level == Level.ONLINE) {
                if (playerTurn == Constants.X) {
                    Parent pane = new OnlineListBase(stage, firstPlayer);
                    stage.getScene().setRoot(pane);
                } else {
                    Parent pane = new OnlineListBase(stage, secondPlayer);
                    stage.getScene().setRoot(pane);
                }
            }
            mediaPlayer.stop();

        });

        PlayAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent pane = new GameBase(stage, level, firstPlayer, secondPlayer, ' ');
                stage.getScene().setRoot(pane);
                mediaPlayer.stop();
            }
        });
        if (level != Level.ONLINE) {
            PlayAgainButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Parent pane = new GameBase(stage, level, firstPlayer, secondPlayer, ' ');
                    stage.getScene().setRoot(pane);
                    mediaPlayer.stop();
                }
            });
        } else {
            backButton.setLayoutX(567.0);
            backButton.setLayoutY(612.0);
            PlayAgainButton.setVisible(false);
        }

        getChildren().add(headerTextView);
        getChildren().add(winMediaView);
        getChildren().add(backButton);
        getChildren().add(PlayAgainButton);

    }
}
