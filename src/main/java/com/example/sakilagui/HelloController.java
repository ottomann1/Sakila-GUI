package com.example.sakilagui;

import Business.Actor;
import Business.Film;
import DAO.ActorDAO;
import DAO.FilmDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private Tab actorTab;

    @FXML
    private TableColumn<Actor, ?> actorTabFirstName;

    @FXML
    private TableColumn<Actor, ?> actorTabId;

    @FXML
    private TableColumn<Actor, ?> actorTabLastName;

    @FXML
    private TableColumn<Actor, ?> actorTabMovies;

    @FXML
    private TableView<Actor> actorTable;

    @FXML
    private AnchorPane ap;

    @FXML
    private ComboBox<?> comboBoxRating;

    @FXML
    private Tab filmTab;

    @FXML
    private TableColumn<Film, ?> filmTabLanguage;

    @FXML
    private TableColumn<Film, ?> filmTabLength;

    @FXML
    private TableColumn<Film, ?> filmTabRating;

    @FXML
    private TableView<Film> filmTable;

    @FXML
    private TableColumn<Film, ?> filmTableTitle;

    @FXML
    private MenuButton menuButtonSearchBy;

    @FXML
    private MenuItem menuItemActor;

    @FXML
    private MenuItem menuItemMovieTitle;

    @FXML
    private TextField moreInfoDescriptionTextField;

    @FXML
    private Pane moreInfoPane;

    @FXML
    private Label moreInfoTitlePane;

    @FXML
    private Button readCusButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TabPane tabPanex;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        ArrayList<Film> filmArrayList = new ArrayList<Film>();
        filmArrayList.addAll(filmDAO.readAll());
        ObservableList<Film> observableFilms = FXCollections.observableArrayList(filmArrayList);
        filmTable.setItems(observableFilms);
        filmTableTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        filmTabLength.setCellValueFactory(new PropertyValueFactory<>("length"));
        filmTabRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        filmTabLanguage.setCellValueFactory(new PropertyValueFactory<>("languageId"));
        filmTable.setItems(observableFilms);
        filmTable.getColumns().setAll(filmTableTitle, filmTabLength, filmTabLanguage, filmTabRating);
    }


    @FXML
    void backButtonClick(ActionEvent event) {

    }

    @FXML
    void moreInfoBackClick(ActionEvent event) {

    }

    @FXML
    void moreInfoButtonClick(ActionEvent event) {

    }

    @FXML
    void rentButtonClick(ActionEvent event) {

    }

    public void ReadCusClick(ActionEvent actionEvent) {
    }
}
