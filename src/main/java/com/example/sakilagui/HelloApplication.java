package com.example.sakilagui;

import Business.Address;
import Business.City;
import Business.Film;
import DAO.AddressDAO;
import DAO.CityDAO;
import DAO.FilmDAO;
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

//        System.out.println("Hello World");
//
//        Address addressA = new Address();
//
//        AddressDAO addressDAO = new AddressDAO();
//
////        addressA = (Address) addressDAO.read(1);
//
//        System.out.println(addressA.toString());

//        City cityA = new City();
//
//        CityDAO cityDAO = new CityDAO();
//
//        cityA = (City) cityDAO.read(1);
//
//        System.out.println(cityA.toString());

        Film filmA = new Film();

        FilmDAO filmDAO = new FilmDAO();

        filmA = (Film) filmDAO.read(1);

        System.out.println(filmA.toString());


    }

}