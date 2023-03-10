package tictactoe.screens.game;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.GameModel;
import tictactoe.models.Move;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.theme.CustomStyles;
import tictactoe.screens.modes.ModeBase;
import tictactoe.screens.profile.ProfileBase;
import tictactoe.screens.singlemode.LevelsBase;

public class GameBase extends AnchorPane implements Runnable {

    protected final Circle firstPlayerCircle;
    protected final Circle secondPlayerCircle;
    public Button button00;
    public Button button01;
    public Button button02;
    public Button button10;
    public Button button11;
    public Button button12;
    public Button button20;
    public Button button21;
    public Button button22;
    protected final Text tacText;
    protected final Text toeText;
    protected final Text ticText;
    protected final Button recordButton;
    protected final Button exitButton;
    protected final Text firstPlayerNameText;
    protected final Text firstPlayerSignText;
    protected final Text secondPlayerNameText;
    protected final Text secondPlayerSignText;
    public static List<Move> moves;
    protected char board[][];
    private GameManager gameManager;
    private final Stage stageVideo;
    private boolean recordFlag;
    public char playerSymbol;
    private Level gameLevel;
    public GameModel recordedGamee;
    Thread thread, th;
    protected Player firstPlayer, secondPlayer;
    Move m;
    public boolean updateFlag = true;
    public char playerTurn;
    public boolean exitX;
    public boolean exitO;

