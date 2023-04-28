module com.teamrl.teamrlnew {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.teamrl.app to javafx.fxml;
    exports com.teamrl.app to javafx.graphics, com.fasterxml.jackson, com.fasterxml.jackson.databind;

}