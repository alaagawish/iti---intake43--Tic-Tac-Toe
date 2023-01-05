package tictactoe.screens.game;

import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import tictactoe.models.Player;

public class GameBase extends AnchorPane {

    protected final Circle firstPlayerCircle;
    protected final Circle secondPlayerCircle;
    protected final Button button00;
    protected final Button button01;
    protected final Button button02;
    protected final Button button10;
    protected final Button button11;
    protected final Button button12;
    protected final Button button20;
    protected final Button button21;
    protected final Button button22;
    protected final Text tacText;
    protected final Text toeText;
    protected final Text ticText;
    protected final Button recordButton;
    protected final Text firstPlayerNameText;
    protected final Text firstPlayerSignText;
    protected final Text secondPlayerNameText;
    protected final Text secondPlayerSignText;

    public char board[][];
    LocalGame localGame;
    JFrame mediaTest;
    URL mediaURL;

    public GameBase(Stage stage, String level, Player playerOne, Player playerTwo) {

        firstPlayerCircle = new Circle();
        secondPlayerCircle = new Circle();
        button00 = new Button();
        button01 = new Button();
        button02 = new Button();
        button10 = new Button();
        button11 = new Button();
        button12 = new Button();
        button20 = new Button();
        button21 = new Button();
        button22 = new Button();
        tacText = new Text();
        toeText = new Text();
        ticText = new Text();
        recordButton = new Button();
        firstPlayerNameText = new Text();
        firstPlayerSignText = new Text();
        secondPlayerNameText = new Text();
        secondPlayerSignText = new Text();

        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle("-fx-background-color: linear-gradient(#ffffff,#E5EDEE);");

        firstPlayerCircle.setFill(javafx.scene.paint.Color.WHITE);
        firstPlayerCircle.setLayoutX(134.0);
        firstPlayerCircle.setLayoutY(135.0);
        firstPlayerCircle.setRadius(60.0);
        firstPlayerCircle.setStroke(javafx.scene.paint.Color.YELLOW);
        firstPlayerCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        secondPlayerCircle.setFill(javafx.scene.paint.Color.WHITE);
        secondPlayerCircle.setLayoutX(1146.0);
        secondPlayerCircle.setLayoutY(135.0);
        secondPlayerCircle.setRadius(60.0);
        secondPlayerCircle.setStroke(javafx.scene.paint.Color.AQUAMARINE);
        secondPlayerCircle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        button00.setAlignment(javafx.geometry.Pos.CENTER);
        button00.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button00.setId("button00");
        button00.setLayoutX(263.0);
        button00.setLayoutY(182.0);
        button00.setMaxHeight(171.0);
        button00.setMaxWidth(225.0);
        button00.setMinHeight(171.0);
        button00.setMinWidth(225.0);
        button00.setMnemonicParsing(false);
        button00.setPrefHeight(171.0);
        button00.setPrefWidth(225.0);
        button00.setText(" ");
        button00.setFont(new Font("Comic Sans MS Bold", 130.0));
        button00.setPadding(new Insets(-10.0, 0.0, 15.0, 0.0));
        button00.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");

        button01.setId("button01");
        button01.setLayoutX(528.0);
        button01.setLayoutY(182.0);
        button01.setMaxHeight(171.0);
        button01.setMaxWidth(225.0);
        button01.setMinHeight(171.0);
        button01.setMinWidth(225.0);
        button01.setMnemonicParsing(false);
        button01.setPrefHeight(171.0);
        button01.setPrefWidth(225.0);
        button01.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button01.setText(" ");
        button01.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        button01.setFont(new Font("Comic Sans MS Bold", 130.0));
        button01.setPadding(new Insets(-10.0, 0.0, 15.0, 0.0));

        button02.setId("button02");
        button02.setLayoutX(793.0);
        button02.setLayoutY(182.0);
        button02.setMaxHeight(171.0);
        button02.setMaxWidth(225.0);
        button02.setMinHeight(171.0);
        button02.setMinWidth(225.0);
        button02.setMnemonicParsing(false);
        button02.setPrefHeight(171.0);
        button02.setPrefWidth(225.0);
        button02.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button02.setText(" ");
        button02.setFont(new Font("Comic Sans MS Bold", 130.0));
        button02.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        button10.setId("button10");
        button10.setLayoutX(263.0);
        button10.setLayoutY(381.0);
        button10.setMaxHeight(171.0);
        button10.setMaxWidth(225.0);
        button10.setMinHeight(171.0);
        button10.setMinWidth(225.0);
        button10.setMnemonicParsing(false);
        button10.setPrefHeight(171.0);
        button10.setPrefWidth(225.0);
        button10.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button10.setText(" ");
        button10.setFont(new Font("Comic Sans MS Bold", 130.0));
        button10.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        button11.setId("button11");
        button11.setLayoutX(528.0);
        button11.setLayoutY(381.0);
        button11.setMaxHeight(171.0);
        button11.setMaxWidth(225.0);
        button11.setMinHeight(171.0);
        button11.setMinWidth(225.0);
        button11.setMnemonicParsing(false);
        button11.setPrefHeight(171.0);
        button11.setPrefWidth(225.0);
        button11.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button11.setText(" ");
        button11.setFont(new Font("Comic Sans MS Bold", 130.0));
        button11.setPadding(new Insets(-10.0, 0.0, 15.0, 0.0));

        button12.setId("button12");
        button12.setLayoutX(793.0);
        button12.setLayoutY(381.0);
        button12.setMaxHeight(171.0);
        button12.setMaxWidth(225.0);
        button12.setMinHeight(171.0);
        button12.setMinWidth(225.0);
        button12.setMnemonicParsing(false);
        button12.setPrefHeight(171.0);
        button12.setPrefWidth(225.0);
        button12.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button12.setText(" ");
        button12.setFont(new Font("Comic Sans MS Bold", 130.0));
        button12.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        button20.setId("button20");
        button20.setLayoutX(263.0);
        button20.setLayoutY(580.0);
        button20.setMaxHeight(171.0);
        button20.setMaxWidth(225.0);
        button20.setMinHeight(171.0);
        button20.setMinWidth(225.0);
        button20.setMnemonicParsing(false);
        button20.setPrefHeight(171.0);
        button20.setPrefWidth(225.0);
        button20.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button20.setText(" ");
        button20.setFont(new Font("Comic Sans MS Bold", 130.0));
        button20.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        button21.setId("button21");
        button21.setLayoutX(528.0);
        button21.setLayoutY(580.0);
        button21.setMaxHeight(171.0);
        button21.setMaxWidth(225.0);
        button21.setMinHeight(171.0);
        button21.setMinWidth(225.0);
        button21.setMnemonicParsing(false);
        button21.setPrefHeight(171.0);
        button21.setPrefWidth(225.0);
        button21.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button21.setText(" ");
        button21.setFont(new Font("Comic Sans MS Bold", 130.0));
        button21.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        button22.setId("button22");
        button22.setLayoutX(793.0);
        button22.setLayoutY(580.0);
        button22.setMaxHeight(171.0);
        button22.setMaxWidth(225.0);
        button22.setMinHeight(171.0);
        button22.setMinWidth(225.0);
        button22.setMnemonicParsing(false);
        button22.setPrefHeight(171.0);
        button22.setPrefWidth(225.0);
        button22.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        button22.setFont(new Font("Comic Sans MS Bold", 130.0));
        button22.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        addButtonsToBoard();
        tacText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        tacText.setId("tacText");
        tacText.setLayoutX(516.0);
        tacText.setLayoutY(131.0);
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);
        tacText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        tacText.setText("Tac");
        tacText.setFont(new Font("Comic Sans MS Bold", 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        toeText.setId("toeText");
        toeText.setLayoutX(685.0);
        toeText.setLayoutY(131.0);
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);
        toeText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        toeText.setText("Toe");
        toeText.setFont(new Font("Comic Sans MS Bold", 96.0));

        ticText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        ticText.setId("ticText");
        ticText.setLayoutX(373.0);
        ticText.setLayoutY(131.0);
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        ticText.setText("Tic");
        ticText.setFont(new Font("Comic Sans MS Bold", 96.0));

        recordButton.setId("recordButton");
        recordButton.setLayoutX(1060.0);
        recordButton.setLayoutY(674.0);
        recordButton.setMnemonicParsing(false);
        recordButton.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        recordButton.setText("Record");
        recordButton.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        recordButton.setFont(new Font("Comic Sans MS Bold", 35.0));

        firstPlayerNameText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        firstPlayerNameText.setId("firstPlayerNameText");
        firstPlayerNameText.setLayoutX(60.0);
        firstPlayerNameText.setLayoutY(270.0);
        firstPlayerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstPlayerNameText.setStrokeWidth(0.0);
        firstPlayerNameText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        firstPlayerNameText.setText("Alaa");
        firstPlayerNameText.setFont(new Font("Comic Sans MS Bold", 70.0));

        firstPlayerSignText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        firstPlayerSignText.setId("firstPlayerSignText");
        firstPlayerSignText.setLayoutX(110.0);
        firstPlayerSignText.setLayoutY(345.0);
        firstPlayerSignText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstPlayerSignText.setStrokeWidth(0.0);
        firstPlayerSignText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        firstPlayerSignText.setText("X");
        firstPlayerSignText.setFont(new Font("Comic Sans MS Bold", 70.0));

        secondPlayerNameText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        secondPlayerNameText.setId("secondPlayerNameText");
        secondPlayerNameText.setLayoutX(1076.0);
        secondPlayerNameText.setLayoutY(264.0);
        secondPlayerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        secondPlayerNameText.setStrokeWidth(0.0);
        secondPlayerNameText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        secondPlayerNameText.setText("Alaa");
        secondPlayerNameText.setFont(new Font("Comic Sans MS Bold", 70.0));

        secondPlayerSignText.setFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        secondPlayerSignText.setId("secondPlayerSignText");
        secondPlayerSignText.setLayoutX(1130.0);
        secondPlayerSignText.setLayoutY(337.0);
        secondPlayerSignText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        secondPlayerSignText.setStrokeWidth(0.0);
        secondPlayerSignText.setStyle("-fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5);");
        secondPlayerSignText.setText("O");
        secondPlayerSignText.setFont(new Font("Comic Sans MS Bold", 70.0));

        getChildren().add(firstPlayerCircle);
        getChildren().add(secondPlayerCircle);
        getChildren().add(button00);
        getChildren().add(button01);
        getChildren().add(button02);
        getChildren().add(button10);
        getChildren().add(button11);
        getChildren().add(button12);
        getChildren().add(button20);
        getChildren().add(button21);
        getChildren().add(button22);
        getChildren().add(tacText);
        getChildren().add(toeText);
        getChildren().add(ticText);
        getChildren().add(recordButton);
        getChildren().add(firstPlayerNameText);
        getChildren().add(firstPlayerSignText);
        getChildren().add(secondPlayerNameText);
        getChildren().add(secondPlayerSignText);

        firstPlayerCircle.setFill(new ImagePattern(new Image(getClass().getResource("/assets/images/profilePicture.png").toExternalForm())));
        secondPlayerCircle.setFill(new ImagePattern(new Image(getClass().getResource("/assets/images/profilePicture.png").toExternalForm())));

        if (level.equals("local")) {
            localGame = new LocalGame(playerOne, playerTwo, board);
            firstPlayerNameText.setText(playerOne.getUsername());
            secondPlayerNameText.setText(playerTwo.getUsername());

        }
        button00.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button00.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button00.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));

            }
            button00.setText(localGame.gameManager.getTurn() + "");
            button00.setDisable(true);
            board[0][0] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button01.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button01.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button01.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
            }
            button01.setText(localGame.gameManager.getTurn() + "");
            button01.setDisable(true);
            board[0][1] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button02.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button02.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button02.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));

            }
            button02.setText(localGame.gameManager.getTurn() + "");
            button02.setDisable(true);
            board[0][2] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button10.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button10.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button10.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));

            }
            button10.setText(localGame.gameManager.getTurn() + "");
            button10.setDisable(true);
            board[1][0] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button11.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button11.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button11.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
            }
            button11.setText(localGame.gameManager.getTurn() + "");
            button11.setDisable(true);
            board[1][1] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button12.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button12.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button12.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));

            }
            button12.setText(localGame.gameManager.getTurn() + "");
            button12.setDisable(true);
            board[1][2] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button20.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button20.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button20.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
            }
            button20.setText(localGame.gameManager.getTurn() + "");
            button20.setDisable(true);
            board[2][0] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button21.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button21.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button21.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
            }
            button21.setText(localGame.gameManager.getTurn() + "");
            button21.setDisable(true);
            board[2][1] = localGame.gameManager.getTurn();

            flipTurn();
        });
        button22.setOnAction(e -> {
            if (localGame.gameManager.getTurn() == GameSymbol.X) {
                button22.setTextFill(javafx.scene.paint.Color.valueOf("#ffde59"));
            } else {
                button22.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));

            }
            button22.setText(localGame.gameManager.getTurn() + "");
            button22.setDisable(true);
            board[2][2] = localGame.gameManager.getTurn();

            flipTurn();
        });

    }

    public void flipTurn() {

        if (localGame.gameManager.getTurn() == GameSymbol.X) {
            localGame.gameManager.setTurn(GameSymbol.O);

        } else {
            localGame.gameManager.setTurn(GameSymbol.X);

        }
        char winnerChar = localGame.gameManager.checkWinner();
        if (winnerChar == GameSymbol.X) {
            System.out.println("winnnnnnnnnnnner is x ");
            disableButtons();

        } else if (winnerChar == GameSymbol.O) {
            System.out.println("winnnnnnnnnnnner is o ");
            disableButtons();

        } else if (winnerChar == 'D') {
            System.out.println("no winner");

        } else {
            System.out.println("game not completed");
        }
    }

    private void addButtonsToBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void disableButtons() {

        button00.setDisable(true);
        button01.setDisable(true);
        button02.setDisable(true);
        button10.setDisable(true);
        button11.setDisable(true);
        button12.setDisable(true);
        button20.setDisable(true);
        button21.setDisable(true);
        button22.setDisable(true);
    }

}
