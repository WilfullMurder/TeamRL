module com.example.teamrlnew {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.example.teamrlnew to javafx.fxml, javafx.base, com.fasterxml.jackson.core, com.fasterxml.jackson.databind;
    opens com.example.teamrlnew.controllers to com.fasterxml.jackson.core, com.fasterxml.jackson.databind, javafx.base, javafx.fxml;
    opens com.example.teamrlnew.components to com.fasterxml.jackson.core, com.fasterxml.jackson.databind, javafx.base, javafx.fxml;
    exports com.example.teamrlnew;
    exports com.example.teamrlnew.controllers;
    exports com.example.teamrlnew.components;
}