package tictactoe.utils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.constants.Constants;
import tictactoe.constants.Level;
import tictactoe.models.Player;
import tictactoe.screens.dualmode.DualModeBase;
import tictactoe.screens.dualmode.OnlineListBase;
import tictactoe.screens.game.GameBase;

public class Dialogs {

    public static JFXDialog createBlurSimpleDialog(String text, StackPane stackpane, String style) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.TOP);

        dialogLayout.setStyle(style);

        Label dialogLabel = new Label(text);
        dialogLabel.setStyle("-fx-color: rgb(255,255,255 )");
        dialogLabel.setFont(new Font("Comic Sans MS Bold", 20.0));
        dialogLayout.setBody(dialogLabel);

        return dialog;
    }

    public static void showAlertDialog(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

   

    public static void invitationDialog(String title) {
        Dialog dialog = new Dialog();
        dialog.setTitle(title);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.YES);
        dialog.getDialogPane().setContent(createInvitationScene());
    }

    private static Node createInvitationScene() {
        AnchorPane anchorPane = new AnchorPane();
        Text PlayerText = new Text();
        anchorPane.setMaxHeight(USE_PREF_SIZE);
        anchorPane.setMaxWidth(USE_PREF_SIZE);
        anchorPane.setMinHeight(USE_PREF_SIZE);
        anchorPane.setMinWidth(USE_PREF_SIZE);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(666.0);
        anchorPane.setStyle("-fx-background-color: #3dc0c2; -fx-background-radius: 25;");

        PlayerText.setFill(javafx.scene.paint.Color.valueOf("#ffde59"));
        PlayerText.setLayoutX(68.0);
        PlayerText.setLayoutY(114.0);
        PlayerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        PlayerText.setStrokeWidth(0.0);
        PlayerText.setText("Player wants to play with you ");
        PlayerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        PlayerText.setWrappingWidth(561.83837890625);
        PlayerText.setFont(new Font("Comic Sans MS Bold", 35.0));

        anchorPane.getChildren().add(PlayerText);
        return anchorPane;
    }

    public static JFXDialog createBlurRequestingDialog(String text, StackPane stackpane, Stage stage, Player playerTwo) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.TOP);
        dialog.setOverlayClose(false);

        dialogLayout.setStyle("-fx-background-color: rgba(59,178,184,0.8 ); -fx-background-radius: 10;");

        dialogLayout.setPadding(new Insets(10));

        HBox actionParent = new HBox();

        JFXButton acceptButton = new JFXButton("Accept");
        JFXButton rejectButton = new JFXButton("Reject");
        rejectButton.setOnAction(e -> {
            System.out.println("the second player rejected the game");
            DualModeBase.network.responseGame(false);
            OnlineListBase.dialog2.close();
        });

        acceptButton.setOnAction(e -> {
            System.out.println("the second player accepted the game");
            Player playerOne = DualModeBase.network.responseGame(true);
            OnlineListBase.dialog2.close();
            Parent pane = new GameBase(stage, Level.ONLINE, playerOne, playerTwo,Constants.O);
            stage.getScene().setRoot(pane);
        });
        actionParent.setSpacing(20);

        acceptButton.setPadding(new Insets(10));
        rejectButton.setPadding(new Insets(10));

        acceptButton.setFont(new Font("Comic Sans MS Bold", 14.0));
        acceptButton.setStyle("-fx-text-fill:WHITE; -fx-background-color: rgba(130,213,49,1.0); -fx-background-radius: 10;");

        rejectButton.setFont(new Font("Comic Sans MS Bold", 14.0));
        rejectButton.setStyle("-fx-text-fill:WHITE;-fx-background-color: rgba(242,12,12,1.0); -fx-background-radius: 10;");

        acceptButton.setButtonType(JFXButton.ButtonType.RAISED);
        rejectButton.setButtonType(JFXButton.ButtonType.RAISED);

        dialogLayout.getChildren().addAll(actionParent);
        actionParent.getChildren().addAll(acceptButton, rejectButton);
        actionParent.setAlignment(Pos.BOTTOM_CENTER);

        Label dialogLabel = new Label(text);

        dialogLabel.setFont(new Font("Comic Sans MS Bold", 20.0));
        dialogLabel.setStyle("-fx-text-fill:WHITE;");

        dialogLayout.setBody(dialogLabel);

        return dialog;
    }

}
