package com.example.sakilagui.UpdateController;

import Business.Address;
import Business.Customer;
import DAO.AddressDAO;
import DAO.CustomerDAO;
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
import java.util.ArrayList;
import java.util.Collection;

public class upcustomer {

    @FXML
    private ChoiceBox<Address> addressDropDown;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    private Collection<Address> address = new ArrayList<>();

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        address = addressDAO.readAll();
        ObservableList<Address> observableAddress = FXCollections.observableArrayList(address);
        addressDropDown.setItems(observableAddress);

    }

    private Customer customer;

    public void setFields(Customer customerx) {
        customer = customerx;
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        addressDropDown.setValue(customer.getAddress());
        emailField.setText(customer.getEmail());
    }


    @FXML
    void addCustomerOnClick(ActionEvent event) throws IOException {
        CustomerDAO customerDAO = new CustomerDAO();
        customer.setFirstName(firstNameField.getText());
        customer.setLastName(lastNameField.getText());
        customer.setEmail(emailField.getText());
        customer.setAddress(addressDropDown.getValue());
        customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        customerDAO.update(customer, new upcustomer());
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();

    }

}
