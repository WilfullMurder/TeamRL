package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.components.DataGenerator;
import com.teamrl.app.components.ReadComponent;
import com.teamrl.app.components.WriteComponent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        double width = Screen.getPrimary().getVisualBounds().getWidth();
        double height = Screen.getPrimary().getVisualBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
//        launch();
        ArrayList<Activity> activities = ReadComponent.readActivityDataFromJSON("activities.txt", "main");

        for(int i=0; i< activities.size(); i++){
            System.out.println(activities.get(i).toString());
        }
    }
}