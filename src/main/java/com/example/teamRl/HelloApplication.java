package com.example.teamRl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registrationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DataGenerator DG = new DataGenerator();
        ArrayList<User> users = ReadComponent.readUserDataFromJSON("Users.txt", "main");

        for(int i = 0; i< users.size();i++){System.out.println(users.get(i).toJSON());}
        System.out.println(users.size());

    }
}