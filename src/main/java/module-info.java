module com.example.sdd_cw02_teamrl_jfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teamRl to javafx.fxml;
    exports com.example.teamRl;
}