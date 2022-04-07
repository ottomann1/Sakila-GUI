package com.example.sakilagui.UpdateController;

import Business.Address;
import Business.City;
import DAO.AddressDAO;
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

public class upaddress {


    @FXML
    private TextField AddressField;

    @FXML
    private ComboBox<City> CityDropDown;

    @FXML
    private TextField DistrictField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField PostalCodeField;

    private Address address;

    public void setFields(Address addressx){
        address = addressx;
        AddressField.setText(address.getAddress());
        DistrictField.setText(address.getDistrict());
        CityDropDown.setValue(address.getCity());
        PhoneField.setText(address.getPhone());
        PostalCodeField.setText(address.getPostalCode());
    }

       @FXML
       void addAddressOnClick(ActionEvent event)  throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        address.setAddress(AddressField.getText());
        address.setDistrict(DistrictField.getText());
        address.setPhone(PhoneField.getText());
        address.setCity(CityDropDown.getValue());
        address.setPostalCode(PostalCodeField.getText());
        address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        addressDAO.update(address, new upaddress());
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}

