module com.example.teamrl {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.example.teamrl to javafx.fxml, javafx.base, com.fasterxml.jackson.core, com.fasterxml.jackson.databind;
    opens com.example.teamrl.controllers to com.fasterxml.jackson.core, com.fasterxml.jackson.databind, javafx.base, javafx.fxml;
    opens com.example.teamrl.components to com.fasterxml.jackson.core, com.fasterxml.jackson.databind, javafx.base, javafx.fxml;
    exports com.example.teamrl;
    exports com.example.teamrl.controllers;
    exports com.example.teamrl.components;
}

