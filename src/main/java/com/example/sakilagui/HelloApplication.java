package com.example.sakilagui;

import Business.Address;
import DAO.AddressDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        launch();

        System.out.println("Hello World");

        Address addressA = new Address();

        AddressDAO addressDAO = new AddressDAO();

        addressA = (Address) addressDAO.read(1);

        System.out.println(addressA.toString());

    }

}