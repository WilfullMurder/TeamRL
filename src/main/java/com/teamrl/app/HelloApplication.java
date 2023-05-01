package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
//@TODO: still need page for admin profile (edit activity, drop/ban user)
//@TODO: still need page for super profile (add/drop activity, add/drop admin)
    //an easy way to do these is either as clones of the user profile page with additional buttons
    //a good way to do these would be as overlays on the user profile only visible to admin/super
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT);

//        //hide the window bar --> not sure if we want/need this
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