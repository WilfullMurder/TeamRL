package com.teamrl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;


public class LoginController {
    @FXML
    private ImageView loginBGImageView;
    @FXML //I feel like there is an email field that can do checks for valid emails?
    private TextField loginEmailTextField;
    @FXML
    private PasswordField loginPasswordField;

    private String errorMSG;

    @FXML
    public void initialize(){
         //force bg image to screen size
        loginBGImageView.setFitHeight(ScreenComponent.SCREEN_HEIGHT);
        loginBGImageView.setFitWidth(ScreenComponent.SCREEN_WIDTH);
    }
    public void onLoginButtonClick(ActionEvent actionEvent) {


        if(!emptyField()){
            //grab the data
            String mail = loginEmailTextField.getText();
            String pass = loginPasswordField.getText();

            //we need look-up by email to check pass
            User u = ReadComponent.findSingleUser(mail, FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER);
            if(u != null){
                if(pass.equals(u.getPassword())){
                    //we have user so login
                    //@TODO: keep the user in some sort of session tracker for the profile page?
                    Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                        stage.setScene(new Scene(fxmlLoader.load(), ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-bg-solid.fxml"));
            stage.setScene(new Scene(fxmlLoader.load(), ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onCancelButtonClick(ActionEvent actionEvent) {
    }


    private boolean emptyField(){
        if(loginEmailTextField == null){
            errorMSG = "null mail text field, contact engineer immediately!";
            return true;
        }
        else if(loginEmailTextField.getText().isEmpty()){
            errorMSG = "empty email field!";
            return true;
        }
        else if(loginPasswordField == null){
            errorMSG = "null password field, contact engineer immediately!";
            return true;
        }
        else if(loginPasswordField.getText().isEmpty()){
            errorMSG = "empty password field!";
            return true;
        }
        return false;
    }


}
