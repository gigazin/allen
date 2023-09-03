package com.github.gigazin.allen.launcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.github.gigazin.allen.core.Allen;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AllenLauncherController {

    @FXML
    private AnchorPane applicationRootBackground;
    @FXML
    private AnchorPane windowBorder;
    @FXML
    private Label applicationTitle;
    @FXML
    private Button minimizeButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button launchButton;
    @FXML
    private Label loginStatus;

    private boolean isLaunched = false;

    @FXML
    protected void onLaunchButtonClick() {
        Allen.action("launch");
        loginStatus.setText("Allen has logged in! :)");
        isLaunched = true;
    }

    @FXML
    protected void onCloseButtonClick(ActionEvent e) {
        Stage stage;
        stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        if (isLaunched) Allen.action("shutdown");
        stage.close();
    }

    @FXML
    protected void onMinimizeButtonClick(ActionEvent e) {
        Stage stage;
        stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}