package com.example.sakilagui.UpdateController;

import Business.Address;
import Business.Film;
import Business.Staff;
import Business.Store;
import DAO.AddressDAO;
import DAO.StaffDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class upstaff {
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
    void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        Collection<Address> address = addressDAO.readAll();
        ObservableList<Address> observableAddress = FXCollections.observableArrayList(address);
        addressDropDown.setItems(observableAddress);

    }

    private Staff staff;


    public void setFields(Staff staffx) {
        staff = staffx;
        staffFirstNameField.setText(staff.getFirstName());
        staffLastNameField.setText(staff.getLastName());
        staffEmailField.setText(staff.getEmail());
        addressDropDown.setValue(staff.getAddress());

    }

    @FXML
    void addStaffOnClick(ActionEvent event) throws IOException {
        StaffDAO staffDAO = new StaffDAO();
        staff.setFirstName(staffFirstNameField.getText());
        staff.setLastName(staffLastNameField.getText());
        staff.setEmail(staffEmailField.getText());
        staff.setAddress(addressDropDown.getValue());
        staffDAO.update(staff, new upstaff());
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();


    }

}
