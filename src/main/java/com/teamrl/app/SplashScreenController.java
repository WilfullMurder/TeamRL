package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * !WARNING! VOLATILE
 * DON'T TOUCH THIS CODE!
 * DON'T ADD IT INTO THE PROJECT!
 * YOU DO NOT HAVE ENOUGH KNOWLEDGE OR EXPERIENCE TO DEAL WITH THIS!
 * TALKING TO YOU JACOB!
 * !WARNING! VOLATILE
 * (bit dramatic, it works but I'm dubious about threads)
 */

//@TODO: sort layout
//@TODO: fix loading bar and label
//@TODO: more research on threads (GUI -> non-GUI, etc.)
public class SplashScreenController implements Initializable {
    //auth:JacobFarrow(20007972)
    @FXML
    private ImageView splashBGImageView;
    @FXML
    private Label loadLabel;
    @FXML
    private ProgressBar loadingBar;
    @FXML
    private AnchorPane splashPane;


    @FXML
    public void initialize(){

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new SplashScreen().start();
    }


    //create new thread for automatic running after Main
    class SplashScreen extends Thread{
        private Label loadLabel;

        //allows Jvm to recognise these statements have to be executed
        @Override
        public void run(){
            try{
                //sleep for 5 seconds
                Thread.sleep(5000);

                Platform.runLater(new Runnable() {

                    //update GUI component from non-GUI thread a.s.a.p

                    @Override
                    public void run() {
                        //Switch between scenes

                        Parent root = null;

                        try{
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                            root = fxmlLoader.load();
                        } catch(IOException e){
                            //file failed, log error
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE,null,e);
                        }

                        Window owner = splashPane.getScene().getWindow();

                        Stage stage = new Stage();
                        stage.initOwner(owner);
                        Scene scene = new Scene(root);

                        stage.setScene(scene);

//                        //hide window bar
//                        stage.resizableProperty().setValue(false);
//                        stage.initStyle(StageStyle.UNDECORATED);

                        stage.show();

                    }
                });


            } catch (InterruptedException e) {
                //interrupted thread, log error
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }



}
