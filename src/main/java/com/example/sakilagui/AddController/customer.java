package com.example.sakilagui.AddController;

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

public class customer {

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
        Collection<Address> address = addressDAO.readAll();
        ObservableList<Address> observableAddress = FXCollections.observableArrayList(address);
        addressDropDown.setItems(observableAddress);

    }

    @FXML
    void addCustomerOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName(firstNameField.getText());
        customer.setLastName(lastNameField.getText());
        customer.setEmail(emailField.getText());
        customer.setAddress(addressDropDown.getValue());
        customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.create(customer);
//        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
//        Scene scene = new Scene(loader.load());
//        thisStage.setScene(scene);
//        thisStage.show();


    }

}
