package com.example.teamrl;
//lead auth:JacobFarrow(20007972)
import com.example.teamrl.components.FileComponent;
import com.example.teamrl.components.ReadComponent;
import com.example.teamrl.components.ScreenComponent;
import com.example.teamrl.components.SessionComponent;
import com.example.teamrl.controllers.HomeController;
import com.example.teamrl.controllers.LoginController;
import com.example.teamrl.controllers.ProfileController;
import com.example.teamrl.controllers.SingleActivityController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    //auth:JacobFarrow(20007972)
    public static SessionComponent currentSession;


    @Override
    public void start(Stage stage) throws IOException {
        currentSession = new SessionComponent();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), ScreenComponent.SCREEN_WIDTH, ScreenComponent.SCREEN_HEIGHT);

        /**not sure if we need this**/
//        //hide the window bar
//        stage.resizableProperty().setValue(false);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("UConnect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public static class ActivityBrief{
        private String img;
        private String name;
        private String desc;
        private Button join;
        private String time;
        private String location;
        private String contact;
        public ActivityBrief(String i, String n, String d, Button b){
            this.img=i;
            this.name=n;
            this.desc=d;
            this.join =b;
            this.time="";
            this.location="";
            this.contact="";
        }
        public ActivityBrief(String i, String n, String d, Button b, String t, String l, String c){
            this.img=i;
            this.name=n;
            this.desc=d;
            this.join =b;
            this.time=t;
            this.location=l;
            this.contact=c;
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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }
    }





    /**!WARNING! Needs a bunch of work so don't touch unless you fancy doing some refactoring!**/
    //@TODO: checks on stuff. Are we already in the scene, etc.
    //@TODO: abstract the specific Controller class to extend a shared, non-specific parent (then we can just pass non-specific Controller)?
    public static Scene getScene(String fxmlPath, SingleActivityController controller){
        FXMLLoader loader;
        Parent root;
        Scene scene;
        try{
            loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
            loader.setController(controller);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scene = new Scene(root);
        return scene;
    }

    //@TODO: work out why we are getting an extra column in profile
    public static void autoResizeColumns( TableView<?> table )
    {
        //Set the right policy
        table.setColumnResizePolicy( TableView.UNCONSTRAINED_RESIZE_POLICY);

        //loop each column
        table.getColumns().stream().forEach( (column) ->
        {
            //Minimal width = column header
            Text t = new Text( column.getText() );
            double max = t.getLayoutBounds().getWidth();
            for ( int i = 0; i < table.getItems().size(); i++ )
            {
                //cell must not be empty
                if ( column.getCellData( i ) != null )
                {
                    t = new Text( column.getCellData( i ).toString() );
                    double calcwidth = t.getLayoutBounds().getWidth();
                    //remember new max-width
                    if ( calcwidth > max )
                    {
                        max = calcwidth;
                    }
                }
            }
            //set the new max-width with some extra space
            column.setPrefWidth( max + 10.0d );
        } );
    }

    //page redirection

    //@TODO: update sessions if user has checked remember me
    public static void redirectToHome(ActionEvent event) {
        Node node=(Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-2.fxml"));
            HomeController hc = new HomeController();
            fxmlLoader.setController(hc);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void redirectToActivity(MouseEvent event, TableView<ActivityBrief> activityTableView) {
        if (activityTableView.getSelectionModel().getSelectedItem() != null) {
            ActivityBrief ab = activityTableView.getSelectionModel().getSelectedItem();

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            ArrayList<Activity> activityList = ReadComponent.readActivityDataFromJSON(FileComponent.ACTIVITY_FILENAME, FileComponent.MAIN_FOLDER);
            //try and load the selected activity as a single activity
            try {
                Activity selectedActivity = new Activity();
                for (int i = 0; i < activityList.size(); i++) {
                    if (activityList.get(i).getParsedName().equals(ab.getName())) {
                        selectedActivity = activityList.get(i);
                        System.out.println("found activity!");
                        break;
                    }
                }
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

    public static void redirectToProfile(ActionEvent event){
        Node node=(Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
            ProfileController pc = new ProfileController();
            fxmlLoader.setController(pc);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //@TODO: add in the remember me stuff
    public static void redirectToLogin(ActionEvent event) {

        Node node=(Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void redirectToRegistration(ActionEvent event){
        Node node=(Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-bg-solid.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exitApp(){
        Platform.exit();
    }
}

//Comment your name under this here if you familiarized yourself with the codebase the last time Jacob asked:
