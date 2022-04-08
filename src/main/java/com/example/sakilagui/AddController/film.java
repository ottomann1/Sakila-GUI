package com.example.sakilagui.AddController;

import Business.Actor;
import Business.Category;
import Business.Film;
import Business.Language;
import DAO.ActorDAO;
import DAO.CategoryDAO;
import DAO.FilmDAO;
import DAO.LanguageDAO;
import DAO.kopplingstabeller.FilmActor;
import DAO.kopplingstabeller.FilmCategory;
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
import java.util.Iterator;

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
    private ChoiceBox<Language> selectLanuageDropDown;

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
    private Collection<Language> languages = new ArrayList<>();
    private Collection<Actor> newActors= new ArrayList<Actor>();

    @FXML
    private Button addActorButton;

    Stage actorStage = new Stage();


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        ActorDAO actorDAO = new ActorDAO();
        actors = actorDAO.readAll();
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actors);
        selectActorDropDown.setItems(observableActors);

        CategoryDAO categoryDAO = new CategoryDAO();
        categories = categoryDAO.readAll();
        ObservableList<Category> observableCategory = FXCollections.observableArrayList(categories);
        categoryDropDown.setItems(observableCategory);

        LanguageDAO languageDAO = new LanguageDAO();
        languages = languageDAO.readAll();
        ObservableList<Language> observableLanguages = FXCollections.observableArrayList(languages);
        selectLanuageDropDown.setItems(observableLanguages);

        String[] ratings = {"G", "PG", "PG-13", "R", "NC-17"};
        ObservableList<String> rating = FXCollections.observableArrayList(ratings);
        ratingDropDown.setItems(rating);

// secenSwapChanges
        FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/actor.fxml"));
        Scene sceneActor = new Scene(loader1.load());
//        Stage actorStage = new Stage();
        actorStage.setScene(sceneActor);
        actorStage.initModality(Modality.APPLICATION_MODAL);

// master
    }

    @FXML
    void removeActorsClick(ActionEvent event){
        newActors.remove(selectActorDropDown.getValue());
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(newActors);
        actorList.setItems(observableActors);
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
        newActors.add(selectActorDropDown.getValue());
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(newActors);
        actorList.setItems(observableActors);
// master
    }

    @FXML
    void addFilmOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Film film = new Film();
        film.setTitle(filmTitleField.getText());
//        Date date = new Date(2000, 01, 02);
//        film.setReleaseYear(date);
        film.setLength(Short.parseShort(filmLengthField.getText()));
        film.setRating(ratingDropDown.getValue());
        film.setLanguage(selectLanuageDropDown.getValue());
        film.setRentalRate(BigDecimal.valueOf(Long.parseLong(rentalRateField.getText())));
        film.setRentalDuration(Byte.parseByte(rentalDurationField.getText()));
        film.setReplacementCost(BigDecimal.valueOf(Long.parseLong(replacementCostField.getText())));
//        film.setSpecialFeatures(specialFeatureField.getText());
        film.setDescription(filmDescriptionField.getText());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        film.setLastUpdate(timestamp);
        FilmDAO filmDAO = new FilmDAO();
        short filmId = filmDAO.createFilm(film);
        Film createdFilm = (Film) filmDAO.read(filmId).get();
        createdFilm.setActor(newActors);
        createdFilm.setCategory(categoryDropDown.getSelectionModel().getSelectedItem());
        FilmCategory filmCategory = new FilmCategory();
        FilmActor filmActor = new FilmActor();
        Iterator filmActorIte = newActors.iterator();
        while(filmActorIte.hasNext()){
            filmActor.createFilmIdAndActorId(createdFilm.getFilmId(), (short) newActors.iterator().next().getActorId());
        }
        filmCategory.createFilmIdAndCategoryId(createdFilm.getFilmId(), categoryDropDown.getSelectionModel().getSelectedItem().getCategoryId());
        filmDAO.update(createdFilm, film);

//        film.addCategory(categoryDropDown.getValue());
//        filmCa
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();


    }

}

