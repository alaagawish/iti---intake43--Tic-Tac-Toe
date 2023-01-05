package tictactoe.screens.dualmode;

import javafx.geometry.Insets;

import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tictactoe.models.Player;
import tictactoe.screens.game.GameBase;
import tictactoe.screens.game.LocalGame;

public class LocalBase extends BorderPane {

    protected final VBox vBox;
    protected final FlowPane topFlowPane;
    protected final ImageView logoImageView;
    protected final FlowPane TicTacToeFlowPane;
    protected final Text ticLogoText;
    protected final Text tacLogoText;
    protected final Text toeLogoText;
    protected final FlowPane centerFlowPane;
    protected final FlowPane ticTextFlowPane;
    protected final FlowPane fieldsFlowPane;
    protected final AnchorPane anchorPane;
    protected final TextField userNameTextField;
    protected final ImageView personImage;
    protected final PasswordField passwordField;
    protected final ImageView imageView;
    protected final Button startButton;
    protected final HBox hBox;
    protected final ImageView backImageView;
    protected final HBox headerHBox;
    protected final TextField firstPlayerTextField;
    protected final TextField secondPlayerTextField;
    protected final ImageView personImage1;
    protected final FlowPane localTextFlowPane;
    protected final Text LocalText;
    protected JFrame jFrame;
    Player playerOne, playerTwo;

    public LocalBase(Stage stage) {

        vBox = new VBox();
        headerHBox = new HBox();
        topFlowPane = new FlowPane();
        logoImageView = new ImageView();
        centerFlowPane = new FlowPane();
        ticTextFlowPane = new FlowPane();
        backImageView = new ImageView();
        fieldsFlowPane = new FlowPane();
        anchorPane = new AnchorPane();
        userNameTextField = new TextField();
        personImage = new ImageView();
        passwordField = new PasswordField();
        imageView = new ImageView();
        startButton = new Button();
        hBox = new HBox();

        playerOne = new Player();
        playerTwo = new Player();
        localTextFlowPane = new FlowPane();
        LocalText = new Text();
        firstPlayerTextField = new TextField();
        secondPlayerTextField = new TextField();
        personImage1 = new ImageView();

        TicTacToeFlowPane = new FlowPane();
        ticLogoText = new Text();
        tacLogoText = new Text();
        toeLogoText = new Text();
        jFrame = new JFrame();
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

        backImageView.setFitHeight(106.0);
        backImageView.setFitWidth(120.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
        backImageView.setImage(new Image(getClass().getResource("/assets/images/back.png").toExternalForm()));
        HBox.setMargin(backImageView, new Insets(15.0, 1000.0, 0.0, 30.0));

        setTop(topFlowPane);

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

        userNameTextField.setLayoutX(164.0);
        userNameTextField.setLayoutY(50.0);
        userNameTextField.setPrefHeight(68.0);
        userNameTextField.setPrefWidth(425.0);
        userNameTextField.setPromptText("Player 1");
        userNameTextField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        userNameTextField.setFont(new Font("Comic Sans MS Bold", 25.0));
        userNameTextField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        BorderPane.setAlignment(headerHBox, javafx.geometry.Pos.CENTER);
        headerHBox.setPrefHeight(100.0);
        headerHBox.setPrefWidth(200.0);

        passwordField.setLayoutX(164.0);
        passwordField.setLayoutY(154.0);
        passwordField.setPrefHeight(68.0);
        passwordField.setPrefWidth(426.0);
        passwordField.setPromptText("Player 2");
        passwordField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        passwordField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));
        passwordField.setFont(new Font("Comic Sans MS Bold", 25.0));

        FlowPane.setMargin(fieldsFlowPane, new Insets(0.0, 0.0, 0.0, 300.0));
        setTop(headerHBox);

        FlowPane.setMargin(startButton, new Insets(30.0, 0.0, 0.0, 580.0));

        hBox.setPrefHeight(70.0);
        hBox.setPrefWidth(200.0);

        hBox.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 25.0));
        FlowPane.setMargin(hBox, new Insets(20.0, 0.0, 0.0, 400.0));
        hBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        setCenter(centerFlowPane);

        vBox.getChildren().add(logoImageView);
        TicTacToeFlowPane.getChildren().add(ticLogoText);
        TicTacToeFlowPane.getChildren().add(tacLogoText);
        TicTacToeFlowPane.getChildren().add(toeLogoText);
        vBox.getChildren().add(TicTacToeFlowPane);

        localTextFlowPane.getChildren().add(LocalText);
        centerFlowPane.getChildren().add(localTextFlowPane);
        anchorPane.getChildren().add(firstPlayerTextField);
        anchorPane.getChildren().add(personImage);
        anchorPane.getChildren().add(secondPlayerTextField);
        anchorPane.getChildren().add(personImage1);
        fieldsFlowPane.getChildren().add(anchorPane);
        centerFlowPane.getChildren().add(fieldsFlowPane);
        centerFlowPane.getChildren().add(startButton);

        anchorPane.getChildren().add(imageView);
        centerFlowPane.getChildren().add(hBox);

        headerHBox.getChildren().add(backImageView);
        headerHBox.getChildren().add(vBox);

        startButton.setOnAction(e -> {

            if (firstPlayerTextField.getText().length() > 0 && secondPlayerTextField.getText().length() > 0) {
                playerOne.setUsername(firstPlayerTextField.getText());
                playerTwo.setUsername(secondPlayerTextField.getText());
                Parent pane = new GameBase(stage, "local", playerOne, playerTwo);
                stage.getScene().setRoot(pane);
                System.out.println("done");
            } else {
                System.out.println("error");
                if (firstPlayerTextField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(jFrame, "Enter your name", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backImageView.setOnMousePressed(e -> {
            Parent pane = new DualModeBase(stage);
            stage.getScene().setRoot(pane);

        });

    }
}
