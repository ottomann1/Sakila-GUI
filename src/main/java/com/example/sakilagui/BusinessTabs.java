package com.example.sakilagui;

import Business.*;
import DAO.FilmDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BusinessTabs {

    @FXML
    private TableColumn<Actor, ?> actorFirstName;

    @FXML
    private TableColumn<Actor, ?> actorLastName;

    @FXML
    private Tab actorTab;

    @FXML
    private TableView<Actor> actorTable;

    @FXML
    private TableColumn<Address, ?> addressAddress;

    @FXML
    private TableColumn<Address, ?> addressCity;

    @FXML
    private TableColumn<Address, ?> addressPhone;

    @FXML
    private TableColumn<Address, ?> addressPostal;

    @FXML
    private Tab addressTab;

    @FXML
    private TableView<Address> addressTable;

    @FXML
    private AnchorPane ap;

    @FXML
    private TableColumn<Customer, ?> customerAddress;

    @FXML
    private TableColumn<Customer, ?> customerEmail;

    @FXML
    private TableColumn<Customer, ?> customerFirstName;

    @FXML
    private TableColumn<Customer, ?> customerLastName;

    @FXML
    private Tab customerTab;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Film, ?> filmDescription;

    @FXML
    private TableColumn<Film, ?> filmLanguage;

    @FXML
    private TableColumn<Film, ?> filmLength;

    @FXML
    private TableColumn<Film, ?> filmReleaseYear;

    @FXML
    private Tab filmTab;

    @FXML
    private TableView<Film> filmTable;

    @FXML
    private TableColumn<Film, ?> filmTitle;

    @FXML
    private TableColumn<Staff, ?> staffAddress;

    @FXML
    private TableColumn<Staff, ?> staffEmail;

    @FXML
    private TableColumn<Staff, ?> staffFirstName;

    @FXML
    private TableColumn<Staff, ?> staffLastName;

    @FXML
    private TableColumn<Staff, ?> staffStoreId;

    @FXML
    private Tab staffTab;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Store, ?> storeAddress;

    @FXML
    private TableColumn<Store, ?> storeStaff;

    @FXML
    private Tab storeTab;

    @FXML
    private TableView<Store> storeTable;

    void filmLoad() throws IOException, ClassNotFoundException {
        FilmDAO filmDAO = new FilmDAO();
        List<Film> film = filmDAO.readAll();
        ObservableList<Film> observableFilms = FXCollections.observableArrayList(film);
        filmTable.setItems(observableFilms);
        filmTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        filmDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        filmReleaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        filmLanguage.setCellValueFactory(new PropertyValueFactory<>("languageId"));
        filmLength.setCellValueFactory(new PropertyValueFactory<>("length"));
        filmTable.setItems(observableFilms);
        filmTable.getColumns().setAll(filmTitle, filmDescription, filmReleaseYear, filmLanguage, filmLength);
    }

    void actorLoad(){

    }

    void storeLoad(){

    }

    void staffLoad(){

    }
    void customerLoad(){

    }
    void addressLoad(){

    }

    @FXML
    void actorTabClick(ActionEvent event) {

    }

    @FXML
    void addressTabClick(ActionEvent event) {

    }

    @FXML
    void backClick(ActionEvent event) {

    }

    @FXML
    void createClick(ActionEvent event) {

    }

    @FXML
    void customerTabClick(ActionEvent event) {

    }

    @FXML
    void deleteClick(ActionEvent event) {

    }

    @FXML
    void filmTabClick(ActionEvent event) {

    }

    @FXML
    void readClick(ActionEvent event) {

    }

    @FXML
    void staffTabClick(ActionEvent event) {

    }

    @FXML
    void storeTabClick(ActionEvent event) {

    }

    @FXML
    void updateClick(ActionEvent event) {

    }

}
