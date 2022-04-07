package com.example.sakilagui.AddController;

import Business.Address;
import Business.Staff;
import Business.Store;
import DAO.AddressDAO;
import DAO.StaffDAO;
import DAO.StoreDAO;
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
import java.sql.Timestamp;
import java.util.Collection;

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
    void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        StoreDAO storeDAO = new StoreDAO();
        Collection<Address> address = addressDAO.readAll();
        ObservableList<Address> observableAddress = FXCollections.observableArrayList(address);
        Collection<Store> store = storeDAO.readAll();
        ObservableList<Store> observableStore = FXCollections.observableArrayList(store);
        StoreDropDown.setItems(observableStore);
        addressDropDown.setItems(observableAddress);
    }

    @FXML
    void addStaffOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Staff staff = new Staff();
        staff.setFirstName(staffFirstNameField.getText());
        staff.setLastName(staffLastNameField.getText());
        staff.setEmail(staffEmailField.getText());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        staff.setLastUpdate(timestamp);
       // staff.setAddress(addressDropDown.getValue());
        StaffDAO staffDAO = new StaffDAO();
        staffDAO.create(staff);
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();

    }

}
