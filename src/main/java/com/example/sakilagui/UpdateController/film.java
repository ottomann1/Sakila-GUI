package com.example.sakilagui.UpdateController;

import Business.Actor;
import Business.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class film {

    @FXML
    private TextArea actorListField;

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

    @FXML
    void addActorOnClick(ActionEvent event) {

    }

    @FXML
    void addFilmOnClick(ActionEvent event) {

    }

}

