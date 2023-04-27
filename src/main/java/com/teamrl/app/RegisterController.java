package com.teamrl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class RegisterController {

    @FXML
    private ImageView registerBGImageView;
    @FXML
    private TextField titleText;
    @FXML
    public void initialize(){

        double h = Screen.getPrimary().getVisualBounds().getHeight();
        double w = Screen.getPrimary().getVisualBounds().getWidth();
        registerBGImageView.setFitHeight(h);
        registerBGImageView.setFitWidth(w);




    }

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
