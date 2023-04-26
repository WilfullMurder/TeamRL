module com.teamrl.teamrl {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    opens com.teamrl.app to javafx.fxml;
    exports com.teamrl.app to com.fasterxml.jackson.databind, javafx.fxml, javafx.graphics;
    exports com.teamrl.app.components to com.fasterxml.jackson.databind, javafx.graphics;
    opens com.teamrl.app.controllers to com.fasterxml.jackson.databind, javafx.fxml, javafx.graphics;

}