package com.teamrl.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class RegisterRptController {
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

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
    }
}
