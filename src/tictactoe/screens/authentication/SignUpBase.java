package tictactoe.screens.authentication;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.screens.dualmode.OnlineListBase;

public class SignUpBase extends BorderPane {

    protected final FlowPane centerFlowPane;
    protected final FlowPane ticTextFlowPane;
    protected final Text ticText;
    protected final Text tacText;
    protected final Text toeText;
    protected final FlowPane fieldsFlowPane;
    protected final AnchorPane anchorPane;
    protected final TextField userNameTextField;
    protected final ImageView personImage;
    protected final PasswordField passwordField;
    protected final ImageView imageView;
    protected final Button SignUpButton;
    protected final HBox hBox;
    protected final Text haveAccountText;
    protected final Text LoginText;
    protected final FlowPane topFlowPane;
    protected final ImageView logoImageView;
    protected final FlowPane topTextFlowPane;
    protected final Text ticTopText;
    protected final Text tacTopText;
    protected final Text toeTopText;

    public SignUpBase(Stage stage) {

        centerFlowPane = new FlowPane();
        ticTextFlowPane = new FlowPane();
        ticText = new Text();
        tacText = new Text();
        toeText = new Text();
        fieldsFlowPane = new FlowPane();
        anchorPane = new AnchorPane();
        userNameTextField = new TextField();
        personImage = new ImageView();
        passwordField = new PasswordField();
        imageView = new ImageView();
        SignUpButton = new Button();
        hBox = new HBox();
        haveAccountText = new Text();
        LoginText = new Text();
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

        ticTextFlowPane.setLayoutX(766.0);
        ticTextFlowPane.setPrefHeight(70.0);
        ticTextFlowPane.setPrefWidth(485.0);

        ticText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        ticText.setLayoutX(766.0);
        ticText.setLayoutY(50.0);
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        ticText.setText("Tic");
        ticText.setX(766.0);
        ticText.setY(50.0);
        ticText.setFont(new Font("Comic Sans MS Bold", 96.0));

        tacText.setFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);
        tacText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        tacText.setText("Tac");
        tacText.setFont(new Font("Comic Sans MS Bold", 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);
        toeText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        toeText.setText("Toe");
        toeText.setFont(new Font("Comic Sans MS Bold", 96.0));
        FlowPane.setMargin(ticTextFlowPane, new Insets(50.0, 0.0, 0.0, 400.0));

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
        userNameTextField.setPromptText("Enter Username");
        userNameTextField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        userNameTextField.setFont(new Font("Comic Sans MS Bold", 25.0));
        userNameTextField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        personImage.setFitHeight(50.0);
        personImage.setFitWidth(50.0);
        personImage.setLayoutX(177.0);
        personImage.setLayoutY(59.0);
        personImage.setPickOnBounds(true);
        personImage.setPreserveRatio(true);
        personImage.setImage(new Image(getClass().getResource("/assets/images/username.png").toExternalForm()));

        passwordField.setLayoutX(164.0);
        passwordField.setLayoutY(154.0);
        passwordField.setPrefHeight(68.0);
        passwordField.setPrefWidth(426.0);
        passwordField.setPromptText("Enter Password");
        passwordField.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.3 , -5, 5 );");
        passwordField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));
        passwordField.setFont(new Font("Comic Sans MS Bold", 25.0));

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setLayoutX(177.0);
        imageView.setLayoutY(163.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/images/password.png").toExternalForm()));
        FlowPane.setMargin(fieldsFlowPane, new Insets(0.0, 0.0, 0.0, 300.0));

        SignUpButton.setId("styles");
        SignUpButton.setMnemonicParsing(false);
        SignUpButton.setPrefHeight(70.0);
        SignUpButton.setPrefWidth(200.0);
        SignUpButton.setStyle("-fx-background-color: rgba(252,207,40,0.7); -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        SignUpButton.setText("SignUp");
        SignUpButton.setTextFill(javafx.scene.paint.Color.WHITE);
        SignUpButton.setWrapText(true);
        FlowPane.setMargin(SignUpButton, new Insets(30.0, 0.0, 0.0, 580.0));
        SignUpButton.setPadding(new Insets(0.0, 10.0, 10.0, 10.0));
        SignUpButton.setFont(new Font("Comic Sans MS Bold", 35.0));

        hBox.setPrefHeight(70.0);
        hBox.setPrefWidth(200.0);

        haveAccountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        haveAccountText.setStrokeWidth(0.0);
        haveAccountText.setText("Have an account?");
        haveAccountText.setFont(new Font("Comic Sans MS Bold", 25.0));
        HBox.setMargin(haveAccountText, new Insets(5.0, 0.0, 0.0, 140.0));

        LoginText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        LoginText.setFontSmoothingType(javafx.scene.text.FontSmoothingType.LCD);
        LoginText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        LoginText.setStrokeWidth(0.0);
        LoginText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        LoginText.setText("Login");
        LoginText.setFont(new Font("Comic Sans MS Bold", 30.0));
        HBox.setMargin(LoginText, new Insets(0.0, 0.0, 5.0, 5.0));
        hBox.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 25.0));
        FlowPane.setMargin(hBox, new Insets(20.0, 0.0, 0.0, 400.0));
        hBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
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

        ticTextFlowPane.getChildren().add(ticText);
        ticTextFlowPane.getChildren().add(tacText);
        ticTextFlowPane.getChildren().add(toeText);
        centerFlowPane.getChildren().add(ticTextFlowPane);
        anchorPane.getChildren().add(userNameTextField);
        anchorPane.getChildren().add(personImage);
        anchorPane.getChildren().add(passwordField);
        anchorPane.getChildren().add(imageView);
        fieldsFlowPane.getChildren().add(anchorPane);
        centerFlowPane.getChildren().add(fieldsFlowPane);
        centerFlowPane.getChildren().add(SignUpButton);
        hBox.getChildren().add(haveAccountText);
        hBox.getChildren().add(LoginText);
        centerFlowPane.getChildren().add(hBox);
        topFlowPane.getChildren().add(logoImageView);
        topTextFlowPane.getChildren().add(ticTopText);
        topTextFlowPane.getChildren().add(tacTopText);
        topTextFlowPane.getChildren().add(toeTopText);
        topFlowPane.getChildren().add(topTextFlowPane);

        LoginText.setOnMouseClicked((MouseEvent event) -> {
            Parent pane = new LoginBase(stage);
            stage.getScene().setRoot(pane);

        });

        SignUpButton.setOnAction(e -> {
            Parent pane = new OnlineListBase(stage);
            stage.getScene().setRoot(pane);

        });

    }
}
