package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.teamrl.app.HelloApplication.currentSession;

public class SingleActivityController extends SplitPane {
//auth:JacobFarrow(20007972)

    @FXML
    private AnchorPane singleActivityAnchorPane;
    @FXML
    private SplitPane singleActivitySplitPane;
    @FXML
    private VBox singleActivityVBox;
    @FXML
    private HBox singleActivityHBoxName;
    @FXML
    private HBox singleActivityHBoxDesc;
    @FXML
    private HBox singleActivityHBoxContact;
    @FXML
    private HBox singleActivityHBoxTime;
    @FXML
    private HBox singleActivityHBoxLoc;
    @FXML
    private HBox singleActivityHBoxLinks;
    @FXML
    private Label nameTextLabel;
    @FXML
    private Text descTextLabel;
    @FXML
    private Text contactTextLabel;
    @FXML
    private Label timeTextLabel;
    @FXML
    private Label locTextLabel;
    @FXML
    private Label linkTextLabel;
    @FXML
    private Label cpsTextLabel;
    @FXML
    private Label cpyTextLabel;
    @FXML
    private ImageView singleActivityImageView;
    @FXML
    private AnchorPane singleActivityImagePane;
    @FXML
    private Button joinBtn;

    //@TODO: pass the signed in user so we can check if they are already a member, hide the joinbtn, show leavebtn?
    private Activity myActivity;

    public SingleActivityController(){}


    //@TODO: sort out header
        //@TODO: home button, signout button, exit button?
    @FXML
    public void initialize(){
        //@TODO: move this out into a background/style component?
        /**We could have a bunch of different backgrounds/colour schemes and load them in statically from the resource folder?**/
        BackgroundSize bgs = new BackgroundSize(ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT, false, false, false, false);
        Background bg = new Background(new BackgroundImage(new Image(getClass().getResource("img/background-solid.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs));
        singleActivityAnchorPane.setBackground(bg);

        singleActivityAnchorPane.setMinSize(ScreenComponent.SCREEN_WIDTH,ScreenComponent.SCREEN_HEIGHT);
        singleActivityAnchorPane.setPrefWidth(ScreenComponent.SCREEN_WIDTH);
        singleActivityAnchorPane.setPrefHeight(ScreenComponent.SCREEN_HEIGHT);

        singleActivitySplitPane.setPrefWidth((singleActivityAnchorPane.getPrefWidth()/2));
        singleActivitySplitPane.setPrefHeight(singleActivityAnchorPane.getPrefHeight()/1.5);
        singleActivitySplitPane.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(singleActivitySplitPane.getPrefWidth()/2));
        singleActivitySplitPane.setLayoutY((ScreenComponent.SCREEN_HEIGHT/2)-(singleActivitySplitPane.getPrefHeight()/2));

        if(myActivity != null) {
            nameTextLabel.setText(myActivity.getName());
            contactTextLabel.setText(myActivity.getMainContact());
            cpsTextLabel.setText(myActivity.getCostPerSemester());
            cpyTextLabel.setText(myActivity.getCostPerYear());

            if(myActivity.getTime() == null){timeTextLabel.setText("tbd");}
            else { timeTextLabel.setText(myActivity.getTime());}

            locTextLabel.setText(myActivity.getLocation());
            String d = "";
            for(int i =0; i< myActivity.getDescription().size(); i++){
                d+=myActivity.getDescription().get(i);
            }
            descTextLabel.setText(d);

            //@TODO: create working links for external redirection
            d="link.com";
            if(myActivity.getExternalLinks() != null) {
                for (int i = 0; i < myActivity.getExternalLinks().size(); i++) {
                    d += myActivity.getExternalLinks().get(i);
                }
            }
            linkTextLabel.setText(d);

            if(currentSession.getSessionUser() == null){
                System.out.println("session user is null bro");
            }
            else{
                ArrayList<String> userActs = currentSession.getSessionUser().getMyActivities();
                if(userActs != null && userActs.size() > 0){
                    for(String s : userActs){
                        if(s.equals(myActivity.getName())){
                            joinBtn.setText("Leave");
                        }
                    }
                }
                else{
                    joinBtn.setText("Join");
                }
            }


            /**we should probably check if the current user is not already a member and deal with that**/
            //@TODO:work out how to add on mouse clicked --> (use btn onPress or smt?)

            switch(joinBtn.getText()){
                case "Join":
                default:
                    joinBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            joinActivity(myActivity.getName());
                        }
                    });
                    break;
                case "Leave":
                    joinBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            leaveActivity(myActivity.getName());
                        }
                    });
                    break;
            }

        }
    }

//@TODO: add current user to activity
    public void joinActivity(String act){
        //add activity name to users activity list
        User u = currentSession.getSessionUser();
        if(u != null){
            u.addActivity(act);
            WriteComponent.updateUser(u.getMyInfo(), ReadComponent.readUserDataFromJSON(FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER));
        }
    }

    //@TODO: remove current user from activity
    public void leaveActivity(String act){
        User u = currentSession.getSessionUser();
        if(u != null){
            u.removeActivity(act);
            WriteComponent.updateUser(u.getMyInfo(), ReadComponent.readUserDataFromJSON(FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER));
        }
    }


    public Activity getMyActivity(){
        return this.myActivity;
    }

    public void setMyActivity(Activity myActivity) {
        this.myActivity = myActivity;
    }
}
