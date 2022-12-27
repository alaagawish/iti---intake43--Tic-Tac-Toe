package tictactoe.screens.dualmode;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import tictactoe.utils.Dialogs;

public class OnlineListBase extends ScrollPane {

    protected final BorderPane listBorderPane;
    protected final BorderPane borderPane;
    protected final Circle profileCircle;
    protected final VBox listVBox;
    protected final Label savedGamesLabel;
    protected final HBox gameHBox;
    protected final Label playerName;
    protected final Button inviteButton;
    protected final DropShadow dropShadow;
    protected final Line gameLine;
    protected final HBox hBox;
    protected final Label label;
    protected final Button inviteButton2;
    protected final DropShadow dropShadow0;
    protected final Line line;
    protected final HBox hBox0;
    protected final Label label0;
    protected final Button inviteButton3;
    protected final DropShadow dropShadow1;

    public OnlineListBase() {

        listBorderPane = new BorderPane();
        borderPane = new BorderPane();
        profileCircle = new Circle();
        listVBox = new VBox();
        savedGamesLabel = new Label();
        gameHBox = new HBox();
        playerName = new Label();
        inviteButton = new Button();
        dropShadow = new DropShadow();
        gameLine = new Line();
        hBox = new HBox();
        label = new Label();
        inviteButton2 = new Button();
        dropShadow0 = new DropShadow();
        line = new Line();
        hBox0 = new HBox();
        label0 = new Label();
        inviteButton3 = new Button();
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
        profileCircle.setRadius(100.0);
        profileCircle.setStroke(javafx.scene.paint.Color.BLACK);
        profileCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        BorderPane.setMargin(profileCircle, new Insets(30.0, 60.0, 0.0, 0.0));
        borderPane.setRight(profileCircle);
        listBorderPane.setTop(borderPane);
        
        Image profilePic = new Image("/assets/images/profilePicture.png",false);
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
        VBox.setMargin(savedGamesLabel, new Insets(30.0, 0.0, 0.0, 0.0));

        gameHBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        gameHBox.setPrefHeight(100.0);
        gameHBox.setPrefWidth(200.0);

        playerName.setPrefHeight(56.0);
        playerName.setPrefWidth(880.0);
        playerName.setText("Arwa Ashraf");
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
        playerName.setFont(new Font("Comic Sans MS Bold", 30.0));

        inviteButton.setId("inviteButton");
        inviteButton.setMnemonicParsing(false);
        inviteButton.setPrefHeight(29.0);
        inviteButton.setPrefWidth(138.0);
        inviteButton.setStyle("-fx-background-color: rgba(156, 216, 100,1); -fx-background-radius: 10;");
        inviteButton.setText("Invite");
        
        inviteButton.setTextFill(javafx.scene.paint.Color.WHITE);
        inviteButton.setFont(new Font("Comic Sans MS Bold", 24.0));
                     
        inviteButton2.setTextFill(javafx.scene.paint.Color.WHITE);
        inviteButton2.setFont(new Font("Comic Sans MS Bold", 24.0));
        
        
        StackPane stackpane = new StackPane();
        stackpane.getChildren().add(listBorderPane);
        BoxBlur blur = new BoxBlur(3,3,3);
                
        JFXDialog dialog = Dialogs.createBlurRequestingDialog("Waiting Arwa To Accept the invitation ...",stackpane);
        
        dialog.setOnDialogClosed((event) -> {
            listBorderPane.setEffect(null);
        });
        
        inviteButton.setOnAction((ActionEvent event) -> {
            dialog.show();
            listBorderPane.setEffect(blur);
            
        });
        
        

        dropShadow.setColor(Color.rgb(140,140,140,1));
        
        dropShadow.setHeight(1.0);
        dropShadow.setOffsetX(-3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setRadius(0.0);
        dropShadow.setWidth(0.0);
        inviteButton.setEffect(dropShadow);
        VBox.setMargin(gameHBox, new Insets(10.0, 0.0, 10.0, 60.0));

        gameLine.setEndX(1027.2928466796875);
        gameLine.setEndY(71.29289245605469);
        gameLine.setStartX(2154.585693359375);
        gameLine.setStartY(70.58578491210938);
        gameLine.setStroke(javafx.scene.paint.Color.valueOf("#a4a4a4"));
        gameLine.setStrokeWidth(2.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setLayoutX(70.0);
        hBox.setLayoutY(326.0);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        label.setPrefHeight(56.0);
        label.setPrefWidth(880.0);
        label.setText("Alaa Al Sayed");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
        label.setFont(new Font("Comic Sans MS Bold", 30.0));

        inviteButton2.setId("inviteButton2");
        inviteButton2.setMnemonicParsing(false);
        inviteButton2.setPrefHeight(29.0);
        inviteButton2.setPrefWidth(138.0);
        inviteButton2.setStyle("-fx-background-color: rgba(156, 216, 100,1); -fx-background-radius: 10;");
        inviteButton2.setText("Invite");
        inviteButton2.setTextFill(javafx.scene.paint.Color.WHITE);
        inviteButton2.setFont(new Font("Comic Sans MS Bold", 24.0));

        dropShadow0.setColor(Color.rgb(140,140,140,1));
        dropShadow0.setHeight(1.0);
        dropShadow0.setOffsetX(-3.0);
        dropShadow0.setOffsetY(3.0);
        dropShadow0.setRadius(0.0);
        dropShadow0.setWidth(0.0);
        inviteButton2.setEffect(dropShadow0);
        VBox.setMargin(hBox, new Insets(10.0, 0.0, 10.0, 60.0));

        line.setEndX(1027.2928466796875);
        line.setEndY(71.29289245605469);
        line.setLayoutX(-1017.0);
        line.setLayoutY(256.0);
        line.setStartX(2154.585693359375);
        line.setStartY(70.58578491210938);
        line.setStroke(javafx.scene.paint.Color.valueOf("#a4a4a4"));
        line.setStrokeWidth(2.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setLayoutX(10.0);
        hBox0.setLayoutY(432.0);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        label0.setPrefHeight(56.0);
        label0.setPrefWidth(880.0);
        label0.setText("Nada Ayman");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#6dcfd0"));
        label0.setFont(new Font("Comic Sans MS Bold", 30.0));

        inviteButton3.setId("inviteButton3");
        inviteButton3.setMnemonicParsing(false);
        inviteButton3.setPrefHeight(29.0);
        inviteButton3.setPrefWidth(138.0);
        inviteButton3.setStyle("-fx-background-color: rgba(156, 216, 100,1); -fx-background-radius: 10;");
        inviteButton3.setText("Invite");
        inviteButton3.setTextFill(javafx.scene.paint.Color.WHITE);
        inviteButton3.setFont(new Font("Comic Sans MS Bold", 24.0));

        dropShadow1.setColor(Color.rgb(140,140,140,1));
        dropShadow1.setHeight(1.0);
        dropShadow1.setOffsetX(-3.0);
        dropShadow1.setOffsetY(3.0);
        dropShadow1.setRadius(0.0);
        dropShadow1.setWidth(0.0);
        inviteButton3.setEffect(dropShadow1);
        VBox.setMargin(hBox0, new Insets(10.0, 0.0, 10.0, 60.0));
        BorderPane.setMargin(listVBox, new Insets(0.0, 0.0, 0.0, 60.0));
        listBorderPane.setCenter(listVBox);
        setContent(stackpane);
        //setContent(listBorderPane);

        listVBox.getChildren().add(savedGamesLabel);
        gameHBox.getChildren().add(playerName);
        gameHBox.getChildren().add(inviteButton);
        listVBox.getChildren().add(gameHBox);
        listVBox.getChildren().add(gameLine);
        hBox.getChildren().add(label);
        hBox.getChildren().add(inviteButton2);
        listVBox.getChildren().add(hBox);
        listVBox.getChildren().add(line);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(inviteButton3);
        listVBox.getChildren().add(hBox0);
        
        
        

    }
    
    void showDialog(String text){
        Dialog<String> dialog = new Dialog();
            
        dialog.setTitle("Dialog");
        dialog.setContentText(text);

        //ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        //dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }
}
