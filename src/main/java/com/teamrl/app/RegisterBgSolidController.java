package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.teamrl.app.HelloApplication.currentSession;

//@TODO: needs a link to the login page
//@TODO: add exit button?
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
    //@TODO: look into this
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
            String ey = "";
            if(registerEndYearPicker.getValue() != null){
                ey = registerEndYearPicker.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);
            }



            //make new userinfocomp
            //@TODO: a bunch of checks for validity, staff for super, etc.
            UserInfoComponent uic = new UserInfoComponent(fname, sname, ubnum, mail, pass1, dob, sy, ey);
            //instantiate new user
            User u = new User(uic);

            //get the list of users
            //@TODO: maybe look at moving this section out somehow? WriteComponent.addNewUser(u) or something??
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

            //we have user so redirect to home
            try{
                Node node=(Node) actionEvent.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //@TODO: move this out into HelloApplication? --> static func for redirecting scenes?
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-2.fxml"));
                HomeController hc = new HomeController();

                /**track the current user**/
                currentSession.setSessionUser(u);

                fxmlLoader.setController(hc);
                stage.setScene(new Scene(fxmlLoader.load()));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
    //@TODO: research JavaFX toast(or equivalent)
    //@TODO: replace println with toast(or JavaFX equivalent)

    private boolean emptyFields(){
        if(registerForenameTextField == null){
            System.out.println("registerForenameTextField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerForenameTextField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("Forename is empty!");
            return true;
        }
        else if(registerSurnameTextField == null){
            System.out.println("registerSurnameTextField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerSurnameTextField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("Surname is empty!");
            return true;
        }
        else if(registerUOBTextField == null){
            System.out.println("registerUOBTextField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerUOBTextField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("UoB Number is empty!");
            return true;
        }
        else if(registerEmailTextField == null){
            System.out.println("registerEmailTextField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerEmailTextField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("email is empty!");
            return true;
        }
        else if(registerPasswordField == null){
            System.out.println("registerPasswordField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerPasswordField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("password is empty!");
            return true;
        }
        else if(registerRepeatPasswordField == null){
            System.out.println("registerRepeatPasswordField is null! Contact engineer immediately!");
            return true;
        }
        else if(registerRepeatPasswordField.getText().isEmpty()){
            //error toast (or equivalent)
            System.out.println("repeat password is empty!");
            return true;
        }
        else if(!registerPasswordField.getText().equals(registerRepeatPasswordField.getText())){
            //passwords don't match
            //error toast (or equivalent)
            System.out.println("passwords do not match!");
            return true;
        }

        //@TODO: look into picker.isEmpty() equivalent, check for valid bday
        //we can substring the date to check the year is valid, etc.
        else if(registerDOBPicker == null){
            System.out.println("registerDOBPicker is null! Contact engineer immediately!");
            return true;
        }
        //@TODO: look into picker.isEmpty() equivalent, check for valid Start year
        //we can substring the date to check the year is valid, etc.

        else if(registerStartYearPicker == null){
            System.out.println("registerStartYearPicker is null! Contact engineer immediately!");
            return true;
        }
        //we don't need to check the end year is empty (staff) so we skip that one
        else if(registerEndYearPicker == null){
            System.out.println("registerEndYearPicker is null! Contact engineer immediately!");
            return true;
        }
        else if(termsConditionsCheckbox == null){
            System.out.println("termsConditionsCheckbox is null! Contact engineer immediately!");
            return true;
        }
        else if(!termsConditionsCheckbox.isSelected()){
            System.out.println("Please read and check the terms and conditions!");
            return true;
        }
        return false;
    }

    //bad example
    private void toast(String error){
        //print an error msg to user
        //use error str to dynamically allocate their error
    }
}
