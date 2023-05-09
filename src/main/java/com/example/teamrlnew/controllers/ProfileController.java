package com.example.teamrlnew.controllers;
//LeadAuth:JacobFarrow(20007972)
import com.example.teamrlnew.*;
import com.example.teamrlnew.components.FileComponent;
import com.example.teamrlnew.components.ReadComponent;
import com.example.teamrlnew.components.ScreenComponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static com.example.teamrlnew.HelloApplication.*;

//@TODO: admin/super profiles/overlays
public class ProfileController {
    //Auth:JacobFarrow(20007972)
    @FXML
    private ImageView profileBGImageView;
    @FXML
    private AnchorPane profileHeaderAnchorPane;
    @FXML
    private Text profileTitleText;
    @FXML
    private Button homeBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private TableView<ActivityBrief> profileTableView;
    @FXML
    private TableColumn<ActivityBrief, String> profileTableColName;
    @FXML
    private TableColumn<ActivityBrief, String> profileTableColDesc;
    @FXML
    private TableColumn<ActivityBrief, String> profileTableColTime;
    @FXML
    private TableColumn<ActivityBrief, String> profileTableColLocation;
    @FXML
    private TableColumn<ActivityBrief, String> profileTableColContact;




    @FXML
    public void initialize(){
        profileBGImageView.setFitWidth(ScreenComponent.SCREEN_WIDTH);
        profileBGImageView.setFitHeight(ScreenComponent.SCREEN_HEIGHT);

        double screenHalfWidth = ScreenComponent.SCREEN_WIDTH/2;
        double screenHalfHeight = ScreenComponent.SCREEN_HEIGHT/2;

        //@TODO: work out how to abstract the header for the controllers
        //header stuff
//        profileHeaderAnchorPane.setLayoutX(screenHalfWidth-tableHalfWidth);
        homeBtn.setAlignment(Pos.CENTER);
        homeBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(profileTitleText.getLayoutBounds().getWidth()*3.5));
        homeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToHome(actionEvent);
            }
        });
        signOutBtn.setAlignment(Pos.CENTER);
        signOutBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)+(profileTitleText.getLayoutBounds().getWidth()*3));
        signOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToLogin(actionEvent);
            }
        });
        profileTitleText.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(profileTitleText.getLayoutBounds().getWidth()/2));
        profileTableView.setPrefWidth(screenHalfWidth);
        profileTableView.setPrefHeight(ScreenComponent.SCREEN_HEIGHT/1.5);

        //sort this out
        double tableHalfWidth = profileTableView.getPrefWidth()/2;
        double tableHalfHeight = profileTableView.getPrefHeight()/2;

        profileTableView.setLayoutX(screenHalfWidth-tableHalfWidth);
        profileTableView.setLayoutY(screenHalfHeight-tableHalfHeight);

        profileTableColName.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("name"));

        profileTableColDesc.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("desc"));

        profileTableColTime.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("time"));

        profileTableColLocation.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("location"));

        profileTableColContact.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("contact"));


        //grab session user activities
        ArrayList<Activity> activityList = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);
        ArrayList<String> sessionUserActs = currentSession.getSessionUser().getMyActivities();
        ObservableList<ActivityBrief> observableActivities = FXCollections.observableArrayList();

        for(int i = 0; i<activityList.size();i++){
            for(int j =0; j< sessionUserActs.size(); j++){
                if(activityList.get(i).getName().equals(sessionUserActs.get(j))){
                    Activity match = activityList.get(i);
                    observableActivities.add(new ActivityBrief("img", match.getParsedName(), match.getDescription().get(0),new Button(), match.getTime(), match.getLocation(), match.getMainContact()));
                }
            }
        }
        profileTableView.setItems(observableActivities);
        autoResizeColumns(profileTableView);
        profileTableView.refresh();

        homeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToHome(actionEvent);
            }
        });

        //set lambda mouse event
        profileTableView.setOnMouseClicked((MouseEvent event) ->{
            if(event.getClickCount() > 1){
                System.out.println("double click detected!");
                //we have double click, redirect to single activity page
                redirectToActivity(event, profileTableView);
            }
        });
    }

}
