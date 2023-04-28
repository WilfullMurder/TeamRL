package com.teamrl.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HomeController {

    @FXML
    private ImageView homeBGImageView;

    @FXML
    private AnchorPane homeAnchorPane;
    @FXML
    private TabPane homeTabPane;
    @FXML
    private Label homeTitleLabel;

    @FXML
    public void initialize(){
        homeBGImageView.setFitWidth(ScreenComponent.SCREEN_WIDTH);
        homeBGImageView.setFitHeight(ScreenComponent.SCREEN_HEIGHT);

        double halfWidth = ScreenComponent.SCREEN_WIDTH / 2.0;
        double halfHeight = ScreenComponent.SCREEN_HEIGHT / 2.0;
        double thirdHeight = ScreenComponent.SCREEN_HEIGHT / 3.0;

        homeAnchorPane.setLayoutX(halfWidth);
        homeAnchorPane.setLayoutX(halfHeight);
        homeAnchorPane.setMinHeight(ScreenComponent.SCREEN_HEIGHT);
        homeAnchorPane.setMinWidth(ScreenComponent.SCREEN_WIDTH);

        homeTabPane.setLayoutX(halfWidth - homeTabPane.getWidth());
        homeTabPane.setLayoutY(thirdHeight);
        homeTabPane.setMinWidth(ScreenComponent.SCREEN_WIDTH);
        homeTabPane.setMinWidth(ScreenComponent.SCREEN_HEIGHT- thirdHeight);






    }


}
