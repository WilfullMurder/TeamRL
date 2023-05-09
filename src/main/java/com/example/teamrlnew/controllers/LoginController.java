package com.example.teamrlnew.controllers;
//lead auth:JacobFarrow(20007972)
import com.example.teamrlnew.*;
import com.example.teamrlnew.components.FileComponent;
import com.example.teamrlnew.components.ReadComponent;
import com.example.teamrlnew.components.ScreenComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import static com.example.teamrlnew.HelloApplication.*;

//@TODO: add exit button?
//@TODO: forgot password
//@TODO: sort remember me
//@TODO: sort t's & c's
public class LoginController {
    //auth:JacobFarrow(20007972)
    @FXML
    private ImageView loginBGImageView;
    @FXML //I feel like there is an email field that can do checks for valid emails?
    private TextField loginEmailTextField;
    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Label invalidLoginCredentials;

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

            //we need look-up by email to check pass --> we could look up by UoB?
            User u = ReadComponent.findSingleUser(mail, FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER);
            if(u != null){
                if(pass.equals(u.getPassword())){
                    //we have user so redirect to home
                    currentSession.setSessionUser(u);
                    redirectToHome(actionEvent);
                }
            }
        }
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        redirectToRegistration(actionEvent);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
        exitApp();
    }


    private boolean emptyField(){
        if(loginEmailTextField == null){
            errorMSG = "null mail text field, contact engineer immediately!";
            return true;
        }
        else if(loginEmailTextField.getText().isEmpty()){
            invalidLoginCredentials.setText("empty email field!");
            return true;
        }
        else if(loginPasswordField == null){
            errorMSG = "null password field, contact engineer immediately!";
            return true;
        }
        else if(loginPasswordField.getText().isEmpty()){
            invalidLoginCredentials.setText("empty password field!");
            return true;
        }
        return false;
    }


}