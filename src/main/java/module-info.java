module com.example.sakilagui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sakilagui to javafx.fxml;
    exports com.example.sakilagui;
}