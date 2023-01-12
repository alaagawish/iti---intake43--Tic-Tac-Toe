package tictactoe.screens.modes;

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
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.singlemode.LevelsBase;

public class ModeBase extends AnchorPane {

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
    protected final Button singleModeButton;
    protected final VBox vBox0;
    protected final ImageView imageView;
    protected final Text text2;
    protected final Button dualModeButton;
    protected final VBox vBox1;
    protected final ImageView imageView0;
    protected final Text text3;

    public ModeBase(Stage stage) {

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
        singleModeButton = new Button();
        vBox0 = new VBox();
        imageView = new ImageView();
        text2 = new Text();
        dualModeButton = new Button();
        vBox1 = new VBox();
        imageView0 = new ImageView();
        text3 = new Text();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        vBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        vBox.setPrefHeight(97.0);
        vBox.setPrefWidth(1280.0);

        logoImage.setFitHeight(68.0);
        logoImage.setFitWidth(65.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);
        logoImage.setImage(new Image(getClass().getResource("/assets/images/logo.png").toExternalForm()));
        VBox.setMargin(logoImage, new Insets(10.0, 30.0, 0.0, 0.0));

        hBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        text.setText("Tic");
        text.setFont(new Font("Comic Sans MS Bold", 20.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#fccf28"));
        text0.setText("Tac");
        text0.setFont(new Font("Comic Sans MS Bold", 20.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        text1.setText("Toe");
        text1.setFont(new Font("Comic Sans MS Bold", 20.0));
        VBox.setMargin(hBox, new Insets(0.0, 10.0, 0.0, 0.0));

        hBox0.setLayoutX(390.0);
        hBox0.setLayoutY(146.0);
        hBox0.setPrefHeight(137.0);
        hBox0.setPrefWidth(500.0);

        ticText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        ticText.setText("Tic");
        ticText.setFont(new Font("Comic Sans MS Bold", 96.0));

        tacText.setFill(javafx.scene.paint.Color.valueOf("#facc28"));
        tacText.setText("Tac");
        tacText.setFont(new Font("Comic Sans MS Bold", 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        toeText.setText("Toe");
        toeText.setFont(new Font("Comic Sans MS Bold", 96.0));

        hBox1.setLayoutY(300.0);
        hBox1.setPrefHeight(500.0);
        hBox1.setPrefWidth(1280.0);

        singleModeButton.setMnemonicParsing(false);
        singleModeButton.setPrefHeight(302.0);
        singleModeButton.setPrefWidth(414.0);
        singleModeButton.setStyle("-fx-background-color: #fccf28; -fx-opacity: 0.7; -fx-background-radius: 42px;");
        HBox.setMargin(singleModeButton, new Insets(100.0, 150.0, 0.0, 150.0));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(-10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setColor(Color.color(0, 0, 0, .16));

        singleModeButton.setEffect(dropShadow);

        vBox0.setPrefHeight(302.0);
        vBox0.setPrefWidth(414.0);

        imageView.setFitHeight(189.0);
        imageView.setFitWidth(398.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/images/single.png").toExternalForm()));

        text2.setFill(javafx.scene.paint.Color.WHITE);
        text2.setText("Single Mode");
        text2.setFont(new Font("Comic Sans MS Bold", 40.0));
        VBox.setMargin(text2, new Insets(21.0, 0.0, 0.0, 80.0));
        singleModeButton.setGraphic(vBox0);

        dualModeButton.setMnemonicParsing(false);
        dualModeButton.setPrefHeight(302.0);
        dualModeButton.setPrefWidth(414.0);
        dualModeButton.setStyle("-fx-background-color: #3dc0c2; -fx-opacity: 0.7; -fx-background-radius: 42px;");
        HBox.setMargin(dualModeButton, new Insets(100.0, 150.0, 0.0, 0.0));

        dualModeButton.setEffect(dropShadow);

        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(414.0);

        imageView0.setFitHeight(133.0);
        imageView0.setFitWidth(414.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/images/dualMode.png").toExternalForm()));
        VBox.setMargin(imageView0, new Insets(60.0, 0.0, 0.0, 0.0));

        text3.setFill(javafx.scene.paint.Color.WHITE);
        text3.setText("Dual Mode");
        text3.setFont(new Font("Comic Sans MS Bold", 40.0));
        VBox.setMargin(text3, new Insets(22.0, 0.0, 0.0, 103.0));
        dualModeButton.setGraphic(vBox1);

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
        hBox1.getChildren().add(singleModeButton);
        vBox1.getChildren().add(imageView0);
        vBox1.getChildren().add(text3);
        hBox1.getChildren().add(dualModeButton);
        getChildren().add(hBox1);

        DropShadow dropShadowText = new DropShadow();
        dropShadowText.setRadius(5.0);
        dropShadowText.setOffsetX(-10.0);
        dropShadowText.setOffsetY(10.0);

        dropShadowText.setColor(Color.color(0, 0, 0, .16));

        ticText.setEffect(dropShadowText);
        tacText.setEffect(dropShadowText);
        toeText.setEffect(dropShadowText);

        dualModeButton.setOnAction(e -> {
            Parent pane = new DualModeBase(stage);
            stage.getScene().setRoot(pane);
        });

        singleModeButton.setOnAction(e -> {
            Parent pane = new LevelsBase(stage);
            stage.getScene().setRoot(pane);
        });

    }
}
