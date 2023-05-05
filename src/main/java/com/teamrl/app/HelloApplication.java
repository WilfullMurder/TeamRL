package com.teamrl.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT);

        //not sure if we need this
//        //hide the window bar
//        stage.resizableProperty().setValue(false);
//        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("UConnect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    //@TODO: checks on stuff. Are we already in the scene, etc.
    private Scene getScene(String fxmlPath, SingleActivityController controller){
        FXMLLoader loader;
        Parent root;
        Scene scene;
        try{
            loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(controller);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene = new Scene(root);
        return scene;
    }



}
//Comment your name under this here if you familiarized yourself with the codebase the last time Jacob asked:
