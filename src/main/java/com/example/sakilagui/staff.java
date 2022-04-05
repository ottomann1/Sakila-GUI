package com.example.sakilagui;

import Business.Address;
import Business.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class staff {
    @FXML
    private ChoiceBox<Store> StoreDropDown;

    @FXML
    private ChoiceBox<Address> addressDropDown;

    @FXML
    private TextField staffEmailField;

    @FXML
    private TextField staffFirstNameField;

    @FXML
    private TextField staffLastNameField;

    @FXML
    void addStaffOnClick(ActionEvent event) {

    }

}
