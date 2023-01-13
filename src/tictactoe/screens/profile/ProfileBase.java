package tictactoe.screens.profile;

import com.jfoenix.controls.JFXDialog;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.constants.Level;
import tictactoe.models.GameModel;
import tictactoe.models.Player;
import tictactoe.repositories.PlayerRepository;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.screens.game.GameBase;
import tictactoe.utils.Dialogs;

public class ProfileBase extends ScrollPane {

    protected final BorderPane borderPane;
    protected final BorderPane borderPane0;
    protected final VBox vBox;
    protected final Circle profileCircle;
    protected final HBox hBox;
    protected final Label label;
    protected final Label scoreLabel;
    protected final VBox profileVBox;
    protected final HBox infoHBox;
    protected final Label infoLabel;
    protected final Button editInfoButton;
    protected final DropShadow dropShadow;
    protected final HBox usernameHBox;
    protected final Label label0;
    protected final TextField usernameTextField;
    protected final HBox passwordHBox;
    protected final Label passordLabel;
    protected final PasswordField passwordField;
    protected final Label savedGamesLabel;

    protected final List<HBox> gameHBox;
    protected final List<Label> gameLabel;
    protected final List<ImageView> gameImage;
    protected final List<Line> gameLine;

    protected final ImageView backImageView, backImageView2;
    protected boolean toggleFlag;
    public Stage stage;
    Player playerr;
    String[] gamesNames;
    Thread thread;
//    public GameBase panee;

