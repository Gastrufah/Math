module com.app.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.main to javafx.fxml;
    exports com.app.main;
}