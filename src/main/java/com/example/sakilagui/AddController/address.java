package com.example.sakilagui.AddController;

import Business.Address;
import Business.City;
import DAO.AddressDAO;
import DAO.CityDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

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

    private Collection<City> city = new ArrayList<>();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        CityDAO cityDAO = new CityDAO();
        Collection<City> city = cityDAO.readAll();
        ObservableList<City> observableCity = FXCollections.observableArrayList(city);
        cityDropDown.setItems(observableCity);

    }

    @FXML
    void addAddressOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Address address = new Address();
        address.setAddress(addressField.getText());
        address.setDistrict(districtField.getText());
        address.setPhone(phoneField.getText());
        address.setCity(cityDropDown.getValue());
        address.setPostalCode(postalCodeField.getText());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        address.setLastUpdate(timestamp);
        AddressDAO addressDAO = new AddressDAO();
        Address randaddress = (Address) addressDAO.read(1).get();
        address.setLocation(randaddress.getLocation());
        addressDAO.create(address);
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();

    }

}

