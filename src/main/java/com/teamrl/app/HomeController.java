package com.teamrl.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;

public class HomeController {
    @FXML
    private ScrollPane homeScrollPane;
    @FXML
    private ImageView homeBGImageView;


    @FXML
    public void initialize(){

//        homeBGImageView.setFitWidth(ScreenComponent.SCREEN_WIDTH);
//        homeBGImageView.setFitHeight(ScreenComponent.SCREEN_HEIGHT);
//        homeBGImageView.toBack();

        homeScrollPane.setMinSize(ScreenComponent.SCREEN_WIDTH/1.5, ScreenComponent.SCREEN_HEIGHT/1.5);
        homeScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        homeScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.NEVER);
        columnConstraints.setPercentWidth(100.0);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.NEVER);
        rowConstraints.setPercentHeight(100.0);

        GridPane activityGrid = new GridPane();
        activityGrid.getColumnConstraints().add(columnConstraints);
        activityGrid.getRowConstraints().add(rowConstraints);
        activityGrid.setGridLinesVisible(true);

        activityGrid.addColumn(3);

        ArrayList<Activity> activities = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);
        activityGrid.addRow(activities.size());

        for(int i =0; i<activities.size();i++){
            SingleActivityController sac = new SingleActivityController(activities.get(i).getName());
            int j = i% activityGrid.getColumnCount();
            activityGrid.add(sac, j, i);
        }

        homeScrollPane.setContent(activityGrid);


    }
}
