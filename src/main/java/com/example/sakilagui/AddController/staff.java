package com.example.sakilagui.AddController;

import Business.Address;
import Business.Staff;
import Business.Store;
import DAO.StaffDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    void addStaffOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Staff staff = new Staff();
        staff.setFirstName(staffFirstNameField.getText());
        staff.setLastName(staffLastNameField.getText());
        staff.setEmail(staffEmailField.getText());
       // staff.setAddress(addressDropDown.getValue());
        StaffDAO staffDAO = new StaffDAO();
        staffDAO.create(staff);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/businessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}
