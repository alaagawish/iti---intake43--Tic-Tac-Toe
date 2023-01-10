package tictactoe.screens.dualmode;

import com.jfoenix.controls.JFXDialog;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import tictactoe.models.Player;
import tictactoe.screens.profile.ProfileBase;
import tictactoe.utils.Dialogs;

public class OnlineListBase extends ScrollPane {

    protected final BorderPane listBorderPane;
    protected final BorderPane borderPane;
    protected final Circle profileCircle;
    protected final VBox listVBox;
    protected final Label savedGamesLabel;
    protected final List<HBox> gameHBox;
    protected final List<Label> playerName;
    protected final List<Button> inviteButton;
    protected final List<Line> gameLine;
    protected final DropShadow dropShadow;
    protected final ImageView backImageView;
    protected final DropShadow dropShadow1;
    String dialogMessage;

    public OnlineListBase(Stage stage, Player player) {

        dialogMessage = "";

        List<Player> players = DualModeBase.network.getOnlineList();

        if (players != null) {
            System.out.println("Players:" + players);
        }

        listBorderPane = new BorderPane();
        borderPane = new BorderPane();
        profileCircle = new Circle();
        listVBox = new VBox();
        savedGamesLabel = new Label();
        backImageView = new ImageView();
        gameHBox = new ArrayList<>();
        playerName = new ArrayList<>();
        inviteButton = new ArrayList<>();
        dropShadow = new DropShadow();
        gameLine = new ArrayList<>();

        dropShadow1 = new DropShadow();

        setId("listScrollPane");
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        listBorderPane.setId("listBorderPane");
        listBorderPane.setMaxHeight(USE_PREF_SIZE);
        listBorderPane.setMaxWidth(USE_PREF_SIZE);
        listBorderPane.setMinHeight(USE_PREF_SIZE);
        listBorderPane.setMinWidth(USE_PREF_SIZE);
        listBorderPane.setPrefHeight(800.0);
        listBorderPane.setPrefWidth(1280.0);
        listBorderPane.setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
        borderPane.setPrefHeight(234.0);
        borderPane.setPrefWidth(1280.0);

        profileCircle.setFill(javafx.scene.paint.Color.valueOf("#ffffff00"));
        profileCircle.setId("profileCircle");
        profileCircle.setRadius(60.0);
        profileCircle.setStroke(javafx.scene.paint.Color.BLACK);
        profileCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        BorderPane.setMargin(profileCircle, new Insets(30.0, 60.0, 0.0, 0.0));
        borderPane.setRight(profileCircle);
        listBorderPane.setTop(borderPane);

        Image profilePic = new Image("/assets/images/profilePicture.png", false);
        profileCircle.setFill(new ImagePattern(profilePic));

        listVBox.setId("listVBox");
        listVBox.setPrefHeight(598.0);
        listVBox.setPrefWidth(1280.0);
        listVBox.setStyle("-fx-background-color: rgba(255,255,255,0);");

        savedGamesLabel.setLayoutX(10.0);
        savedGamesLabel.setLayoutY(10.0);
        savedGamesLabel.setPrefHeight(56.0);
        savedGamesLabel.setPrefWidth(833.0);
        savedGamesLabel.setText("Invitation List");
        savedGamesLabel.setFont(new Font("Comic Sans MS Bold", 40.0));
        VBox.setMargin(savedGamesLabel, new Insets(0.0, 0.0, 0.0, 0.0));

        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(listBorderPane);
        BoxBlur blur = new BoxBlur(3, 3, 3);

        JFXDialog dialog = Dialogs.createBlurSimpleDialog("Waiting Player To Accept the invitation ...", stackpane, "-fx-background-color: rgba(59,178,184,0.8 ); -fx-background-radius: 10 10 10 10 ;");

        dialog.setOnDialogClosed((event) -> {
            listBorderPane.setEffect(null);
        });

        listVBox.getChildren().add(savedGamesLabel);

        for (int i = 0; i < players.size(); i++) {
            HBox hbox = new HBox();
            hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            hbox.setPrefHeight(100.0);
            hbox.setPrefWidth(200.0);
            gameHBox.add(hbox);

            Label label = new Label();

            label.setPrefHeight(56.0);
            label.setPrefWidth(880.0);
            label.setText(players.get(i).getUsername());
            label.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
            label.setFont(new Font("Comic Sans MS Bold", 30.0));
            playerName.add(label);

            Button btn = new Button();
            btn.setId("inviteButton");
            btn.setMnemonicParsing(false);
            btn.setPrefHeight(29.0);
            btn.setPrefWidth(138.0);
            btn.setStyle("-fx-background-color: rgba(156, 216, 100,1); -fx-background-radius: 10;");
            btn.setText("Invite");

            btn.setTextFill(javafx.scene.paint.Color.WHITE);
            btn.setFont(new Font("Comic Sans MS Bold", 24.0));

            btn.setOnAction((ActionEvent event) -> {
                dialog.show();
                listBorderPane.setEffect(blur);

            });

            btn.setEffect(dropShadow);

            VBox.setMargin(hbox, new Insets(10.0, 0.0, 10.0, 60.0));
            Line line = new Line();

            line.setEndX(1027.2928466796875);
            line.setEndY(71.29289245605469);
            line.setStartX(2154.585693359375);
            line.setStartY(70.58578491210938);
            line.setStroke(javafx.scene.paint.Color.valueOf("#a4a4a4"));
            line.setStrokeWidth(2.0);
            gameLine.add(line);

            hbox.getChildren().add(label);
            hbox.getChildren().add(btn);
            listVBox.getChildren().add(hbox);
            listVBox.getChildren().add(line);
        }

        backImageView.setFitHeight(90.0);
        backImageView.setFitWidth(110.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        BorderPane.setMargin(backImageView, new Insets(30.0, 0.0, 0.0, 30.0));
        borderPane.setLeft(backImageView);

        dropShadow.setColor(Color.rgb(140, 140, 140, 1));

        dropShadow.setHeight(1.0);
        dropShadow.setOffsetX(-3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setRadius(0.0);
        dropShadow.setWidth(0.0);

        BorderPane.setMargin(listVBox, new Insets(0.0, 0.0, 0.0, 60.0));
        listBorderPane.setCenter(listVBox);
        setContent(stackpane);

        backImageView.setOnMousePressed(e -> {
            DualModeBase.network.closeConnection();
            Parent pane = new DualModeBase(stage);
            stage.getScene().setRoot(pane);

        });

        profileCircle.setOnMouseClicked(e -> {
            Parent root = new ProfileBase(stage, player);
            stage.getScene().setRoot(root);
        });

    }

}
