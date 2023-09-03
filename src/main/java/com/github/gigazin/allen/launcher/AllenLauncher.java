package com.github.gigazin.allen.launcher;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class AllenLauncher extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("launcher-view.fxml")));

        Scene scene = new Scene(root, 434, 223);
        String style = Objects.requireNonNull(this.getClass().getResource("launcher.css")).toExternalForm();
        scene.getStylesheets().add(style);

        stage.getIcons().add(new Image(String.valueOf(this.getClass().getResource("allen-icon.png"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Allen Launcher Application");
        stage.setScene(scene);

        makeDraggable(root, stage);
        stage.show();
    }

    public void makeDraggable(Parent root, Stage stage) {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}