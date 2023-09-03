package com.github.gigazin.allen.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class AllenLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AllenLauncher.class.getResource("launcher-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 434, 223);
        String style = Objects.requireNonNull(this.getClass().getResource("launcher.css")).toExternalForm();
        scene.getStylesheets().add(style);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Allen Launcher Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}