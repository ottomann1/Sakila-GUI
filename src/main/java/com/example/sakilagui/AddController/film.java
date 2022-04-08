package com.example.sakilagui.AddController;

import Business.Actor;
import Business.Category;
import Business.Coupling.FilmActor;
import Business.Coupling.FilmCategory;
import Business.Film;
import Business.Language;
import DAO.ActorDAO;
import DAO.CategoryDAO;
import DAO.FilmDAO;
import DAO.LanguageDAO;
import DAO.kopplingstabeller.FilmActorDAO;
import DAO.kopplingstabeller.FilmCategoryDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
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
    private ActorDAO actorDAO = new ActorDAO();

    @FXML
    private Button addActorButton;

    Stage actorStage = new Stage();


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
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
        Calendar cal = Calendar.getInstance();
//        LocalDate localDate = LocalDate.now();
        LocalDate date = LocalDate.now();

//        film.setTitle(localDate.toString());
//        film.setReleaseYear(String.valueOf(date.getYear()));
        film.setLength((short) 5);
//        film.setLength(Short.parseShort(filmLengthField.getText()));
//        film.setRating(ratingDropDown.getValue());
        film.setRating("R");
//        film.setLanguage(selectLanuageDropDown.getValue());
        film.setLanguage(selectLanuageDropDown.getValue());
//        film.setRentalRate(BigDecimal.valueOf(Long.parseLong(rentalRateField.getText())));
        film.setRentalRate(BigDecimal.valueOf(5));
//        film.setRentalDuration(Byte.parseByte(rentalDurationField.getText()));
        film.setRentalDuration((byte) 5);
//        film.setReplacementCost(BigDecimal.valueOf(Long.parseLong(replacementCostField.getText())));
        film.setReplacementCost(BigDecimal.valueOf(5));
//        film.setSpecialFeatures("Trailers");
        film.setSpecialFeatures("Trailers");
//        film.setDescription(filmDescriptionField.getText());
        film.setDescription(String.valueOf(555));
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        film.setLastUpdate(timestamp);
        film.setLastUpdate(timestamp);
        FilmDAO filmDAO = new FilmDAO();
//        filmDAO.read(filmId).get();
        film.setActor(newActors);
        film.setCategory(categoryDropDown.getSelectionModel().getSelectedItem());
        FilmCategoryDAO filmCategory = new FilmCategoryDAO();
        FilmActorDAO filmActor = new FilmActorDAO();
        Iterator filmActorIte = newActors.iterator();
//        short filmId = filmDAO.createFilm(film);
        while(filmActorIte.hasNext()){
//            filmActor.createFilmIdAndActorId(film.getFilmId(), (short) ((Actor) filmActorIte.next()).getActorId());
            FilmActor filmActorSave = new FilmActor((Actor) filmActorIte.next(), film);
            filmActor.createFilmActor(filmActorSave);
        }
//        (short) xActor.getActorId()
//        filmCategory.createFilmIdAndCategoryId(film.getFilmId(), categoryDropDown.getSelectionModel().getSelectedItem().getId());
        FilmCategory filmCategorySave = new FilmCategory(film, categoryDropDown.getSelectionModel().getSelectedItem());
        filmCategory.createFilmCategory(filmCategorySave);
        short filmIda = filmDAO.createFilm(film);
//        filmDAO.update(film, film);

//        film.addCategory(categoryDropDown.getValue());
//        filmCa
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();


    }

}

