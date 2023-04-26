package com.teamrl.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public class RegisterController {

    @FXML
    private ImageView backgroundImageView;
    @FXML
    private TextField titleText;
    @FXML
    public void initialize(){

        double h = Screen.getPrimary().getVisualBounds().getHeight();
        double w = Screen.getPrimary().getVisualBounds().getWidth();
        backgroundImageView.setFitHeight(h);
        backgroundImageView.setFitWidth(w);




    }

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
