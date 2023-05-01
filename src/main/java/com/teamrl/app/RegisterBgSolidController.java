package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RegisterBgSolidController {
    // auth:JacobFarrow(20007972)
    @FXML
    private ImageView registerBGImageView;
    @FXML
    private TextField registerForenameTextField;
    @FXML
    private TextField registerSurnameTextField;
    @FXML
    private TextField registerUOBTextField;
    @FXML //I feel like there is an email field that can do checks for valid emails?
    //@TODO: check this out, replace with emailField if real
    private TextField registerEmailTextField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private PasswordField registerRepeatPasswordField;
    @FXML
    private DatePicker registerDOBPicker;
    @FXML
    private DatePicker registerStartYearPicker;
    @FXML
    private DatePicker registerEndYearPicker;
    @FXML
    private CheckBox termsConditionsCheckbox;

    @FXML
    public void initialize(){
        //get screen sizes
        double h = Screen.getPrimary().getVisualBounds().getHeight();
        double w = Screen.getPrimary().getVisualBounds().getWidth();
        //force bg image to screen size

        registerBGImageView.setFitHeight(h);
        registerBGImageView.setFitWidth(w);



    }

    //@TODO: add the cancel button back to the screen
    //@TODO: add in redirect to login screen
    public void onCancelButtonClick(ActionEvent actionEvent) {
    }

    @FXML
    public void onRegisterButtonClick(ActionEvent actionEvent) {
        //check for empty fields
        if(!emptyFields()){
            //create new user (info)
            //add to db
                //save to file
            //tfa/tpa?
            //redirect to login page?
            //auto-login?
                //redirect to home page?

            //grab all the info
            //@TODO: some sort of check for valid characters, etc.


            String fname = registerForenameTextField.getText();
            String sname = registerSurnameTextField.getText();
            String ubnum = registerUOBTextField.getText();
            String mail = registerEmailTextField.getText();
            String pass1 = registerPasswordField.getText();
            String dob = registerDOBPicker.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
            String sy = registerStartYearPicker.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);
            String ey = registerEndYearPicker.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);

            //make new userinfocomp
            //@TODO: a bunch of checks for validity, staff for super, etc.
            UserInfoComponent uic = new UserInfoComponent(fname, sname, ubnum, mail, pass1, dob, sy, ey);
            //instantiate new user
            User u = new User(uic);

            //get the list of users
            //@TODO: maybe look at moving this out somehow? WriteComponent.addNewUser(u) or something??
            ArrayList<User> users = ReadComponent.readUserDataFromJSON("Users.txt", "main");
            users.add(u);

            //@GOTO: BeanComparator
            //sort the list using the bean comp
            users.sort(new BeanComparator("surname"));

            //write the users back to the file
            WriteComponent.writeUserDataToJSONPretty("Users.txt", "main", users);

            //@DEBUG: check if the user is in the list
            ArrayList<User> newUsers = ReadComponent.readUserDataFromJSON("Users.txt", "main");

            for(int i = 0; i< newUsers.size(); i++){
                System.out.println(newUsers.get(i).toString());
            }



        }




    }

    private boolean emptyFields(){
        if(registerForenameTextField == null || registerForenameTextField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(registerSurnameTextField == null || registerSurnameTextField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(registerUOBTextField == null || registerUOBTextField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(registerEmailTextField == null || registerEmailTextField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(registerPasswordField == null || registerPasswordField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(registerRepeatPasswordField == null || registerRepeatPasswordField.getText().isEmpty()){
            //error toast (or equivalent)
            return true;
        }
        else if(!registerPasswordField.getText().equals(registerRepeatPasswordField.getText())){
            //error toast (or equivalent)
            return true;
        }

        //@TODO: look into picker.isEmpty() equivalent, check for valid bday
        //we can substring the date to check the year is valid
        else if(registerDOBPicker == null){
            //error toast (or equivalent)
            return true;
        }
        //@TODO: look into picker.isEmpty() equivalent, check for valid Start year
        else if(registerStartYearPicker == null){
            //error toast (or equivalent)
            return true;
        }
        //we don't need to check the end year (staff) so we skip that one
        else if(termsConditionsCheckbox == null || !termsConditionsCheckbox.isSelected()){
            //error toast (or equivalent)
            return true;
        }
        return false;
    }

    //@TODO: look into toast/notification classes
    //bad example
    private void toast(String error){
        //print an error msg to user
        //use error str to dynamically allocate their error
    }
}
