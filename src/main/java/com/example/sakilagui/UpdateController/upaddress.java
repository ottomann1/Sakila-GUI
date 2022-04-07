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
    private TextField upAddressField;

    @FXML
    private ComboBox<City> upCityDropDown;

    @FXML
    private TextField upDistrictField;

    @FXML
    private TextField upPhoneField;

    @FXML
    private TextField upPostalCodeField;

    private Address address;

    public void setFields(Address addressx){
        address = addressx;
        upAddressField.setText(address.getAddress());
        upDistrictField.setText(address.getDistrict());
        upCityDropDown.setValue(address.getCity());
        upPhoneField.setText(address.getPhone());
        upPostalCodeField.setText(address.getPostalCode());
    }

       @FXML
       void updateAddressOnClick(ActionEvent event)  throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        address.setAddress(upAddressField.getText());
        address.setDistrict(upDistrictField.getText());
        address.setPhone(upPhoneField.getText());
        address.setCity(upCityDropDown.getValue());
        address.setPostalCode(upPostalCodeField.getText());
        address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        addressDAO.update(address, new upaddress());
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}

