package com.teamrl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;

import java.io.File;

public class TestController {

    @FXML
    private VBox titleText;
    @FXML
    private BorderPane backgroundImageView;
    @FXML
    private VBox loginBox;
    @FXML
    private GridPane menuGrid;

    @FXML
    private Button cancelButton;


    public void initialize(){
        double h = Screen.getPrimary().getVisualBounds().getHeight();
        double w = Screen.getPrimary().getVisualBounds().getWidth();
        BackgroundSize bgs = new BackgroundSize(w,h,false,false,true, true);

        File f = new File("src/main/resources/com/teamrl/app/img/logo.png");

        Image i = new Image(f.toURI().toString());
        Background bg = new Background(new BackgroundImage(i,
                BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, bgs));

        backgroundImageView.setBackground(bg);

        titleText.setTranslateX(w/2);
        loginBox.setTranslateX(w/2);
        menuGrid.addColumn(3);
        menuGrid.addRow(7);
        menuGrid.setHgap(10);
        menuGrid.setVgap(15);


    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
    }

    public void onCancelButtonClick(ActionEvent actionEvent) {
    }
}
