module com.teamrl.teamrl{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.logging;


    opens com.teamrl.app to javafx.fxml, javafx.base;
    exports com.teamrl.app to javafx.graphics, com.fasterxml.jackson, com.fasterxml.jackson.databind;

}