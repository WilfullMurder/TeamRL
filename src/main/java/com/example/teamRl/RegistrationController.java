package com.example.teamRl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class RegistrationController {
    @FXML
    private TextField forenameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField uobField;
    @FXML
    private Button submitBtn;


    @FXML
    public void register(ActionEvent event)
    {
        Window owner = submitBtn.getScene().getWindow();


        System.out.println(forenameField.getText());
        System.out.println(surnameField.getText());
        System.out.println(uobField.getText());
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());

        if(forenameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your forename");
            return;
        }
        if(surnameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your surname");
            return;
        }
        if(uobField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your uob number");
            return;
        }
        if(emailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
            return;
        }


        String fullname = forenameField.getText() + " " + surnameField.getText();
        //writing the info to file/db

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful! ", "Welcome" + fullname);

    }


    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String context)
    {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(context);
        alert.initOwner(owner);
        alert.show();
    }




}
