package tictactoe.screens.dualmode;

import javafx.geometry.Insets;

import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import tictactoe.screens.game.GameBase;


public class LocalBase extends BorderPane {

    protected final FlowPane centerFlowPane;
    protected final FlowPane localTextFlowPane;
    protected final Text LocalText;
    protected final FlowPane fieldsFlowPane;
    protected final AnchorPane anchorPane;
    protected final TextField firstPlayerTextField;
    protected final ImageView personImage;
    protected final TextField secondPlayerTextField;
    protected final ImageView personImage1;
    protected final Button startButton;
    protected final FlowPane topFlowPane;
    protected final ImageView logoImageView;
    protected final FlowPane topTextFlowPane;
    protected final Text ticTopText;
    protected final Text tacTopText;
    protected final Text toeTopText;

    public LocalBase(Stage stage) {


        centerFlowPane = new FlowPane();
        localTextFlowPane = new FlowPane();
        LocalText = new Text();
        fieldsFlowPane = new FlowPane();
        anchorPane = new AnchorPane();
        firstPlayerTextField = new TextField();
        personImage = new ImageView();
        secondPlayerTextField = new TextField();
        personImage1 = new ImageView();
        startButton = new Button();
        topFlowPane = new FlowPane();
        logoImageView = new ImageView();
        topTextFlowPane = new FlowPane();
        ticTopText = new Text();
        tacTopText = new Text();
        toeTopText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        BorderPane.setAlignment(centerFlowPane, javafx.geometry.Pos.CENTER);
        centerFlowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        centerFlowPane.setPrefHeight(200.0);
        centerFlowPane.setPrefWidth(200.0);

        localTextFlowPane.setLayoutX(766.0);
        localTextFlowPane.setPrefHeight(70.0);
        localTextFlowPane.setPrefWidth(485.0);

        LocalText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        LocalText.setLayoutX(766.0);
        LocalText.setLayoutY(50.0);
        LocalText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        LocalText.setStrokeWidth(0.0);
        LocalText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        LocalText.setText("Local");
        LocalText.setX(766.0);
        LocalText.setY(50.0);
        LocalText.setFont(new Font("Comic Sans MS Bold", 96.0));
        FlowPane.setMargin(LocalText, new Insets(0.0, 0.0, 0.0, 160.0));
        FlowPane.setMargin(localTextFlowPane, new Insets(50.0, 0.0, 0.0, 400.0));

        fieldsFlowPane.setHgap(100.0);
        fieldsFlowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        fieldsFlowPane.setPrefHeight(250.0);
        fieldsFlowPane.setPrefWidth(523.0);
        fieldsFlowPane.setVgap(25.0);

        anchorPane.setPrefHeight(250.0);
        anchorPane.setPrefWidth(698.0);

        firstPlayerTextField.setLayoutX(164.0);
        firstPlayerTextField.setLayoutY(50.0);
        firstPlayerTextField.setPrefHeight(68.0);
        firstPlayerTextField.setPrefWidth(425.0);
        firstPlayerTextField.setPromptText("Player 1");
        firstPlayerTextField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        firstPlayerTextField.setFont(new Font("Comic Sans MS Bold", 25.0));
        firstPlayerTextField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        personImage.setFitHeight(50.0);
        personImage.setFitWidth(50.0);
        personImage.setLayoutX(177.0);
        personImage.setLayoutY(59.0);
        personImage.setPickOnBounds(true);
        personImage.setPreserveRatio(true);
        personImage.setImage(new Image(getClass().getResource("/assets/images/username.png").toExternalForm()));

        secondPlayerTextField.setLayoutX(161.0);
        secondPlayerTextField.setLayoutY(155.0);
        secondPlayerTextField.setPrefHeight(68.0);
        secondPlayerTextField.setPrefWidth(425.0);
        secondPlayerTextField.setPromptText("Player 2");
        secondPlayerTextField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        secondPlayerTextField.setFont(new Font("Comic Sans MS Bold", 25.0));
        secondPlayerTextField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        personImage1.setFitHeight(50.0);
        personImage1.setFitWidth(50.0);
        personImage1.setLayoutX(174.0);
        personImage1.setLayoutY(164.0);
        personImage1.setPickOnBounds(true);
        personImage1.setPreserveRatio(true);
        personImage1.setImage(new Image(getClass().getResource("/assets/images/username.png").toExternalForm()));
        FlowPane.setMargin(fieldsFlowPane, new Insets(0.0, 0.0, 0.0, 300.0));

        startButton.setId("styles");
        startButton.setMnemonicParsing(false);
        startButton.setPrefHeight(70.0);
        startButton.setPrefWidth(200.0);
        startButton.setStyle("-fx-background-color: rgba(252,207,40,0.7); -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        startButton.setText("Start");
        startButton.setTextFill(javafx.scene.paint.Color.WHITE);
        startButton.setWrapText(true);
        FlowPane.setMargin(startButton, new Insets(30.0, 0.0, 0.0, 580.0));
        startButton.setPadding(new Insets(0.0, 10.0, 10.0, 10.0));
        startButton.setFont(new Font("Comic Sans MS Bold", 35.0));
        setCenter(centerFlowPane);

        BorderPane.setAlignment(topFlowPane, javafx.geometry.Pos.CENTER);
        topFlowPane.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        topFlowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        topFlowPane.setPrefHeight(94.0);
        topFlowPane.setPrefWidth(200.0);

        logoImageView.setFitHeight(65.0);
        logoImageView.setFitWidth(50.0);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        logoImageView.setImage(new Image(getClass().getResource("/assets/images/logo.png").toExternalForm()));
        FlowPane.setMargin(logoImageView, new Insets(10.0, 0.0, 0.0, 10.0));

        topTextFlowPane.setAlignment(javafx.geometry.Pos.CENTER);
        topTextFlowPane.setPrefHeight(20.0);
        topTextFlowPane.setPrefWidth(76.0);
        FlowPane.setMargin(topTextFlowPane, new Insets(3.0, 10.0, 0.0, 0.0));

        ticTopText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        ticTopText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticTopText.setStrokeWidth(0.0);
        ticTopText.setText("Tic");
        ticTopText.setFont(new Font("Comic Sans MS Bold", 14.0));
        FlowPane.setMargin(ticTopText, new Insets(0.0));

        tacTopText.setFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        tacTopText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacTopText.setStrokeWidth(0.0);
        tacTopText.setText("Tac");
        tacTopText.setFont(new Font("Comic Sans MS Bold", 14.0));

        toeTopText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeTopText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeTopText.setStrokeWidth(0.0);
        toeTopText.setText("Toe");
        toeTopText.setFont(new Font("Comic Sans MS Bold", 14.0));
        setTop(topFlowPane);

        localTextFlowPane.getChildren().add(LocalText);
        centerFlowPane.getChildren().add(localTextFlowPane);
        anchorPane.getChildren().add(firstPlayerTextField);
        anchorPane.getChildren().add(personImage);
        anchorPane.getChildren().add(secondPlayerTextField);
        anchorPane.getChildren().add(personImage1);
        fieldsFlowPane.getChildren().add(anchorPane);
        centerFlowPane.getChildren().add(fieldsFlowPane);
        centerFlowPane.getChildren().add(startButton);
        topFlowPane.getChildren().add(logoImageView);
        topTextFlowPane.getChildren().add(ticTopText);
        topTextFlowPane.getChildren().add(tacTopText);
        topTextFlowPane.getChildren().add(toeTopText);
        topFlowPane.getChildren().add(topTextFlowPane);

        
        
        startButton.setOnAction(e -> {
            Parent pane = new GameBase(stage);
            stage.getScene().setRoot(pane);
        });


    }
}
