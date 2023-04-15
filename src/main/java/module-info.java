module com.example.sdd_cw02_teamrl_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.teamRl to javafx.fxml;
    exports com.example.teamRl;
}