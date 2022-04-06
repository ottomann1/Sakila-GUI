package com.example.sakilagui.AddController;

import Business.Actor;
import Business.Category;
import Business.Customer;
import Business.Film;
import DAO.ActorDAO;
import DAO.FilmDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class film {


    @FXML
    private ListView<Actor> actorList;

    @FXML
    private ChoiceBox<Category> categoryDropDown;

    @FXML
    private TextArea filmDescriptionField;

    @FXML
    private TextField filmLengthField;

    @FXML
    private TextField filmTitleField;

    @FXML
    private ChoiceBox<String> ratingDropDown;

    @FXML
    private TextField releaseYearField;

    @FXML
    private TextField rentalDurationField;

    @FXML
    private TextField rentalRateField;

    @FXML
    private TextField replacementCostField;

    @FXML
    private ChoiceBox<Actor> selectActorDropDown;

    @FXML
    private TextField specialFeatureField;

    private Collection<Actor> actors = new ArrayList<>();
//    private Collection<Film> film = new ArrayList<>();
    

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        ActorDAO actorDAO = new ActorDAO();
        Collection<Actor> actors = actorDAO.readAll();
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        selectActorDropDown.setItems(observableActors);
        String[] ratings = {"G", "PG", "PG-13", "R", "NC-17"};

//        FilmDAO filmDAO = new FilmDAO();
//        Collection<Film> rating = filmDAO.readAll();
//        ObservableList<Film> observableFilm = FXCollections.observableArrayList(film);
//        ratingDropDown.setItems(observableFilm);
    }

    @FXML
    void addActorOnClick(ActionEvent event) {
        actors.add(selectActorDropDown.getValue());
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        actorList.setItems(observableActors);
    }

    @FXML
    void addFilmOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Film film = new Film();
        film.setTitle(filmTitleField.getText());
        film.setReleaseYear(Date.valueOf(releaseYearField.getText()));
        film.setLength(Short.parseShort(filmLengthField.getText()));
        film.setRating(ratingDropDown.getValue());
      //  film.setCategory(categoryDropDownDropDown.getValue());
        film.setRentalRate(BigDecimal.valueOf(Long.parseLong(rentalRateField.getText())));
        film.setRentalDuration(Byte.parseByte(rentalDurationField.getText()));
        film.setReplacementCost(BigDecimal.valueOf(Long.parseLong(replacementCostField.getText())));
        film.setSpecialFeatures(specialFeatureField.getText());
        film.setDescription(filmDescriptionField.getText());
        film.setActor(actorList.itemsProperty().getValue());
        FilmDAO filmDAO = new FilmDAO();
        filmDAO.create(film);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/BusinessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();


    }

}

