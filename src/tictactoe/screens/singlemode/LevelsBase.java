package tictactoe.screens.singlemode;

import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.constants.Level;
import tictactoe.models.Player;
import tictactoe.screens.game.GameBase;
import tictactoe.screens.modes.ModeBase;

public class LevelsBase extends BorderPane {

    protected final VBox vBox;
    protected final ImageView logoImageView;
    protected final FlowPane TicTacToeFlowPane;
    protected final Text ticLogoText;
    protected final Text tacLogoText;
    protected final Text toeLogoText;
    protected final FlowPane flowPane0;
    protected final FlowPane flowPane1;
    protected final Text ticText;
    protected final Text tacText;
    protected final Text toeText;
    protected final FlowPane buttonsFlowPane;
    protected final Button easyButton;
    protected final AnchorPane easyAnchorPane;
    protected final ImageView firstStarEasyImageView;
    protected final ImageView secondStarEasyImageView;
    protected final ImageView thirdStarEasyImageView;
    protected final Text easyText;
    protected final Button mediumButton;
    protected final AnchorPane mediumAnchorPane;
    protected final ImageView firstStarMediumImageView;
    protected final ImageView secondStarMediumImageView;
    protected final ImageView thirdStarMediumImageView;
    protected final Text mediumText;
    protected final Button hardButton;
    protected final AnchorPane hardAnchorPane;
    protected final ImageView firstStarHardImageView;
    protected final ImageView secondStarHardImageView;
    protected final ImageView thirdStarHardImageView;
    protected final ImageView backImageView;
    protected final Text hardText;
    protected final HBox headerHBox;
    Player playerOne, computer;

    public LevelsBase(Stage stage) {

        vBox = new VBox();
        logoImageView = new ImageView();
        TicTacToeFlowPane = new FlowPane();
        ticLogoText = new Text();
        tacLogoText = new Text();
        toeLogoText = new Text();
        flowPane0 = new FlowPane();
        flowPane1 = new FlowPane();
        ticText = new Text();
        headerHBox = new HBox();
        backImageView = new ImageView();
        tacText = new Text();
        toeText = new Text();
        buttonsFlowPane = new FlowPane();
        easyButton = new Button();
        easyAnchorPane = new AnchorPane();
        firstStarEasyImageView = new ImageView();
        secondStarEasyImageView = new ImageView();
        thirdStarEasyImageView = new ImageView();
        easyText = new Text();
        mediumButton = new Button();
        mediumAnchorPane = new AnchorPane();
        firstStarMediumImageView = new ImageView();
        secondStarMediumImageView = new ImageView();
        thirdStarMediumImageView = new ImageView();
        mediumText = new Text();
        hardButton = new Button();
        hardAnchorPane = new AnchorPane();
        firstStarHardImageView = new ImageView();
        secondStarHardImageView = new ImageView();
        thirdStarHardImageView = new ImageView();
        hardText = new Text();
        playerOne = new Player();
        computer = new Player();

        setMaxWidth(1280.0);
        setMinHeight(800.0);
        setMinWidth(1280.0);
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        vBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        vBox.setPrefHeight(150.0);
        vBox.setPrefWidth(140.0);
        logoImageView.setFitHeight(68.0);
        logoImageView.setFitWidth(65.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image(getClass().getResource("/assets/images/logo.png").toExternalForm()));
        VBox.setMargin(logoImageView, new Insets(10.0, 20.0, 0.0, 0.0));

        TicTacToeFlowPane.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        TicTacToeFlowPane.setPrefHeight(20.0);
        TicTacToeFlowPane.setPrefWidth(72.0);

        ticLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        ticLogoText.setText("Tic");
        ticLogoText.setFont(new Font("Comic Sans MS Bold", 20.0));

        tacLogoText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacLogoText.setText("Tac");
        tacLogoText.setFont(new Font("Comic Sans MS Bold", 20.0));

        toeLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeLogoText.setText("Toe");
        toeLogoText.setFont(new Font("Comic Sans MS Bold", 20.0));
        FlowPane.setMargin(toeLogoText, new Insets(0.0));
        VBox.setMargin(TicTacToeFlowPane, new Insets(0.0));
        setTop(vBox);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);
        flowPane0.setStyle("-fx-border-radius: 42;");

