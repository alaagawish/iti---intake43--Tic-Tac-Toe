package tictactoe.screens.authentication;

import javafx.geometry.Insets;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import tictactoe.constants.Constants;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.theme.CustomStyles;
import tictactoe.utils.Dialogs;

public class SignUpBase extends BorderPane {

    protected final VBox vBox;
    protected final FlowPane topFlowPane;
    protected final ImageView logoImageView;
    protected final FlowPane TicTacToeFlowPane;
    protected final Text ticLogoText;
    protected final Text tacLogoText;
    protected final Text toeLogoText;
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
    protected final Button signUpButton;
    protected final HBox hBox;
    protected final Text haveAccountText;
    protected final Text loginText;
    protected final ImageView backImageView;
    protected final HBox headerHBox;

    public SignUpBase(Stage stage) {
        vBox = new VBox();
        headerHBox = new HBox();
        topFlowPane = new FlowPane();
        logoImageView = new ImageView();
        centerFlowPane = new FlowPane();
        ticTextFlowPane = new FlowPane();
        ticText = new Text();
        tacText = new Text();
        toeText = new Text();
        backImageView = new ImageView();
        fieldsFlowPane = new FlowPane();
        anchorPane = new AnchorPane();
        userNameTextField = new TextField();
        personImage = new ImageView();
        passwordField = new PasswordField();
        imageView = new ImageView();
        signUpButton = new Button();
        hBox = new HBox();
        haveAccountText = new Text();
        loginText = new Text();

        TicTacToeFlowPane = new FlowPane();
        ticLogoText = new Text();
        tacLogoText = new Text();
        toeLogoText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle(CustomStyles.GRADIENTBACKGROUND);

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
        ticLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        tacLogoText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacLogoText.setText("Tac");
        tacLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        toeLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeLogoText.setText("Toe");
        toeLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        FlowPane.setMargin(toeLogoText, new Insets(0.0));
        VBox.setMargin(TicTacToeFlowPane, new Insets(0.0));
        setTop(vBox);

        ticLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        ticLogoText.setText("Tic");
        ticLogoText.setFont(new Font("Comic Sans MS Bold", 20.0));

        tacLogoText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacLogoText.setText("Tac");
        tacLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        toeLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeLogoText.setText("Toe");
        toeLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));
        FlowPane.setMargin(toeLogoText, new Insets(0.0));

        ticLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        ticLogoText.setText("Tic");
        ticLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        tacLogoText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacLogoText.setText("Tac");
        tacLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));

        toeLogoText.setFill(javafx.scene.paint.Color.valueOf("#3bb2b8"));
        toeLogoText.setText("Toe");
        toeLogoText.setFont(new Font(Constants.COMICFONTBOLD, 20.0));
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

        ticTextFlowPane.setLayoutX(766.0);
        ticTextFlowPane.setPrefHeight(70.0);
        ticTextFlowPane.setPrefWidth(485.0);

        ticText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        ticText.setLayoutX(766.0);
        ticText.setLayoutY(50.0);
        ticText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        ticText.setText("Tic");
        ticText.setX(766.0);
        ticText.setY(50.0);
        ticText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));

        tacText.setFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        tacText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        tacText.setText("Tac");
        tacText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));
        toeText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        toeText.setText("Toe");
        toeText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));
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
        userNameTextField.setFont(new Font(Constants.COMICFONTBOLD, 25.0));
        userNameTextField.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        BorderPane.setAlignment(headerHBox, javafx.geometry.Pos.CENTER);
        headerHBox.setPrefHeight(100.0);
        headerHBox.setPrefWidth(200.0);

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
        passwordField.setFont(new Font(Constants.COMICFONTBOLD, 25.0));

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setLayoutX(177.0);
        imageView.setLayoutY(163.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/images/password.png").toExternalForm()));
        FlowPane.setMargin(fieldsFlowPane, new Insets(0.0, 0.0, 0.0, 300.0));
        setTop(headerHBox);
        signUpButton.setId("styles");
        signUpButton.setMnemonicParsing(false);
        signUpButton.setPrefHeight(70.0);
        signUpButton.setPrefWidth(200.0);
        signUpButton.setStyle("-fx-background-color: rgba(252,207,40,0.7); -fx-background-radius: 45; -fx-effect: dropshadow( one-pass-box  , #BFBFC3 , 10 ,0.4 , -7, 7 );");
        signUpButton.setText("SignUp");
        signUpButton.setTextFill(javafx.scene.paint.Color.WHITE);
        FlowPane.setMargin(signUpButton, new Insets(30.0, 0.0, 0.0, 580.0));
        signUpButton.setPadding(new Insets(0.0, 10.0, 10.0, 10.0));
        signUpButton.setFont(new Font(Constants.COMICFONTBOLD, 35.0));

        hBox.setPrefHeight(70.0);
        hBox.setPrefWidth(200.0);

        haveAccountText.setText("Have an account?");
        haveAccountText.setFont(new Font(Constants.COMICFONTBOLD, 25.0));
        HBox.setMargin(haveAccountText, new Insets(5.0, 0.0, 0.0, 130.0));

        loginText.setFill(javafx.scene.paint.Color.valueOf("#33bbbb"));

        loginText.setText("Login");
        loginText.setFont(new Font(Constants.COMICFONTBOLD, 30.0));
        HBox.setMargin(loginText, new Insets(0.0, 0.0, 5.0, 5.0));
        hBox.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 25.0));
        FlowPane.setMargin(hBox, new Insets(20.0, 0.0, 0.0, 400.0));
        hBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        setCenter(centerFlowPane);

        vBox.getChildren().add(logoImageView);
        TicTacToeFlowPane.getChildren().add(ticLogoText);
        TicTacToeFlowPane.getChildren().add(tacLogoText);
        TicTacToeFlowPane.getChildren().add(toeLogoText);
        vBox.getChildren().add(TicTacToeFlowPane);

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
        centerFlowPane.getChildren().add(signUpButton);
        hBox.getChildren().add(haveAccountText);
        hBox.getChildren().add(loginText);
        centerFlowPane.getChildren().add(hBox);

        headerHBox.getChildren().add(backImageView);
        headerHBox.getChildren().add(vBox);

        loginText.setOnMouseClicked(e -> {
            Parent pane = new LoginBase(stage);
            stage.getScene().setRoot(pane);
        });

        signUpButton.setOnAction(e -> {

            validation(passwordField.getText(), userNameTextField.getText(), stage);
//            Player player = DualModeBase.network.register(userNameTextField.getText(), passwordField.getText());
//            if (player != null && passwordField.getText() != null) {
//                Parent pane = new OnlineListBase(stage, player);
//                stage.getScene().setRoot(pane);
//            } else {
//                userNameTextField.setText("");
//                passwordField.setText("");
//               
//
//            }
        });
        backImageView.setOnMousePressed(e -> {
            DualModeBase.network.closeConnection();

            Parent pane = new DualModeBase(stage);
            stage.getScene().setRoot(pane);

        });

    }

    private void validation(String password, String userName, Stage stage) {

        if (userName.isEmpty()) {
            Dialogs.showAlertDialog(
                    Alert.AlertType.INFORMATION,
                    "Information Dialog",
                    "The User Name Field is Empty",
                    "Insert your User Name First");

        } else if (password.isEmpty()) {
            Dialogs.showAlertDialog(
                    Alert.AlertType.INFORMATION,
                    "Information Dialog",
                    "The Password Field is Empty",
                    "Insert your Passowrd First");

        } else {
            Player player = DualModeBase.network.register(userName, password);
            if (player != null) {
                System.out.println("SignUp done");
                Parent pane = new OnlineListBase(stage, player);
                stage.getScene().setRoot(pane);
            } else {
                userNameTextField.setText("");
                passwordField.setText("");

            }
        }
    }
}