    public ProfileBase(Stage stage, Player player) {
        this.stage = stage;
        playerr = player;
        gamesNames = PlayerRepository.getRecordedGames(player.getUsername());
//        System.err.println(gamesNames[0]);

//        thread = new Thread(this);
        borderPane = new BorderPane();
        borderPane0 = new BorderPane();
        vBox = new VBox();
        profileCircle = new Circle();
        hBox = new HBox();
        label = new Label();
        scoreLabel = new Label();
        profileVBox = new VBox();
        infoHBox = new HBox();
        infoLabel = new Label();
        editInfoButton = new Button();
        dropShadow = new DropShadow();
        usernameHBox = new HBox();
        label0 = new Label();
        usernameTextField = new TextField();
        passwordHBox = new HBox();
        passordLabel = new Label();
        passwordField = new PasswordField();
        savedGamesLabel = new Label();

        gameHBox = new ArrayList<>();
        gameLabel = new ArrayList<>();
        gameImage = new ArrayList<>();
        gameLine = new ArrayList<>();

        backImageView = new ImageView();
        backImageView2 = new ImageView();
        toggleFlag = false;

        setId("profileScrollPane");
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");
        getStyleClass().add("profileScrollPane");

        borderPane.setId("mainBorderPane");
        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setMinHeight(USE_PREF_SIZE);
        borderPane.setMinWidth(USE_PREF_SIZE);
        borderPane.setPrefHeight(800.0);
        borderPane.setPrefWidth(1280.0);
        borderPane.setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");
        borderPane.getStyleClass().add("mainBorderPane");

        BorderPane.setAlignment(borderPane0, javafx.geometry.Pos.CENTER);
        borderPane0.setPrefHeight(302.0);
        borderPane0.setPrefWidth(1280.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setMaxWidth(231.0);
        vBox.setMinWidth(135.0);
        vBox.setPrefHeight(256.0);
        vBox.setPrefWidth(231.0);
        BorderPane.setMargin(vBox, new Insets(0.0, 0.0, 30.0, 0.0));

        profileCircle.setFill(javafx.scene.paint.Color.valueOf("#ffffff00"));
        profileCircle.setId("profileCircle");
        profileCircle.setRadius(100.0);
        profileCircle.setStroke(javafx.scene.paint.Color.AQUA);
        profileCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        profileCircle.setStroke(Color.GRAY);
        Image profilePic = new Image("/assets/images/profilePicture.png", false);
        profileCircle.setFill(new ImagePattern(profilePic));

        hBox.setPrefHeight(56.0);
        hBox.setPrefWidth(175.0);

        label.setPrefHeight(56.0);
        label.setPrefWidth(147.0);
        label.setText("Score: ");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
        label.setFont(new Font("Comic Sans MS Bold", 40.0));

        scoreLabel.setId("scoreLabel");
        scoreLabel.setLayoutX(10.0);
        scoreLabel.setLayoutY(10.0);

        scoreLabel.setText(player.getScore() + "");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        scoreLabel.setFont(new Font("Comic Sans MS Bold", 40.0));
        borderPane0.setCenter(vBox);
        BorderPane.setMargin(vBox, new Insets(90.0, 0.0, 30.0, 0.0));
        borderPane.setTop(borderPane0);

        profileVBox.setPrefHeight(598.0);
        profileVBox.setPrefWidth(1280.0);
        profileVBox.setStyle("-fx-background-color: rgba(255,255,255,0);");

        infoHBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        infoLabel.setPrefHeight(56.0);
        infoLabel.setPrefWidth(864.0);
        infoLabel.setText("Main Information");
        infoLabel.setFont(new Font("Comic Sans MS Bold", 40.0));

        editInfoButton.setId("editInfoButton");
        editInfoButton.setMnemonicParsing(false);
        editInfoButton.setPrefHeight(29.0);
        editInfoButton.setPrefWidth(138.0);
        editInfoButton.setStyle("-fx-background-color: rgba(109, 207, 208,1); -fx-background-radius: 10;");
        editInfoButton.setText("Edit");
        editInfoButton.setTextFill(javafx.scene.paint.Color.WHITE);
        editInfoButton.setFont(new Font("Comic Sans MS Bold", 24.0));
        HBox.setMargin(editInfoButton, new Insets(0.0, 0.0, 0.0, 60.0));

        backImageView.setFitHeight(106.0);
        backImageView.setFitWidth(120.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        borderPane0.setMargin(backImageView, new Insets(30.0, 0.0, 0.0, 30.0));
        borderPane0.setLeft(backImageView);

        backImageView2.setFitHeight(106.0);
        backImageView2.setFitWidth(120.0);
        backImageView2.setPickOnBounds(true);
        backImageView2.setPreserveRatio(true);
        backImageView2.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        backImageView2.setVisible(false);
        borderPane0.setRight(backImageView2);

        backImageView.setFitHeight(106.0);
        backImageView.setFitWidth(120.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        borderPane0.setMargin(backImageView, new Insets(30.0, 0.0, 0.0, 30.0));
        borderPane0.setLeft(backImageView);

        backImageView2.setFitHeight(106.0);
        backImageView2.setFitWidth(120.0);
        backImageView2.setPickOnBounds(true);
        backImageView2.setPreserveRatio(true);
        backImageView2.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        backImageView2.setVisible(false);
        borderPane0.setRight(backImageView2);

        dropShadow.setColor(Color.rgb(140, 140, 140));
        dropShadow.setHeight(1.0);
        dropShadow.setOffsetX(-3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setRadius(0.0);
        dropShadow.setWidth(0.0);
        editInfoButton.setEffect(dropShadow);
        VBox.setMargin(infoHBox, new Insets(60.0, 0.0, 0.0, 0.0));

        usernameHBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        usernameHBox.setStyle("-fx-background-color: #ffffff00;");
        VBox.setMargin(usernameHBox, new Insets(10.0, 0.0, 0.0, 0.0));

        label0.setText("Username:");
        label0.setFont(new Font("Comic Sans MS", 24.0));
        HBox.setMargin(label0, new Insets(0.0, 0.0, 0.0, 60.0));

        usernameTextField.setDisable(true);
        usernameTextField.setId("usernameTextField");
        usernameTextField.setMaxHeight(65.0);
        usernameTextField.setMaxWidth(365.0);
        usernameTextField.setMinHeight(50.0);
        usernameTextField.setPrefHeight(65.0);
        usernameTextField.setPrefWidth(365.0);
        usernameTextField.setStyle("-fx-border-radius: 51;");
        usernameTextField.setText("Moaz Khaled");
        HBox.setMargin(usernameTextField, new Insets(0.0, 0.0, 0.0, 20.0));
        usernameTextField.setFont(new Font("Comic Sans MS", 24.0));

        passwordHBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        passwordHBox.setLayoutX(10.0);
        passwordHBox.setLayoutY(81.0);
        passwordHBox.setPrefHeight(65.0);
        passwordHBox.setPrefWidth(1220.0);
        passwordHBox.setStyle("-fx-background-color: #ffffff00;");

        passordLabel.setText("Password:");
        passordLabel.setFont(new Font("Comic Sans MS", 24.0));

        passwordField.setDisable(true);
        passwordField.setId("passwordField");
        passwordField.setMaxHeight(65.0);
        passwordField.setMaxWidth(365.0);
        passwordField.setMinHeight(50.0);
        passwordField.setPrefHeight(65.0);
        passwordField.setPrefWidth(391.0);
        HBox.setMargin(passwordField, new Insets(0.0, 0.0, 0.0, 28.0));
        VBox.setMargin(passwordHBox, new Insets(10.0, 0.0, 0.0, 60.0));

        savedGamesLabel.setLayoutX(10.0);
        savedGamesLabel.setLayoutY(10.0);
        savedGamesLabel.setPrefHeight(56.0);
        savedGamesLabel.setPrefWidth(833.0);
        savedGamesLabel.setText("Saved Games");
        savedGamesLabel.setFont(new Font("Comic Sans MS Bold", 40.0));
        VBox.setMargin(savedGamesLabel, new Insets(30.0, 0.0, 0.0, 0.0));

        BorderPane.setMargin(profileVBox, new Insets(0.0, 0.0, 0.0, 60.0));
        borderPane.setCenter(profileVBox);
        setContent(borderPane);

        vBox.getChildren().add(profileCircle);
        hBox.getChildren().add(label);
        hBox.getChildren().add(scoreLabel);
        vBox.getChildren().add(hBox);
        infoHBox.getChildren().add(infoLabel);
        infoHBox.getChildren().add(editInfoButton);
        profileVBox.getChildren().add(infoHBox);
        usernameHBox.getChildren().add(label0);
        usernameHBox.getChildren().add(usernameTextField);
        profileVBox.getChildren().add(usernameHBox);
        passwordHBox.getChildren().add(passordLabel);
        passwordHBox.getChildren().add(passwordField);
        profileVBox.getChildren().add(passwordHBox);
//        profileVBox.getChildren().add(savedGamesLabel);
        if (gamesNames != null && gamesNames.length > 0) {
            profileVBox.getChildren().add(savedGamesLabel);
            for (int i = 0; i < gamesNames.length; i++) {
                HBox hbox = new HBox();

                hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
                hbox.setPrefHeight(100.0);
                hbox.setPrefWidth(200.0);
                gameHBox.add(hbox);

                Label glabel = new Label();

                glabel.setPrefHeight(56.0);
                glabel.setPrefWidth(880.0);
                glabel.setText(gamesNames[i]);
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

                    GameModel recordedGame = PlayerRepository.readGame(playerr.getUsername(), gamesNames[0]);
                    System.err.println("Game: " + recordedGame);
                    System.err.println("xPlayer: " + recordedGame.getxPlayer());
                    System.err.println("oPlayer: " + recordedGame.getoPlayer());
                    System.err.println("Move 0: " + recordedGame.getMovesList().get(0).getColumn());
                    GameBase pane = new GameBase(stage, Level.HARD, recordedGame.getxPlayer(), recordedGame.getoPlayer());
                    stage.getScene().setRoot(pane);
                    pane.displayRecord(recordedGame);

                });

                VBox.setMargin(gameHBox.get(i), new Insets(10.0, 0.0, 10.0, 60.0));

                Line gLine = new Line();
                gLine.setEndX(1027.2928466796875);
                gLine.setEndY(71.29289245605469);
                gLine.setStartX(2154.585693359375);
                gLine.setStartY(70.58578491210938);

                gameLine.add(gLine);

                gameHBox.get(i).getChildren().add(gameLabel.get(i));
                gameHBox.get(i).getChildren().add(gameImage.get(i));
                profileVBox.getChildren().add(gameHBox.get(i));
                profileVBox.getChildren().add(gameLine.get(i));

            }
        }

        usernameTextField.setText(player.getUsername());
        passwordField.setText(player.getPassword());

        backImageView.setOnMousePressed(e -> {
            Parent pane = new OnlineListBase(stage, player);
            stage.getScene().setRoot(pane);

        });

        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(borderPane);
        BoxBlur blur = new BoxBlur(3, 3, 3);
        JFXDialog dialog = Dialogs.createBlurSimpleDialog("Password length must be more than 8", stackpane, "-fx-background-color: rgba(255,255,255,1); -fx-background-radius: 10 10 10 10 ;");

        dialog.setOnDialogClosed((event) -> {
            borderPane.setEffect(null);
        });
        setContent(stackpane);

        editInfoButton.setOnAction(e -> {

            if (!toggleFlag) {
                toggleFlag = !toggleFlag;
                passwordField.setEditable(true);
                passwordField.setDisable(false);
                editInfoButton.setText("Save");

            } else {
                String newPassword = passwordField.getText();
                if (newPassword.length() >= 8) {
                    passwordField.setEditable(false);
                    passwordField.setDisable(true);
                    editInfoButton.setText("Edit");
                    toggleFlag = !toggleFlag;
                    Player playerEdited = DualModeBase.network.editPassword(player.getUsername(), newPassword);

                } else {
                    dialog.show();
                    borderPane.setEffect(blur);
                }
            }

        });

    }

}