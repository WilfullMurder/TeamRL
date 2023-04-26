package com.teamrl.app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;

import java.io.File;


public class LoginController {

    @FXML
    private TextField titleText;
    @FXML
    private Label loginFormTitle;
    @FXML
    private VBox backgroundImageView;
    @FXML
    private VBox formBox;
    @FXML
    public void initialize(){
        titleText.setEditable(false);
        titleText.setFocusTraversable(false);
        titleText.setMouseTransparent(true);

        double h = Screen.getPrimary().getVisualBounds().getHeight();
        double w = Screen.getPrimary().getVisualBounds().getWidth();

        formBox.setLayoutX(h/2);

        BackgroundSize bgs = new BackgroundSize(w,h,false,false,true, true);

        File f = new File("src/main/resources/com/teamrl/app/img/logo.png");

        Image i = new Image(f.toURI().toString());
        Background bg = new Background(new BackgroundImage(i,
                BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, bgs));

        backgroundImageView.setBackground(bg);

    }
    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
