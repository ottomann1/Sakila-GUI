package com.example.sakilagui.AddController;

import Business.Address;
import Business.Staff;
import Business.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class store {

    @FXML
    private ComboBox<Address> addressDropDown;

    @FXML
    private ComboBox<Staff> staffDropDown;

    @FXML
    private TextArea staffListField;

    @FXML
    void addStaffOnClick(ActionEvent event) {

    }

    @FXML
    void addStoreOnClick(ActionEvent event) {
        Store store = new Store();

    }

}
