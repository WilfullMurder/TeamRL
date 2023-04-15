package com.example.teamRl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        User u = new User();
        Admin a = new Admin();
        Activity soc = new Activity();
        a.setMembers(DG.generateUserData(30));
        a.setMyActivity(soc);
        System.out.println(a.toString());
        u.setAdmin(a);
//        WriteComponent WC = new WriteComponent();

//        WC.writeUserDataToJSONPretty("Users.txt", "main", DG.generateUserData(30));
//        ReadComponent RC = new ReadComponent();
//        ArrayList<User> users = RC.readUserDataFromFile("Users.txt", "main");
//
//        for(int i=0; i<users.size(); i++)
//        {
//            System.out.println(users.get(i).toJSON());
//        }
       //launch();
    }
}