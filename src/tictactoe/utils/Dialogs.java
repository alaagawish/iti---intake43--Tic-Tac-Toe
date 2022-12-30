package tictactoe.utils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Dialogs {

    public static JFXDialog createBlurSimpleDialog(String text, StackPane stackpane) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.TOP);

        dialogLayout.setStyle("-fx-background-color: rgba(59,178,184,0.8 ); -fx-background-radius: 10 10 10 10 ;");

        Label dialogLabel = new Label(text);
        dialogLabel.setFont(new Font("Comic Sans MS Bold", 20.0));
        dialogLayout.setBody(dialogLabel);

        return dialog;
    }

    public static JFXDialog createBlurRequestingDialog(String text, StackPane stackpane) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.TOP);
        dialog.setOverlayClose(false);

        dialogLayout.setStyle("-fx-background-color: rgba(59,178,184,0.8 ); -fx-background-radius: 10;");

        dialogLayout.setPadding(new Insets(10));

        HBox actionParent = new HBox();

        JFXButton acceptButton = new JFXButton("Accept");
        JFXButton rejectButton = new JFXButton("Reject");

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