package tictactoe.screens.modes;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.GameModel;
import tictactoe.repositories.PlayerRepository;
import tictactoe.screens.game.GameBase;

public class OfflineGameRecordsBase2 extends ScrollPane {

    protected final BorderPane borderPane;
    protected final VBox VboxId;
    protected final HBox titleHbox;
    protected final ImageView backImageView;
    protected final Text offlineRecoededText;
    private final String[] gameNames;
    protected final List<HBox> gameHBox;
    protected final List<Label> gameLabel;
    protected final List<ImageView> gameImage;
    protected final List<Line> gameLine;

    public OfflineGameRecordsBase2(Stage stage) {
        gameNames = PlayerRepository.getRecordedGames(Constants.RECORDEDGAMEPATH_LOCAL);
        borderPane = new BorderPane();
        VboxId = new VBox();

        titleHbox = new HBox();
        backImageView = new ImageView();
        offlineRecoededText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(1280.0);

        borderPane.setPrefHeight(795.0);
        borderPane.setPrefWidth(1275.0);

        gameHBox = new ArrayList<>();
        gameLabel = new ArrayList<>();
        gameImage = new ArrayList<>();
        gameLine = new ArrayList<>();

        BorderPane.setAlignment(VboxId, javafx.geometry.Pos.CENTER);
        VboxId.setPrefHeight(200.0);
        VboxId.setPrefWidth(100.0);

        VboxId.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        VboxId.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(VboxId, new Insets(25.0, 0.0, 0.0, 0.0));
        borderPane.setCenter(VboxId);

        BorderPane.setAlignment(titleHbox, javafx.geometry.Pos.CENTER);
        titleHbox.setPrefHeight(100.0);
        titleHbox.setPrefWidth(200.0);

        backImageView.setFitHeight(120.0);
        backImageView.setFitWidth(106.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        HBox.setMargin(backImageView, new Insets(0.0, 0.0, 0.0, 25.0));
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));

        offlineRecoededText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        offlineRecoededText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        offlineRecoededText.setStrokeWidth(0.0);
        offlineRecoededText.setText("Offline Game Records");
        offlineRecoededText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        offlineRecoededText.setFont(new Font("Comic Sans MS Bold", 50.0));
        HBox.setMargin(offlineRecoededText, new Insets(25.0, 0.0, 0.0, 230.0));
        titleHbox.setPadding(new Insets(25.0, 0.0, 0.0, 0.0));
        borderPane.setTop(titleHbox);
        setContent(borderPane);

//        HboxId1.getChildren().add(recordLabel1);
//        HboxId1.getChildren().add(imageView);
//        VboxId.getChildren().add(HboxId1);
//        VboxId.getChildren().add(firstLine);
        titleHbox.getChildren().add(backImageView);
        titleHbox.getChildren().add(offlineRecoededText);

        if (gameNames != null && gameNames.length > 0) {
            for (int i = 0; i < gameNames.length; i++) {
                HBox hbox = new HBox();

                hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
                hbox.setPrefHeight(100.0);
                hbox.setPrefWidth(200.0);
                gameHBox.add(hbox);

                Label glabel = new Label();

                glabel.setPrefHeight(56.0);
                glabel.setPrefWidth(880.0);
                glabel.setText(gameNames[i]);
                glabel.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
                glabel.setFont(new Font("Comic Sans MS Bold", 24.0));
                gameLabel.add(glabel);

                ImageView imageView = new ImageView();

                imageView.setFitHeight(86.0);
                imageView.setFitWidth(196.0);
                imageView.setId("gameImage");
                imageView.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
                imageView.setPickOnBounds(true);
                imageView.setPreserveRatio(true);
                imageView.setImage(new Image(getClass().getResource("/assets/images/play.png").toExternalForm()));

                gameImage.add(imageView);

                gameImage.get(i).setOnMouseClicked((MouseEvent e) -> {

                    GameModel recordedGame = PlayerRepository.readGame(Constants.RECORDEDGAMEPATH_LOCAL, gameNames[0]);
                    System.err.println("Game: " + recordedGame);
                    System.err.println("xPlayer: " + recordedGame.getxPlayer());
                    System.err.println("oPlayer: " + recordedGame.getoPlayer());
                    System.err.println("Move 0: " + recordedGame.getMovesList().get(0).getColumn());
                    GameBase pane = new GameBase(stage, Level.LOCALRECORD, recordedGame.getxPlayer(), recordedGame.getoPlayer(),' ');
                    stage.getScene().setRoot(pane);
                    pane.displayRecord(recordedGame);

                });

                VBox.setMargin(gameHBox.get(i), new Insets(10.0, 0.0, 10.0, 60.0));

                Line gLine = new Line();
                gLine.setEndX(1027.2928466796875);
                gLine.setEndY(71.29289245605469);
                gLine.setStartX(2154.585693359375);
                gLine.setStartY(70.58578491210938);
                VBox.setMargin(gLine, new Insets(0.0, 0.0, 0.0, 60.0));

                gameLine.add(gLine);

                gameHBox.get(i).getChildren().add(gameLabel.get(i));
                gameHBox.get(i).getChildren().add(gameImage.get(i));
                VboxId.getChildren().add(gameHBox.get(i));
                VboxId.getChildren().add(gameLine.get(i));

            }

            backImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Parent pane = new ModeBase(stage);
                    stage.getScene().setRoot(pane);
                }
            });
        }

    }
}
