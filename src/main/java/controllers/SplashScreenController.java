package com.teamrl.app.controllers;
//lead auth:JacobFarrow(20007972)
import com.teamrl.app.HelloApplication;
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
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * !WARNING!
 * Do not mess with or try to implement this code!
 * You aren't experienced or knowledgeable enough to mess with threads yet!
 * Looking at you, Jacob!
 * !WARNING!
 */
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
