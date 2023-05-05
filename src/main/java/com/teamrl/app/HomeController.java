package com.teamrl.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class HomeController {
    @FXML
    private ScrollPane homeScrollPane;

    @FXML
    private TableView<ActivityBrief> activityTableView;
    @FXML
    private TableColumn<ActivityBrief, ImageView> tblActivityIMGCol;
    @FXML
    private TableColumn<ActivityBrief, String> tblActivityNameCol;
    @FXML
    private TableColumn<ActivityBrief, String> tblActivityDescCol;
    @FXML
    private TableColumn<ActivityBrief, Button> tblActivityJoinCol;


    @FXML
    public void initialize(){

        //grab the activity info
        ArrayList<Activity> aList = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);


        ObservableList<ActivityBrief> activities = FXCollections.observableArrayList();

        for(int i = 0; i<aList.size();i++){

            activities.add(new ActivityBrief("img-uri", aList.get(i).getName(), aList.get(i).getDescription().get(0)));
        }







    }



    class ActivityBrief{
        private String img;
        private String name;
        private String desc;
        private Button joinBtn;

        public ActivityBrief(String i, String n, String d){
            this.img=i;
            this.name=n;
            this.desc=d;
            this.joinBtn = new Button("Join");

        }

    }


}