        flowPane1.setPrefHeight(137.0);
        flowPane1.setPrefWidth(500.0);

        ticText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        ticText.setText("Tic");
        ticText.setFont(new Font("Comic Sans MS Bold", 96.0));

        tacText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacText.setLayoutX(10.0);
        tacText.setLayoutY(116.0);
        tacText.setText("Tac");
        tacText.setWrappingWidth(169.453125);
        tacText.setFont(new Font("Comic Sans MS Bold", 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeText.setLayoutX(10.0);
        toeText.setLayoutY(251.0);
        toeText.setText("Toe");
        toeText.setWrappingWidth(177.953125);
        toeText.setFont(new Font("Comic Sans MS Bold", 96.0));
        FlowPane.setMargin(flowPane1, new Insets(40.0, 390.0, 0.0, 390.0));

        buttonsFlowPane.setMinWidth(1280.0);
        buttonsFlowPane.setPrefHeight(300.0);
        buttonsFlowPane.setPrefWidth(1280.0);

        easyButton.setMinHeight(300.0);
        easyButton.setMinWidth(300.0);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(300.0);
        easyButton.setPrefWidth(41.0);
        easyButton.setStyle("-fx-background-color: #ffffff00; -fx-background-radius: 69px;");
        easyButton.setTextFill(javafx.scene.paint.Color.valueOf("#ffffff00"));
        FlowPane.setMargin(easyButton, new Insets(0.0, 0.0, 0.0, 95.0));

        easyAnchorPane.setPrefHeight(292.0);
        easyAnchorPane.setPrefWidth(293.0);
        easyAnchorPane.setStyle("-fx-background-color: rgba(130,213,49,0.7); -fx-background-radius: 69;");

        BorderPane.setAlignment(headerHBox, javafx.geometry.Pos.CENTER);
        headerHBox.setPrefHeight(100.0);
        headerHBox.setPrefWidth(200.0);

        firstStarEasyImageView.setFitHeight(58.0);
        firstStarEasyImageView.setFitWidth(48.0);
        firstStarEasyImageView.setLayoutX(40.0);
        firstStarEasyImageView.setLayoutY(116.0);
        firstStarEasyImageView.setPickOnBounds(true);
        firstStarEasyImageView.setPreserveRatio(true);
        firstStarEasyImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        secondStarEasyImageView.setFitHeight(58.0);
        secondStarEasyImageView.setFitWidth(48.0);
        secondStarEasyImageView.setLayoutX(115.0);
        secondStarEasyImageView.setLayoutY(57.0);
        secondStarEasyImageView.setPickOnBounds(true);
        secondStarEasyImageView.setPreserveRatio(true);
        secondStarEasyImageView.setImage(new Image(getClass().getResource("/assets/images/emptyStar.png").toExternalForm()));

        thirdStarEasyImageView.setFitHeight(58.0);
        thirdStarEasyImageView.setFitWidth(48.0);
        thirdStarEasyImageView.setLayoutX(190.0);
        thirdStarEasyImageView.setLayoutY(116.0);
        thirdStarEasyImageView.setPickOnBounds(true);
        thirdStarEasyImageView.setPreserveRatio(true);
        thirdStarEasyImageView.setImage(new Image(getClass().getResource("/assets/images/emptyStar.png").toExternalForm()));

        easyText.setFill(javafx.scene.paint.Color.WHITE);
        easyText.setLayoutX(71.0);
        easyText.setLayoutY(245.0);
        easyText.setText("Easy");
        easyText.setFont(new Font("Comic Sans MS Bold", 56.0));
        easyButton.setGraphic(easyAnchorPane);

        mediumButton.setMinHeight(300.0);
        mediumButton.setMinWidth(300.0);
        mediumButton.setMnemonicParsing(false);
        mediumButton.setStyle("-fx-background-radius: 50; -fx-background-color: #ffffff00;");
        FlowPane.setMargin(mediumButton, new Insets(0.0, 0.0, 0.0, 95.0));

        mediumAnchorPane.setPrefHeight(200.0);
        mediumAnchorPane.setPrefWidth(200.0);
        mediumAnchorPane.setStyle("-fx-background-radius: 69; -fx-background-color: rgba(252, 207, 40,0.7);");

        firstStarMediumImageView.setFitHeight(58.0);
        firstStarMediumImageView.setFitWidth(48.0);
        firstStarMediumImageView.setLayoutX(40.0);
        firstStarMediumImageView.setLayoutY(116.0);
        firstStarMediumImageView.setPickOnBounds(true);
        firstStarMediumImageView.setPreserveRatio(true);
        firstStarMediumImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        secondStarMediumImageView.setFitHeight(58.0);
        secondStarMediumImageView.setFitWidth(48.0);
        secondStarMediumImageView.setLayoutX(115.0);
        secondStarMediumImageView.setLayoutY(57.0);
        secondStarMediumImageView.setPickOnBounds(true);
        secondStarMediumImageView.setPreserveRatio(true);
        secondStarMediumImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        thirdStarMediumImageView.setFitHeight(58.0);
        thirdStarMediumImageView.setFitWidth(48.0);
        thirdStarMediumImageView.setLayoutX(190.0);
        thirdStarMediumImageView.setLayoutY(116.0);
        thirdStarMediumImageView.setPickOnBounds(true);
        thirdStarMediumImageView.setPreserveRatio(true);
        thirdStarMediumImageView.setImage(new Image(getClass().getResource("/assets/images/emptyStar.png").toExternalForm()));

        mediumText.setFill(javafx.scene.paint.Color.WHITE);
        mediumText.setLayoutX(39.0);
        mediumText.setLayoutY(245.0);
        mediumText.setText("Medium");
        mediumText.setFont(new Font("Comic Sans MS Bold", 56.0));
        mediumButton.setGraphic(mediumAnchorPane);

        hardButton.setLayoutX(75.0);
        hardButton.setLayoutY(10.0);
        hardButton.setMaxHeight(300.0);
        hardButton.setMinHeight(300.0);
        hardButton.setMinWidth(300.0);
        hardButton.setMnemonicParsing(false);
        hardButton.setStyle("-fx-background-radius: 69; -fx-background-color: #ffffff00;");
        FlowPane.setMargin(hardButton, new Insets(0.0, 95.0, 0.0, 95.0));
        setTop(headerHBox);

        hardAnchorPane.setPrefHeight(200.0);
        hardAnchorPane.setPrefWidth(200.0);
        hardAnchorPane.setStyle("-fx-background-radius: 69; -fx-background-color: rgba(235, 59, 62,1);");

        firstStarHardImageView.setFitHeight(58.0);
        firstStarHardImageView.setFitWidth(48.0);
        firstStarHardImageView.setLayoutX(190.0);
        firstStarHardImageView.setLayoutY(116.0);
        firstStarHardImageView.setPickOnBounds(true);
        firstStarHardImageView.setPreserveRatio(true);
        firstStarHardImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        backImageView.setFitHeight(106.0);
        backImageView.setFitWidth(120.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        HBox.setMargin(backImageView, new Insets(15.0, 1000.0, 0.0, 30.0));

        secondStarHardImageView.setFitHeight(58.0);
        secondStarHardImageView.setFitWidth(48.0);
        secondStarHardImageView.setLayoutX(115.0);
        secondStarHardImageView.setLayoutY(57.0);
        secondStarHardImageView.setPickOnBounds(true);
        secondStarHardImageView.setPreserveRatio(true);
        secondStarHardImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        thirdStarHardImageView.setFitHeight(58.0);
        thirdStarHardImageView.setFitWidth(48.0);
        thirdStarHardImageView.setLayoutX(40.0);
        thirdStarHardImageView.setLayoutY(116.0);
        thirdStarHardImageView.setPickOnBounds(true);
        thirdStarHardImageView.setPreserveRatio(true);
        thirdStarHardImageView.setImage(new Image(getClass().getResource("/assets/images/fullStar.png").toExternalForm()));

        hardText.setFill(javafx.scene.paint.Color.WHITE);
        hardText.setLayoutX(71.0);
        hardText.setLayoutY(245.0);
        hardText.setText("Hard");
        hardText.setFont(new Font("Comic Sans MS Bold", 56.0));
        hardButton.setGraphic(hardAnchorPane);
        FlowPane.setMargin(buttonsFlowPane, new Insets(110.0, 0.0, 0.0, 0.0));
        setCenter(flowPane0);

        vBox.getChildren().add(logoImageView);
        TicTacToeFlowPane.getChildren().add(ticLogoText);
        TicTacToeFlowPane.getChildren().add(tacLogoText);
        TicTacToeFlowPane.getChildren().add(toeLogoText);
        vBox.getChildren().add(TicTacToeFlowPane);
        flowPane1.getChildren().add(ticText);
        flowPane1.getChildren().add(tacText);
        flowPane1.getChildren().add(toeText);
        flowPane0.getChildren().add(flowPane1);
        easyAnchorPane.getChildren().add(firstStarEasyImageView);
        easyAnchorPane.getChildren().add(secondStarEasyImageView);
        easyAnchorPane.getChildren().add(thirdStarEasyImageView);
        easyAnchorPane.getChildren().add(easyText);
        buttonsFlowPane.getChildren().add(easyButton);
        mediumAnchorPane.getChildren().add(firstStarMediumImageView);
        mediumAnchorPane.getChildren().add(secondStarMediumImageView);
        mediumAnchorPane.getChildren().add(thirdStarMediumImageView);
        mediumAnchorPane.getChildren().add(mediumText);
        buttonsFlowPane.getChildren().add(mediumButton);
        hardAnchorPane.getChildren().add(firstStarHardImageView);
        hardAnchorPane.getChildren().add(secondStarHardImageView);
        hardAnchorPane.getChildren().add(thirdStarHardImageView);
        hardAnchorPane.getChildren().add(hardText);
        buttonsFlowPane.getChildren().add(hardButton);
        flowPane0.getChildren().add(buttonsFlowPane);
        headerHBox.getChildren().add(backImageView);
        headerHBox.getChildren().add(vBox);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(-10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setColor(Color.color(0, 0, 0, .16));
        ticText.setEffect(dropShadow);
        tacText.setEffect(dropShadow);
        toeText.setEffect(dropShadow);
        easyButton.setEffect(dropShadow);
        mediumButton.setEffect(dropShadow);
        hardButton.setEffect(dropShadow);
        playerOne.setUsername("Player");
        computer.setUsername("Root");
        easyButton.setOnAction(e -> {
            Parent pane = new GameBase(stage, Level.Easy, playerOne, computer);
            stage.getScene().setRoot(pane);
        });

        mediumButton.setOnAction(e -> {
            Parent pane = new GameBase(stage, Level.MEDIUM, playerOne, computer);
            stage.getScene().setRoot(pane);
        });

        hardButton.setOnAction(e -> {
            Parent pane = new GameBase(stage, Level.HARD, playerOne, computer);
            stage.getScene().setRoot(pane);
        });

        backImageView.setOnMousePressed(e -> {
            Parent pane = new ModeBase(stage);
            stage.getScene().setRoot(pane);
            
        });
    }
}
