package com.example.sakilagui;

import Business.City;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class address {


    @FXML
    private TextField addressField;

    @FXML
    private ComboBox<City> cityDropDown;

    @FXML
    private TextField districtField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField postalCodeField;

    @FXML
    void addAddressOnClick(ActionEvent event) {

    }

}

