module com.example.sakilagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires transitive org.hibernate.orm.core;
    requires javafx.base;
    requires java.naming;
    requires java.desktop;
    requires transitive javafx.graphics;
    requires java.base;

    opens com.example.sakilagui.UpdateController to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, Business, DAO, Database;
    opens com.example.sakilagui to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, Business, DAO, Database;
    opens Business to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, com.example.sakilagui;
    opens DAO to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, com.example.sakilagui;
    opens Database to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, com.example.sakilagui;
    opens com.example.sakilagui.AddController to javafx.fxml, org.hibernate.orm.core, javafx.base, java.base, Business, DAO, Database;
    exports com.example.sakilagui;
    exports com.example.sakilagui.AddController;
    exports com.example.sakilagui.UpdateController;
}