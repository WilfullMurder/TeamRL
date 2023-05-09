package com.example.teamrlnew.controllers;
//lead auth:JacobFarrow(20007972)

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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static com.example.teamrlnew.HelloApplication.*;

public class HomeController {
    //auth:JacobFarrow(20007972)
    @FXML
    private BorderPane parentPane;
    @FXML
    //@TODO: add an exit button?
    private AnchorPane homeHeaderAnchorPane;
    @FXML
    private Button profileBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private Text homeTitleText;
    @FXML
    private TableView<ActivityBrief> activityTableView;

    @FXML
    //@TODO: sort this out so it's an ImageView we set via Activity.getImg()
    private TableColumn<ActivityBrief, String> tblActivityIMGCol;
    @FXML
    private TableColumn<ActivityBrief, String> tblActivityNameCol;
    @FXML
    private TableColumn<ActivityBrief, String> tblActivityDescCol;
    @FXML
    //@TODO: work out why buttons won't add to table
    /**Workaround was to use a double click on the table row**/
    private TableColumn<ActivityBrief, Button> tblActivityJoinCol;
    private ArrayList<Activity> activityList;
    //@TODO: we always need to track the user when they've logged in, work out how
    /**we could just keep passing the user along between scenes? --> quick**/
    /**we could keep a singleton Instance of the User(captured on login/registration) somewhere? --> better?**/


    public HomeController(){}


    @FXML
    public void initialize(){
        BackgroundSize bgs = new BackgroundSize(ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT, false, false, false, false);
        Background bg = new Background(new BackgroundImage(new Image(HelloApplication.class.getResource("img/background-solid.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs));
        parentPane.setPrefSize(ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT);
        parentPane.setBackground(bg);

        double screenHalfWidth = ScreenComponent.SCREEN_WIDTH/2;
        activityTableView.setPrefSize(screenHalfWidth, ScreenComponent.SCREEN_HEIGHT/1.25);
        homeHeaderAnchorPane.setPrefWidth(screenHalfWidth);

        double tableHalfWidth = activityTableView.getPrefWidth() / 2;
        activityTableView.setLayoutX(screenHalfWidth-tableHalfWidth);

        //@TODO: work out how to abstract the header for the controllers
        //header stuff
        homeHeaderAnchorPane.setLayoutX(screenHalfWidth-tableHalfWidth);
        profileBtn.setAlignment(Pos.CENTER);
        profileBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(homeTitleText.getLayoutBounds().getWidth()*3.5));
        profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToProfile(actionEvent);
            }
        });
        signOutBtn.setAlignment(Pos.CENTER);
        signOutBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)+(homeTitleText.getLayoutBounds().getWidth()*3));
        signOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                redirectToLogin(actionEvent);
            }
        });
        homeTitleText.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(homeTitleText.getLayoutBounds().getWidth()/2));

        //table stuff
        tblActivityNameCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("name"));
        tblActivityDescCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("desc"));
        tblActivityIMGCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("img"));

        //grab the activity info
        activityList = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);
        ObservableList<ActivityBrief> activities = FXCollections.observableArrayList();

        for(int i = 0; i<activityList.size();i++){
            activities.add(new ActivityBrief("img-uri", activityList.get(i).getParsedName(), activityList.get(i).getDescription().get(0), new Button("join")));
        }
        activityTableView.setItems(activities);
        autoResizeColumns(activityTableView);
        activityTableView.refresh();

        //set lambda mouse event
        activityTableView.setOnMouseClicked((MouseEvent event) ->{
            if(event.getClickCount() > 1){
                System.out.println("double click detected!");
                //we have double click, redirect to single activity page
                redirectToActivity(event, activityTableView);
            }
        });
    }
}
