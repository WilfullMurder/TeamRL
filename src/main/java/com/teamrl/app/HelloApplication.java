package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.components.DataGenerator;
import com.teamrl.app.components.ReadComponent;
import com.teamrl.app.components.WriteComponent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        DataGenerator DG = new DataGenerator();
        ArrayList<Admin> admins = ReadComponent.readAdminDataFromJSON("Admins.txt", "main");
        for(int i =0; i< admins.size(); i++){
            System.out.println(admins.get(i).toString());
        }

//        ArrayList<String> users = new ArrayList<>();
//        for(int i =0; i< 10; i++){
//            users.add("foobar");
//            admins.add(new Admin("name", "activity", "role", users, null));
//        }

//       WriteComponent.writeAdminDataToJSONPretty("Admins.txt", "main", admins);
//        WriteComponent.writeUserDataToJSONPretty("Users.txt", "main", users);
    }
}