    public GameBase(Stage stage, Level level, Player playerOne, Player playerTwo, char playerSymbol) {
        this.playerSymbol = playerSymbol;
        thread = new Thread(this);
        this.stageVideo = stage;
        this.gameLevel = level;
        this.playerTurn = playerSymbol;
        exitX = false;
        exitO = false;
        moves = new ArrayList<>();
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
        exitButton = new Button();
        firstPlayerNameText = new Text();
        firstPlayerSignText = new Text();
        secondPlayerNameText = new Text();
        secondPlayerSignText = new Text();
//        resultMoves = new ArrayList<>();
        recordFlag = false;
        this.firstPlayer = playerOne;
        this.secondPlayer = playerTwo;
        setId("AnchorPane");
        setPrefHeight(800.0);
        setPrefWidth(1280.0);
        setStyle(CustomStyles.GRADIENTBACKGROUND);

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
        button00.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button00.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button01.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button01.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button02.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button02.setText(" ");
        button02.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button02.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button10.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button10.setText(" ");
        button10.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button10.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button11.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button11.setText(" ");
        button11.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button11.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button12.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button12.setText(" ");
        button12.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button12.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button20.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button20.setText(" ");
        button20.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button20.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button21.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button21.setText(" ");
        button21.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button21.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
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
        button22.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        button22.setText(" ");
        button22.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        button22.setFont(new Font(Constants.COMICFONTBOLD, 130.0));
        button22.setPadding(new Insets(-10.0, 0.0, 0.0, 0.0));

        addButtonsToBoard();
        tacText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.YELLOW));
        tacText.setId("tacText");
        tacText.setLayoutX(516.0);
        tacText.setLayoutY(131.0);
        tacText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        tacText.setStrokeWidth(0.0);
        tacText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        tacText.setText("Tac");
        tacText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));

        toeText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        toeText.setId("toeText");
        toeText.setLayoutX(685.0);
        toeText.setLayoutY(131.0);
        toeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        toeText.setStrokeWidth(0.0);
        toeText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        toeText.setText("Toe");
        toeText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));

        ticText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        ticText.setId("ticText");
        ticText.setLayoutX(373.0);
        ticText.setLayoutY(131.0);
        ticText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ticText.setStrokeWidth(0.0);
        ticText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        ticText.setText("Tic");
        ticText.setFont(new Font(Constants.COMICFONTBOLD, 96.0));

        recordButton.setId("recordButton");
        recordButton.setLayoutX(1060.0);
        recordButton.setLayoutY(674.0);
        recordButton.setMnemonicParsing(false);
        recordButton.setStyle(CustomStyles.DROPDOWNSHADOW_BUTTON);
        recordButton.setText("Record");
        recordButton.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        recordButton.setFont(new Font(Constants.COMICFONTBOLD, 35.0));

        firstPlayerNameText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.YELLOW));

        exitButton.setId("exitButton");
        exitButton.setLayoutX(65.0);
        exitButton.setLayoutY(674.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setStyle("-fx-background-radius: 25; -fx-effect: dropshadow(one-pass-box ,#BFBFC3,10,0.3,-5,5); -fx-background-color: #EAE9E9;");
        exitButton.setText("Exit");
        exitButton.setTextFill(javafx.scene.paint.Color.valueOf("#3dc0c2"));
        exitButton.setFont(new Font("Comic Sans MS Bold", 35.0));

        firstPlayerNameText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        firstPlayerNameText.setId("firstPlayerNameText");
        firstPlayerNameText.setLayoutX(60.0);
        firstPlayerNameText.setLayoutY(270.0);
        firstPlayerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstPlayerNameText.setStrokeWidth(0.0);
        firstPlayerNameText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        firstPlayerNameText.setText("Alaa");
        firstPlayerNameText.setFont(new Font(Constants.COMICFONTBOLD, 60.0));

        firstPlayerSignText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.YELLOW));
        firstPlayerSignText.setId("firstPlayerSignText");
        firstPlayerSignText.setLayoutX(110.0);
        firstPlayerSignText.setLayoutY(345.0);
        firstPlayerSignText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        firstPlayerSignText.setStrokeWidth(0.0);
        firstPlayerSignText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        firstPlayerSignText.setText(Constants.X + "");
        firstPlayerSignText.setFont(new Font(Constants.COMICFONTBOLD, 60.0));

        secondPlayerNameText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        secondPlayerNameText.setId("secondPlayerNameText");
        secondPlayerNameText.setLayoutX(1076.0);
        secondPlayerNameText.setLayoutY(264.0);
        secondPlayerNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        secondPlayerNameText.setStrokeWidth(0.0);
        secondPlayerNameText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        secondPlayerNameText.setText("Alaa");
        secondPlayerNameText.setFont(new Font(Constants.COMICFONTBOLD, 70.0));

        secondPlayerSignText.setFill(javafx.scene.paint.Color.valueOf(CustomStyles.BLUE));
        secondPlayerSignText.setId("secondPlayerSignText");
        secondPlayerSignText.setLayoutX(1076.0);
        secondPlayerSignText.setLayoutY(337.0);
        secondPlayerSignText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        secondPlayerSignText.setStrokeWidth(0.0);
        secondPlayerSignText.setStyle(CustomStyles.DRPDOWNSHADOW_TEXT);
        secondPlayerSignText.setText(Constants.O + "");
        secondPlayerSignText.setFont(new Font(Constants.COMICFONTBOLD, 70.0));

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
        getChildren().add(exitButton);

        firstPlayerCircle.setFill(new ImagePattern(new Image(getClass().getResource("/assets/images/profilePicture.png").toExternalForm())));
        secondPlayerCircle.setFill(new ImagePattern(new Image(getClass().getResource("/assets/images/profilePicture.png").toExternalForm())));

        firstPlayerNameText.setText(playerOne.getUsername());
        secondPlayerNameText.setText(playerTwo.getUsername());
        if (level == Level.ONLINE) {
            firstPlayerSignText.setLayoutX(60.0);
            firstPlayerSignText.setFont(new Font(Constants.COMICFONTBOLD, 30.0));
            secondPlayerSignText.setLayoutX(1090.0);
            secondPlayerSignText.setFont(new Font(Constants.COMICFONTBOLD, 30.0));
            firstPlayerSignText.setText("Score: " + playerOne.getScore() + "");
            secondPlayerSignText.setText("Score: " + playerTwo.getScore() + "");
        }
        gameManager = new GameManager(playerOne, playerTwo, board, level);
        if (Level.ONLINE == level && playerSymbol == Constants.O) {
            disableButtons();
        }
        button00.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button00, 0, 0, Level.ONLINE);
            } else {
                handleButton(button00, 0, 0, level);
            }
        });

        button01.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button01, 0, 1, Level.ONLINE);
            } else {
                handleButton(button01, 0, 1, level);
            }
        });

        button02.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button02, 0, 2, Level.ONLINE);
            } else {
                handleButton(button02, 0, 2, level);
            }
        });

        button10.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button10, 1, 0, Level.ONLINE);
            } else {
                handleButton(button10, 1, 0, level);
            }
        });
        button11.setOnAction(e -> {

            if (level == Level.ONLINE) {
                handleButtonOnline(button11, 1, 1, Level.ONLINE);
            } else {

                handleButton(button11, 1, 1, level);
            }
        });

        button12.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button12, 1, 2, Level.ONLINE);
            } else {
                handleButton(button12, 1, 2, level);
            }
        });

        button20.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button20, 2, 0, Level.ONLINE);
            } else {
                handleButton(button20, 2, 0, level);
            }
        });

        button21.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button21, 2, 1, Level.ONLINE);
            } else {
                handleButton(button21, 2, 1, level);
            }
        });
        button22.setOnAction(e -> {
            if (level == Level.ONLINE) {
                handleButtonOnline(button22, 2, 2, Level.ONLINE);
            } else {
                handleButton(button22, 2, 2, level);
            }
        });
        recordButton.setOnAction(e -> {
            recordFlag = true;
            gameManager.setRecorded(true);
            gameManager.createFile();
            recordButton.setDisable(true);
            recordButton.setStyle(CustomStyles.RECORDBUTTONSTYLE);
            recordButton.setText("Record");
            recordButton.setTextFill(javafx.scene.paint.Color.valueOf(CustomStyles.WHITE));

        });

        exitButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Are you sure to exit?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton && level == Level.ONLINE) {
                    if (playerTurn == Constants.X) {
                        moves.add(new Move(10, 10, ' '));
                        DualModeBase.network.sendMove(firstPlayer, secondPlayer, moves);

                        Parent pane = new OnlineListBase(stage, playerOne);
                        stage.getScene().setRoot(pane);
                        th.stop();
                    } else {
                        moves.add(new Move(10, 10, ' '));
                        DualModeBase.network.sendMove(firstPlayer, secondPlayer, moves);

                        Parent pane = new OnlineListBase(stage, playerTwo);
                        stage.getScene().setRoot(pane);
                        th.stop();
                    }
                } else if (type == okButton && (level == Level.Easy || level == Level.MEDIUM || level == Level.HARD)) {
                    Parent pane = new LevelsBase(stage);
                    stage.getScene().setRoot(pane);
                } else if (type == okButton && level == Level.LOCAL) {
                    Parent pane = new DualModeBase(stage);
                    stage.getScene().setRoot(pane);
                } else if (type == okButton && level == Level.ONLINERECORD) {
                    Parent pane = new ProfileBase(stage, playerOne);
                    stage.getScene().setRoot(pane);
                } else if (type == okButton && level == Level.LOCALRECORD) {
                    Parent pane = new ModeBase(stage);
                    stage.getScene().setRoot(pane);
                }
            });

        });
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (moves.size() > 0 && moves.get(moves.size() - 1).getRow() == 10 && moves.get(moves.size() - 1).getSymbol() != playerSymbol) {
                        System.out.println("player " + playerSymbol + " , exit");

                        disableButtons();
                        System.out.println("winner =2 in find winnerO");
                        winnerFXMLBase.video = "/assets/images/winnerVideo.mp4";
                        winnerFXMLBase.message = "Winner Winner Chiken Dinner";
                        setNames(firstPlayerNameText, secondPlayerNameText);
                        System.out.println("winner =2 in find winnerO");
                        Parent panee = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, Constants.O);
                        stageVideo.getScene().setRoot(panee);
                        th.stop();
                        gameManager.printArray();
                        //DualModeBase.network.updateScore(secondPlayer.getUsername(), secondPlayer.getScore() + 5);
                        if (recordFlag) {
                            gameManager.saveGame();
                        }
                    }
                    if (updateFlag && moves.size() > 0 && moves.get(moves.size() - 1).getSymbol() != playerSymbol) {
                        updateBoard();
                        updateFlag = false;
                    }
                    if (moves.size() % 2 == 0 && playerSymbol == Constants.X) {
                        switchButtons();
                    } else if (moves.size() % 2 == 0 && playerSymbol == Constants.O) {
                        disableButtons();
                    } else if (moves.size() % 2 == 1 && playerSymbol == Constants.X) {
                        disableButtons();
                    } else if (moves.size() % 2 == 1 && playerSymbol == Constants.O) {
                        switchButtons();
                    }
                    try {
                        th.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    if (playerSymbol == Constants.X) {
                        findWinner();
                    } else if (playerSymbol == Constants.O) {
                        findWinnerO();
                    }

                }

            }

        });
        if (level == Level.ONLINE) {
            th.start();
        } else if (level == Level.LOCALRECORD || level == Level.ONLINERECORD) {
            disableButtons();
        }

        if (level == Level.LOCALRECORD || level == Level.ONLINERECORD) {
            recordButton.setVisible(false);
        }

    }

    private void updateBoard() {
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < moves.size(); i++) {
                    computerMove(moves.get(i));
                }

                if (moves.size() > 0) {

                    m = moves.get(moves.size() - 1);
                    System.out.println("before recordGameSteps" + m);
                    recordGameSteps(m.getRow(), m.getColumn(), m.getSymbol());
                    board[m.getRow()][m.getColumn()] = m.getSymbol();
                }
                if (playerSymbol == Constants.X) {
                    findWinner();
                } else if (playerSymbol == Constants.O) {
                    findWinnerO();
                }

            }
        });
    }

    public void handleButtonOnline(Button button, int i, int j, Level level) {
        updateFlag = true;
        if (playerSymbol == Constants.X) {
            findWinner();
        } else if (playerSymbol == Constants.O) {
            findWinnerO();
        }
        moves.add(new Move(i, j, playerSymbol));
        board[i][j] = playerSymbol;

        computerMove(moves.get(moves.size() - 1));

        int row = moves.get(moves.size() - 1).getRow();
        int col = moves.get(moves.size() - 1).getColumn();
        System.out.println("row:" + row + "col:" + col);
        recordGameSteps(row, col, board[row][col]);
        DualModeBase.network.sendMove(firstPlayer, secondPlayer, moves);

    }

    public synchronized void findWinner() {
        Parent pane;
        int winner = GameManager.checkWinner();

        if (winner == 2) {
            disableButtons();
            winnerFXMLBase.video = "/assets/images/losser.mp4";
            winnerFXMLBase.message = "Hard Luck Next Time";
            setNames(firstPlayerNameText, secondPlayerNameText);
            pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, Constants.X);

            System.out.println("winner =2 in find winner");

            stageVideo.getScene().setRoot(pane);
            if (recordFlag) {
                System.out.println("winnero2");

                gameManager.saveGame();
            }
            th.stop();
            gameManager.printArray();
            //DualModeBase.network.updateScore(firstPlayer.getUsername(), firstPlayer.getScore() + 5);
            if (recordFlag) {
                System.out.println("findwinner2");

                gameManager.saveGame();
            }
        } else if (winner == -2) {
            disableButtons();
            winnerFXMLBase.video = "/assets/images/winnerVideo.mp4";
            winnerFXMLBase.message = "Winner Winner Chicken Dinner";
            setNames(firstPlayerNameText, secondPlayerNameText);
            pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, Constants.X);
            System.out.println("winner =- 2 in find winner");
            DualModeBase.network.updateScore(firstPlayer.getUsername(), firstPlayer.getScore() + 5);
            stageVideo.getScene().setRoot(pane);
            if (recordFlag) {
                System.out.println("winnero2");

                gameManager.saveGame();
            }
            th.stop();
            gameManager.printArray();
            if (recordFlag) {
                System.out.println("findwinner-2");

                gameManager.saveGame();
            }
        } else if (winner == 0) {
            //x=o
            winnerFXMLBase.video = "/assets/images/draw.mp4";
            winnerFXMLBase.message = "No Winner, Try Play Again";
            setNames(firstPlayerNameText, secondPlayerNameText);
            System.out.println("winner =0 in find winner");
            pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, Constants.X);
            stageVideo.getScene().setRoot(pane);
            if (recordFlag) {
                System.out.println("winnero2");

                gameManager.saveGame();
            }
            th.stop();
            gameManager.printArray();
            if (recordFlag) {
                System.out.println("findwinner0");

                gameManager.saveGame();
            }
        }

    }

    public synchronized void findWinnerO() {
        Parent pane;
        int winner = GameManager.checkWinner();

        switch (winner) {
            case -2:
                disableButtons();
                winnerFXMLBase.video = "/assets/images/losser.mp4";
                winnerFXMLBase.message = "Hard Luck Next Time";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                stageVideo.getScene().setRoot(pane);
                if (recordFlag) {
                    System.out.println("winnero2");

                    gameManager.saveGame();
                }
                th.stop();
                gameManager.printArray();
                //DualModeBase.network.updateScore(secondPlayer.getUsername(), secondPlayer.getScore() + 5);
                if (recordFlag) {
                    System.out.println("winnero-2");
                    gameManager.saveGame();
                }
                break;
            case 2:
                disableButtons();
                winnerFXMLBase.video = "/assets/images/winnerVideo.mp4";
                winnerFXMLBase.message = "Winner Winner Chiken Dinner";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                DualModeBase.network.updateScore(secondPlayer.getUsername(), secondPlayer.getScore() + 5);
                stageVideo.getScene().setRoot(pane);
                if (recordFlag) {
                    System.out.println("winnero2");

                    gameManager.saveGame();
                }
                th.stop();
                gameManager.printArray();
                if (recordFlag) {
                    System.out.println("winnero2");

                    gameManager.saveGame();
                }
                break;
            case 0:
                //x=o
                winnerFXMLBase.video = "/assets/images/draw.mp4";
                winnerFXMLBase.message = "No Winner, Try Play Again";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                stageVideo.getScene().setRoot(pane);
                if (recordFlag) {
                    System.out.println("winnero2");

                    gameManager.saveGame();
                }
                th.stop();
                gameManager.printArray();
                if (recordFlag) {
                    System.out.println("winnero0");

                    gameManager.saveGame();
                }
                break;
            default:
                break;
        }

    }

    public void switchButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    if (i == 0 && j == 0) {
                        button00.setDisable(false);
                    } else if (i == 0 && j == 1) {
                        button01.setDisable(false);
                    } else if (i == 0 && j == 2) {
                        button02.setDisable(false);
                    } else if (i == 1 && j == 0) {
                        button10.setDisable(false);
                    } else if (i == 1 && j == 1) {
                        button11.setDisable(false);
                    } else if (i == 1 && j == 2) {
                        button12.setDisable(false);
                    } else if (i == 2 && j == 0) {
                        button20.setDisable(false);
                    } else if (i == 2 && j == 1) {
                        button21.setDisable(false);
                    } else if (i == 2 && j == 2) {
                        button22.setDisable(false);
                    }
                }
            }
        }
    }

    public synchronized void displayRecord(GameModel recordedGamee) {
        this.recordedGamee = recordedGamee;
        recordButton.setVisible(false);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("move" + recordedGamee.getMovesList());
        System.out.println("i=" + "" + recordedGamee.getMovesList());

        for (int i = 0; i < recordedGamee.getMovesList().size(); i++) {
            Move move = recordedGamee.getMovesList().get(i);
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        computerMove(move);
                    }
                });

                thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        thread.stop();

    }

    private void handleButton(Button button, int i, int j, Level level) {

        button.setTextFill(javafx.scene.paint.Color.valueOf(GameManager.getTurn() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));
        button.setTextFill(javafx.scene.paint.Color.valueOf(
                GameManager.getTurn() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        button.setText(GameManager.getTurn() + "");
        button.setDisable(true);
        board[i][j] = GameManager.getTurn();
        recordGameSteps(i, j, board[i][j]);

        flipTurn();
        if (gameManager.checkWinner() == 1) {
            if (level == Level.Easy || level == Level.MEDIUM || level == Level.HARD) {
                Move pcMove = gameManager.playComputer(board, level);
                if (pcMove.getRow() != -1 || pcMove.getColumn() != -1) {
                    board[pcMove.getRow()][pcMove.getColumn()] = GameManager.getTurn();
                    computerMove(pcMove);
                    recordGameSteps(pcMove.getRow(), pcMove.getColumn(), board[pcMove.getRow()][pcMove.getColumn()]);
                    flipTurn();
                }
            }
        }

    }

    private void recordGameSteps(int i, int j, char symbol) {
        System.out.println("recordGameSteps" + i + " " + j + " " + symbol);
        if (gameManager.isRecorded()) {
            gameManager.addMove(i, j, symbol);
        }
    }

    public void flipTurn() {
        recordButton.setDisable(true);
        Parent pane;
        if (GameManager.getTurn() == Constants.X) {

            GameManager.setTurn(Constants.O);

        } else {
            GameManager.setTurn(Constants.X);

        }
        int winner = GameManager.checkWinner();
        switch (winner) {
            case 2:
                disableButtons();
                winnerFXMLBase.video = "/assets/images/losser.mp4";
                winnerFXMLBase.message = "Hard Luck Next Time";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                stageVideo.getScene().setRoot(pane);
                gameManager.printArray();
                if (recordFlag) {
                    System.out.println("flipturn 2");

                    gameManager.saveGame();
                }
                break;
            case -2:
                disableButtons();
                winnerFXMLBase.video = "/assets/images/winnerVideo.mp4";
                winnerFXMLBase.message = "Winner Winner Chiken Dinner";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                stageVideo.getScene().setRoot(pane);
                gameManager.printArray();
                if (recordFlag) {
                    System.out.println("flipturn -2");

                    gameManager.saveGame();
                }
                break;
            case 0:
                //x=o
                winnerFXMLBase.video = "/assets/images/draw.mp4";
                winnerFXMLBase.message = "No Winner, Try Play Again";
                setNames(firstPlayerNameText, secondPlayerNameText);
                pane = new winnerFXMLBase(stageVideo, gameLevel, firstPlayer, secondPlayer, ' ');
                stageVideo.getScene().setRoot(pane);
                gameManager.printArray();
                if (recordFlag) {
                    System.out.println("flipturn 0");

                    gameManager.saveGame();
                }
                break;
            default:
                break;
        }
    }

    private void setNames(Text firstPlayerName, Text secondPlayerName) {
        firstPlayer.setUsername(firstPlayerName.getText());
        secondPlayer.setUsername(secondPlayerName.getText());

    }

    private void addButtonsToBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void disableButtons() {
        if (!recordFlag) {
            recordButton.setDisable(true);
        }
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

    public void computerMove(Move move) {

        if (move.getRow() == 0 && move.getColumn() == 0) {
            button00.setText(move.getSymbol() + "");
            button00.setDisable(true);
            button00.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 0 && move.getColumn() == 1) {
            button01.setText(move.getSymbol() + "");
            button01.setDisable(true);
            button01.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 0 && move.getColumn() == 2) {
            button02.setText(move.getSymbol() + "");
            button02.setDisable(true);
            button02.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 1 && move.getColumn() == 0) {
            button10.setText(move.getSymbol() + "");
            button10.setDisable(true);
            button10.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 1 && move.getColumn() == 1) {
            button11.setText(move.getSymbol() + "");
            button11.setDisable(true);
            button11.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 1 && move.getColumn() == 2) {
            button12.setText(move.getSymbol() + "");
            button12.setDisable(true);
            button12.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 2 && move.getColumn() == 0) {
            button20.setText(move.getSymbol() + "");
            button20.setDisable(true);
            button20.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        } else if (move.getRow() == 2 && move.getColumn() == 1) {
            button21.setText(move.getSymbol() + "");
            button21.setDisable(true);
            button21.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));
        } else if (move.getRow() == 2 && move.getColumn() == 2) {
            button22.setText(move.getSymbol() + "");
            button22.setDisable(true);
            button22.setTextFill(javafx.scene.paint.Color.valueOf(
                    move.getSymbol() == Constants.X ? CustomStyles.YELLOW : CustomStyles.BLUE));

        }
    }

}
