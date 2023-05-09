package com.example.teamrl.controllers;
//lead auth:JacobFarrow(20007972)

import com.example.teamrl.Activity;
import com.example.teamrl.HelloApplication;
import com.example.teamrl.User;
import com.example.teamrl.components.FileComponent;
import com.example.teamrl.components.ReadComponent;
import com.example.teamrl.components.ScreenComponent;
import com.example.teamrl.components.WriteComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.teamrl.HelloApplication.*;

public class SingleActivityController extends SplitPane {
//auth:JacobFarrow(20007972)

    @FXML
    private BorderPane singleActivityBorderPane;
    @FXML
    private AnchorPane homeHeaderAnchorPane;
    @FXML
    private SplitPane singleActivitySplitPane;
    @FXML
    private SplitPane singleActivitySplitPaneInner;
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
    private Text headerTitleText;
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
    @FXML
    private Button profileBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private Button homeBtn;



    //@TODO: pass the signed in user so we can check if they are already a member, hide the joinbtn, show leavebtn?
    private Activity myActivity;

    public SingleActivityController(){}

    public SingleActivityController(Activity a){
        this.myActivity=a;
    }


    //@TODO: sort out header
    //@TODO: home button, signout button, exit button?
    @FXML
    public void initialize(){
        //@TODO: move this out into a background/style component?
        /**We could have a bunch of different backgrounds/colour schemes and load them in statically from the resource folder?**/
        BackgroundSize bgs = new BackgroundSize(ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT, false, false, false, false);
        Background bg = new Background(new BackgroundImage(new Image(HelloApplication.class.getResource("img/background-solid.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs));
        singleActivityBorderPane.setBackground(bg);

        double screenHalfWidth = ScreenComponent.SCREEN_WIDTH/2;
        double screenHalfHeight = ScreenComponent.SCREEN_HEIGHT/2;

        singleActivityBorderPane.setMinSize(ScreenComponent.SCREEN_WIDTH,ScreenComponent.SCREEN_HEIGHT);
        singleActivityBorderPane.setPrefWidth(ScreenComponent.SCREEN_WIDTH);
        singleActivityBorderPane.setPrefHeight(ScreenComponent.SCREEN_HEIGHT);

        singleActivitySplitPane.setPrefWidth(screenHalfWidth);
        singleActivitySplitPane.setPrefHeight(singleActivityBorderPane.getPrefHeight()/1.5);
        singleActivitySplitPane.setLayoutX((screenHalfWidth)-(singleActivitySplitPane.getPrefWidth()/2));
        singleActivitySplitPane.setLayoutY((screenHalfHeight)-(singleActivitySplitPane.getPrefHeight()/2));

        double tableHalfWidth = singleActivitySplitPane.getPrefWidth()/2;

        headerTitleText.setText(myActivity.getParsedName());
        headerTitleText.setLayoutY(0 + headerTitleText.getLayoutBounds().getHeight()*1.2);
        headerTitleText.setLayoutX((screenHalfWidth)-(headerTitleText.getLayoutBounds().getWidth()/2));

        homeHeaderAnchorPane.setLayoutX(screenHalfWidth-tableHalfWidth);
        homeHeaderAnchorPane.setPrefHeight(headerTitleText.getLayoutBounds().getHeight());

        profileBtn.setAlignment(Pos.CENTER);
        profileBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(headerTitleText.getLayoutBounds().getWidth()+profileBtn.getWidth()));

        signOutBtn.setAlignment(Pos.CENTER);
        signOutBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)+(headerTitleText.getLayoutBounds().getWidth()+signOutBtn.getWidth()));

        homeBtn.setAlignment(Pos.CENTER);
        homeBtn.setLayoutX(headerTitleText.getLayoutX()+(headerTitleText.getLayoutBounds().getWidth()/2));
        homeBtn.setLayoutY(headerTitleText.getLayoutY()+25.0);

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

        setButtonText();

        homeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToHome(actionEvent);
            }
        });
        profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToProfile(actionEvent);
            }
        });
        signOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToLogin(actionEvent);
            }
        });

    }

    //@TODO: add current user to activity
    public void joinActivity(String act){
        //add activity name to users activity list
        User u = currentSession.getSessionUser();
        if(u != null){
            u.addActivity(act);
            currentSession.setSessionUser(u);
            WriteComponent.updateUser(u.getMyInfo(), ReadComponent.readUserDataFromJSON(FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER));
            setButtonText();
        }
    }

    //@TODO: remove current user from activity
    public void leaveActivity(String act){
        User u = currentSession.getSessionUser();
        if(u != null){
            u.removeActivity(act);
            currentSession.setSessionUser(u);
            WriteComponent.updateUser(u.getMyInfo(), ReadComponent.readUserDataFromJSON(FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER));
            setButtonText();
        }
    }


    public Activity getMyActivity(){
        return this.myActivity;
    }

    public void setMyActivity(Activity myActivity) {
        this.myActivity = myActivity;
    }

    private void setButtonText(){
        ArrayList<String> userActs = currentSession.getSessionUser().getMyActivities();
        if(userActs != null && userActs.size() > 0){
            for(String s : userActs){
                if(s.equals(myActivity.getName())){
                    joinBtn.setText("Leave");
                    break;
                }
                else{
                    joinBtn.setText("Join");
                }
            }
        }
        else {
            joinBtn.setText("Join");
        }

        /**we should probably check if the current user is not already a member and deal with that**/
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