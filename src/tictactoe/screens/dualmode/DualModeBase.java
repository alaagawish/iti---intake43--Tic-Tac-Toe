package tictactoe.screens.dualmode;

import javafx.geometry.Insets;

import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import tictactoe.screens.authentication.LoginBase;


public class DualModeBase extends AnchorPane {

    protected final VBox vBox;
    protected final ImageView logoImage;
    protected final HBox hBox;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final HBox hBox0;
    protected final Text ticText;
    protected final Text tacText;
    protected final Text toeText;
    protected final HBox hBox1;
    protected final Button localButton;
    protected final VBox vBox0;
    protected final ImageView imageView;
    protected final Text text2;
    protected final Button onlineButton;
    protected final VBox vBox1;
    protected final ImageView imageView0;
    protected final Text text3;

    public DualModeBase(Stage stage) {


        vBox = new VBox();
        logoImage = new ImageView();
        hBox = new HBox();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        hBox0 = new HBox();
        ticText = new Text();
        tacText = new Text();
        toeText = new Text();
        hBox1 = new HBox();
        localButton = new Button();
        vBox0 = new VBox();
        imageView = new ImageView();
        text2 = new Text();
        onlineButton = new Button();
        vBox1 = new VBox();
        imageView0 = new ImageView();
        text3 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        vBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        vBox.setLayoutX(10.0);
        vBox.setLayoutY(10.0);
        vBox.setPrefHeight(97.0);
        vBox.setPrefWidth(1280.0);

        logoImage.setFitHeight(68.0);
        logoImage.setFitWidth(65.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);
        logoImage.setImage(new Image(getClass().getResource("/assets/images/logo.png").toExternalForm()));
        VBox.setMargin(logoImage, new Insets(10.0, 35.0, 0.0, 0.0));

        hBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic");
        text.setFont(new Font("Comic Sans MS Bold", 20.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Tac");
        text0.setFont(new Font("Comic Sans MS Bold", 20.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Toe");
        text1.setFont(new Font("Comic Sans MS Bold", 20.0));
        HBox.setMargin(text1, new Insets(0.0, 10.0, 0.0, 0.0));
        VBox.setMargin(hBox, new Insets(0.0, 10.0, 0.0, 0.0));

        hBox0.setLayoutX(400.0);
        hBox0.setLayoutY(156.0);
        hBox0.setPrefHeight(137.0);
        hBox0.setPrefWidth(500.0);

        ticText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setStrokeWidth(1);
        ticText.setStroke(Color.BLACK);
        ticText.setText("Tic");
        ticText.setFont(new Font("Comic Sans MS Bold", 96.0));

        tacText.setFill(javafx.scene.paint.Color.valueOf("#facc28"));
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);

        tacText.setStrokeWidth(1);
        tacText.setStroke(Color.BLACK);

        tacText.setText("Tac");
        tacText.setFont(new Font("Comic Sans MS Bold", 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);

        toeText.setStrokeWidth(1);
        toeText.setStroke(Color.BLACK);

        toeText.setText("Toe");
        toeText.setFont(new Font("Comic Sans MS Bold", 96.0));

        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(310.0);
        hBox1.setPrefHeight(500.0);
        hBox1.setPrefWidth(1280.0);

        localButton.setMnemonicParsing(false);
        localButton.setPrefHeight(302.0);
        localButton.setPrefWidth(414.0);
        localButton.setStyle("-fx-background-color: #fccf28; -fx-opacity: 0.7; -fx-background-radius: 42px;");
        HBox.setMargin(localButton, new Insets(100.0, 150.0, 0.0, 150.0));
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(-10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setColor(Color.color(0,0,0,.16));  
        
        localButton.setEffect(dropShadow);

        vBox0.setPrefHeight(302.0);
        vBox0.setPrefWidth(414.0);

        imageView.setFitHeight(140.0);
        imageView.setFitWidth(330.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/images/local.png").toExternalForm()));
        VBox.setMargin(imageView, new Insets(44.0, 0.0, 0.0, 130.0));

        text2.setFill(javafx.scene.paint.Color.WHITE);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);

        text2.setStrokeWidth(1);
        text2.setStroke(Color.BLACK);

        text2.setText("Local");
        text2.setFont(new Font("Comic Sans MS Bold", 65.0));
        VBox.setMargin(text2, new Insets(12.0, 0.0, 0.0, 121.0));
        localButton.setGraphic(vBox0);

        onlineButton.setMnemonicParsing(false);
        onlineButton.setPrefHeight(302.0);
        onlineButton.setPrefWidth(414.0);
        onlineButton.setStyle("-fx-background-color: #3dc0c2; -fx-opacity: 0.7; -fx-background-radius: 42px;;");
        HBox.setMargin(onlineButton, new Insets(100.0, 150.0, 0.0, 0.0));
        
        onlineButton.setEffect(dropShadow);
        
        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(414.0);

        imageView0.setFitHeight(134.0);
        imageView0.setFitWidth(400.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/images/online.png").toExternalForm()));
        VBox.setMargin(imageView0, new Insets(40.0, 0.0, 0.0, 130.0));

        text3.setFill(javafx.scene.paint.Color.WHITE);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);

        text3.setStrokeWidth(1);
        text3.setStroke(Color.BLACK);

        text3.setText("Online");
        text3.setFont(new Font("Comic Sans MS Bold", 65.0));
        VBox.setMargin(text3, new Insets(22.0, 0.0, 0.0, 110.0));
        onlineButton.setGraphic(vBox1);
        
        

        vBox.getChildren().add(logoImage);
        hBox.getChildren().add(text);
        hBox.getChildren().add(text0);
        hBox.getChildren().add(text1);
        vBox.getChildren().add(hBox);
        getChildren().add(vBox);
        hBox0.getChildren().add(ticText);
        hBox0.getChildren().add(tacText);
        hBox0.getChildren().add(toeText);
        getChildren().add(hBox0);
        vBox0.getChildren().add(imageView);
        vBox0.getChildren().add(text2);
        hBox1.getChildren().add(localButton);
        vBox1.getChildren().add(imageView0);
        vBox1.getChildren().add(text3);
        hBox1.getChildren().add(onlineButton);
        getChildren().add(hBox1);

        
        onlineButton.setOnAction(e -> {
            Parent pane = new LoginBase(stage);
            stage.getScene().setRoot(pane);
        });
        
        localButton.setOnAction(e -> {
            Parent pane = new LocalBase(stage);
            stage.getScene().setRoot(pane);
        });


    }
}
