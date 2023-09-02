package com.github.gigazin.allen.launcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import com.github.gigazin.allen.core.Allen;

public class AllenLauncherController {

    @FXML
    private Label allenLauncherText;
    @FXML
    private Button launchButton;
    @FXML
    private Label loginStatus;

    @FXML
    protected void onLaunchButtonClick() {
        loginStatus.setText("Allen is logging in...");
        Allen.launch();
        loginStatus.setText("Allen has logged in!");
    }
}