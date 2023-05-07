package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

//@TODO: link to profile page
//@TODO: logout methods
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
    //@TODO: sort this out so it's an ImageView we set via Activity.getImg()
    @FXML
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
        Background bg = new Background(new BackgroundImage(new Image(getClass().getResource("img/background-solid.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgs));
        parentPane.setPrefSize(ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT);
        parentPane.setBackground(bg);

        double screenHalfWidth = ScreenComponent.SCREEN_WIDTH/2;
        activityTableView.setPrefSize(screenHalfWidth, ScreenComponent.SCREEN_HEIGHT/1.25);
        homeHeaderAnchorPane.setPrefWidth(screenHalfWidth);

        double tableHalfWidth = activityTableView.getPrefWidth() / 2;
        activityTableView.setLayoutX(screenHalfWidth-tableHalfWidth);
        homeHeaderAnchorPane.setLayoutX(screenHalfWidth-tableHalfWidth);
        profileBtn.setAlignment(Pos.CENTER);
        profileBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(homeTitleText.getLayoutBounds().getWidth()*3.5));
        signOutBtn.setAlignment(Pos.CENTER);
        signOutBtn.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)+(homeTitleText.getLayoutBounds().getWidth()*3));
        homeTitleText.setLayoutX((ScreenComponent.SCREEN_WIDTH/2)-(homeTitleText.getLayoutBounds().getWidth()/2));

        tblActivityNameCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("name"));
        tblActivityDescCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("desc"));
        tblActivityIMGCol.setCellValueFactory(new PropertyValueFactory<ActivityBrief, String>("img"));

        //grab the activity info
        activityList = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);
        ObservableList<ActivityBrief> activities = FXCollections.observableArrayList();

        for(int i = 0; i<activityList.size();i++){
            activities.add(new ActivityBrief("img-uri", activityList.get(i).getName(), activityList.get(i).getDescription().get(0), new Button("join")));
        }
        activityTableView.setItems(activities);
        activityTableView.refresh();

        //set lambda mouse event
        activityTableView.setOnMouseClicked((MouseEvent event) ->{
            if(event.getClickCount() > 1){
                System.out.println("double click detected!");
                //we have double click, redirect to single activity page
                redirectToSingleActivity(event);
            }
        });
    }


    public void redirectToSingleActivity(MouseEvent event) {

        if(activityTableView.getSelectionModel().getSelectedItem() != null){
            //valid item, proceed
            Node node=(Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            ActivityBrief ab = activityTableView.getSelectionModel().getSelectedItem();
            Activity selectedActivity= new Activity();

            //try and load the selected activity as a single activity
            try{
                for(int i =0; i< activityList.size(); i++){
                 if(activityList.get(i).getName().equals(ab.getName())){
                    selectedActivity=activityList.get(i);
                    break;
                 }
                }

                //@TODO: move this out into HelloApplication? --> static func for redirecting scenes?
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("single-activity.fxml"));
                SingleActivityController sac = new SingleActivityController();
                sac.setMyActivity(selectedActivity);
                fxmlLoader.setController(sac);
                stage.setScene(new Scene(fxmlLoader.load()));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class ActivityBrief{
        private String img;
        private String name;
        private String desc;
        private Button join;

        public ActivityBrief(String i, String n, String d, Button b){
            this.img=i;
            this.name=n;
            this.desc=d;
            this.join =b;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Button getJoinBtn() {
            if(join == null){
                join = new Button("join");
            }
            return join;
        }

    }
}
