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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class store {

    @FXML
    private ComboBox<Address> addressDropDown;

    @FXML
    private ComboBox<Staff> managerDropDown;

    private Collection<Staff> staff = new ArrayList<>();
    private Collection<Address> address = new ArrayList<>();


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        Collection<Address> address = addressDAO.readAll();
        ObservableList<Address> observableAddress = FXCollections.observableArrayList(address);
        addressDropDown.setItems(observableAddress);

        StaffDAO staffDAO = new StaffDAO();
        Collection<Staff> staff = staffDAO.readAll();
        ObservableList<Staff> observableStaff = FXCollections.observableArrayList(staff);
        managerDropDown.setItems(observableStaff);

    }

    @FXML
    void addStoreOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Store store = new Store();
        store.setAddress(addressDropDown.getValue());
        store.setStaff(managerDropDown.getValue());
        StoreDAO storeDAO = new StoreDAO();
        storeDAO.create(store);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/BusinessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}

