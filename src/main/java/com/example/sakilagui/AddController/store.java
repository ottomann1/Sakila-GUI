package com.example.sakilagui.AddController;

import Business.Address;
import Business.Staff;
import Business.Store;
import DAO.StoreDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class store {

    @FXML
    private ComboBox<Address> addressDropDown;

    @FXML
    private ComboBox<Staff> managerDropDown;

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

