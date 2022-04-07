package com.example.sakilagui.AddController;

import Business.Actor;
import Business.Category;
import Business.Film;
import DAO.ActorDAO;
import DAO.CategoryDAO;
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
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
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
    private Collection<Category> categories = new ArrayList<>();
//    private Collection<Film> film = new ArrayList<>();
    

    @FXML
    private Button addActorButton;

    Stage actorStage = new Stage();


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        ActorDAO actorDAO = new ActorDAO();
        Collection<Actor> actors = actorDAO.readAll();
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        selectActorDropDown.setItems(observableActors);

        CategoryDAO categoryDAO = new CategoryDAO();
        Collection<Category> categories = categoryDAO.readAll();
        ObservableList<Category> observableCategory = FXCollections.observableArrayList(categories);
        categoryDropDown.setItems(observableCategory);


// secenSwapChanges
        FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/actor.fxml"));
        Scene sceneActor = new Scene(loader1.load());
//        Stage actorStage = new Stage();
        actorStage.setScene(sceneActor);
        actorStage.initModality(Modality.APPLICATION_MODAL);

        String[] ratings = {"G", "PG", "PG-13", "R", "NC-17"};
        ObservableList<String> rating = FXCollections.observableArrayList(ratings);
        ratingDropDown.setItems(rating);


//        FilmDAO filmDAO = new FilmDAO();
//        Collection<Film> rating = filmDAO.readAll();
//        ObservableList<Film> observableFilm = FXCollections.observableArrayList(film);
//        ratingDropDown.setItems(observableFilm);
// master
    }
    @FXML
    void newActorOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        // secenSwapChanges
//        if(event.getTarget() == addActor){
//            actorStage.close();
//        }
//        else{
        actorStage.showAndWait();
        selectActorDropDown.getItems().clear();
        ActorDAO actorDAO = new ActorDAO();
        Collection<Actor> actors = actorDAO.readAll();
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        selectActorDropDown.setItems(observableActors);
//        }
    }
    @FXML
    void addActorOnClick(ActionEvent event) {


        actors.add(selectActorDropDown.getValue());
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        actorList.setItems(observableActors);
// master
    }

    @FXML
    void addFilmOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Film film = new Film();
        film.setTitle(filmTitleField.getText());
        film.setReleaseYear(Date.valueOf(releaseYearField.getText()));
        film.setLength(Short.parseShort(filmLengthField.getText()));
        film.setRating(ratingDropDown.getValue());
        film.setCategory(categoryDropDown.getValue());
        film.setRentalRate(BigDecimal.valueOf(Long.parseLong(rentalRateField.getText())));
        film.setRentalDuration(Byte.parseByte(rentalDurationField.getText()));
        film.setReplacementCost(BigDecimal.valueOf(Long.parseLong(replacementCostField.getText())));
        film.setSpecialFeatures(specialFeatureField.getText());
        film.setDescription(filmDescriptionField.getText());
        film.setActor(actorList.itemsProperty().getValue());
        film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        FilmDAO filmDAO = new FilmDAO();
        filmDAO.create(film);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();


    }

}

