package com.teamrl.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SingleActivityController extends SplitPane {

    @FXML
    private VBox singleActivityVBox;
    @FXML
    private HBox singleActivityHBox1;
    @FXML
    private HBox singleActivityHBox2;
    @FXML
    private HBox singleActivityHBox3;
    @FXML
    private HBox singleActivityHBox4;
    @FXML
    private HBox singleActivityHBox5;
    @FXML
    private HBox singleActivityHBox6;
    @FXML
    private Label nameTextLabel;
    @FXML
    private Label descTextLabel;
    @FXML
    private Label contactTextLabel;
    @FXML
    private Label timeTextLabel;
    @FXML
    private Label locTextLabel;
    @FXML
    private Label linkTextLabel;
    @FXML
    private ImageView singleActivityImageView;
    @FXML
    private AnchorPane singleActivityImagePane;

    private String name;


    public SingleActivityController(String name){
        this.name=name;
    }


    @FXML
    public void initialize(){
        double imageMinHeight = singleActivityImagePane.getHeight();
        double imageMinWidth = singleActivityImagePane.getWidth();

        singleActivityImageView.setFitHeight(imageMinHeight);
        singleActivityImageView.setFitWidth(imageMinWidth);

        //generate activity data
        ArrayList<Activity> activities = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);

        //find matching activity
        for (int i =0; i<activities.size(); i++){
            if(activities.get(i).getName().equals(this.name)){

                //set simple strings
                nameTextLabel.setText(this.name);
                contactTextLabel.setText(activities.get(i).getMainContact());
                locTextLabel.setText(activities.get(i).getLocation());
                timeTextLabel.setText(activities.get(i).getTime());

                //set description string
                String descString = "";
                ArrayList<String> desc = activities.get(i).getDescription();
                for(int j = 0; j < desc.size(); j++){
                    descString += desc.get(i);
                }
                descTextLabel.setText(descString);

                //set link text string
                String linkString = "";
                ArrayList<String> links = activities.get(i).getExternalLinks();
                for(int j =0; j< links.size();j++){
                    linkString += links.get(i);
                }
                linkTextLabel.setText(linkString);
            }
        }


    }


    public void onMouseClick(MouseEvent mouseEvent) {
    }




}
