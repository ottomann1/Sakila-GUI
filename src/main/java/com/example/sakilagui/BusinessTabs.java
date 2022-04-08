package com.example.sakilagui;

import Business.*;
import DAO.*;
import com.example.sakilagui.UpdateController.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class BusinessTabs {

    @FXML
    private TableColumn<Actor, ?> actorFirstName;

    @FXML
    private TableColumn<Actor, ?> actorLastName;

    @FXML
    private Tab actorTab;

    @FXML
    private TableView<Actor> actorTable;

    @FXML
    private TableColumn<Address, ?> addressAddress;

    @FXML
    private TableColumn<Address, ?> addressCity;

    @FXML
    private TableColumn<Address, ?> addressPhone;

    @FXML
    private TableColumn<Address, ?> addressPostal;

    @FXML
    private Tab addressTab;

    @FXML
    private TableView<Address> addressTable;

    @FXML
    private AnchorPane ap;

    @FXML
    private TableColumn<Customer, ?> customerAddress;

    @FXML
    private TableColumn<Customer, ?> customerEmail;

    @FXML
    private TableColumn<Customer, ?> customerFirstName;

    @FXML
    private TableColumn<Customer, ?> customerLastName;

    @FXML
    private Tab customerTab;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Film, ?> filmDescription;

    @FXML
    private TableColumn<Film, ?> filmLanguage;

    @FXML
    private TableColumn<Film, ?> filmLength;

    @FXML
    private TableColumn<Film, ?> filmReleaseYear;

    @FXML
    private Tab filmTab;

    @FXML
    private TableView<Film> filmTable;

    @FXML
    private TableColumn<Film, ?> filmTitle;

    @FXML
    private TableColumn<Staff, ?> staffAddress;

    @FXML
    private TableColumn<Staff, ?> staffEmail;

    @FXML
    private TableColumn<Staff, ?> staffFirstName;

    @FXML
    private TableColumn<Staff, ?> staffLastName;

    @FXML
    private TableColumn<Staff, ?> staffStoreId;

    @FXML
    private Tab staffTab;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Store, ?> storeAddress;

    @FXML
    private TableColumn<Store, ?> storeStaff;

    @FXML
    private Tab storeTab;

    @FXML
    private TableView<Store> storeTable;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        filmLoad();
        customerLoad();
        actorLoad();
        storeLoad();
        staffLoad();
        addressLoad();
    }

    void filmLoad() throws IOException, ClassNotFoundException {
        FilmDAO filmDAO = new FilmDAO();
        List<Film> film = filmDAO.readAll();
        ObservableList<Film> observableFilms = FXCollections.observableArrayList(film);
        filmTable.setItems(observableFilms);
        filmTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        filmDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        filmReleaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        filmLanguage.setCellValueFactory(new PropertyValueFactory<>("language"));
        filmLength.setCellValueFactory(new PropertyValueFactory<>("length"));
        filmTable.setItems(observableFilms);
        filmTable.getColumns().setAll(filmTitle, filmDescription, filmReleaseYear, filmLanguage, filmLength);
    }

    void actorLoad() throws IOException, ClassNotFoundException {
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actor = actorDAO.readAll();
        ObservableList<Actor> observableActors = FXCollections.observableArrayList(actor);
        actorTable.setItems(observableActors);
        actorFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        actorLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        actorTable.setItems(observableActors);
        actorTable.getColumns().setAll(actorFirstName, actorLastName);
    }

    void storeLoad() throws IOException, ClassNotFoundException {
//        no DAO for it check if needed
//
        StoreDAO storeDAO = new StoreDAO();
        List<Store> store = storeDAO.readAll();
        ObservableList<Store> observableStores = FXCollections.observableArrayList(store);
        storeTable.setItems(observableStores);
        storeAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        storeStaff.setCellValueFactory(new PropertyValueFactory<>("staff"));
        storeTable.setItems(observableStores);
        storeTable.getColumns().setAll(storeAddress, storeStaff);
    }

    void staffLoad() throws IOException, ClassNotFoundException {
        StaffDAO staffDAO = new StaffDAO();
        List<Staff> staff = staffDAO.readAll();
        ObservableList<Staff> observableStaffs = FXCollections.observableArrayList(staff);
        staffTable.setItems(observableStaffs);
        staffStoreId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        staffLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffAddress.setCellValueFactory(new PropertyValueFactory<>("address")); // change to upaddress with OneToOne
        staffTable.setItems(observableStaffs);
        staffTable.getColumns().setAll(staffStoreId, staffFirstName, staffLastName, staffEmail, staffAddress);
    }
    void customerLoad() throws IOException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customer = customerDAO.readAll();
        ObservableList<Customer> observableCustomers = FXCollections.observableArrayList(customer);
        customerTable.setItems(observableCustomers);
        customerFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customerLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("address")); // change to upaddress with OneToOne
        customerTable.setItems(observableCustomers);
        customerTable.getColumns().setAll(customerFirstName, customerLastName, customerEmail, customerAddress);
    }
    void addressLoad() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        List<Address> address = addressDAO.readAll();
        ObservableList<Address> observableAddresss = FXCollections.observableArrayList(address);
        addressTable.setItems(observableAddresss);
        addressAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCity.setCellValueFactory(new PropertyValueFactory<>("city")); // change to city with OneToOne
        addressPostal.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        addressPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressTable.setItems(observableAddresss);
        addressTable.getColumns().setAll(addressAddress, addressCity, addressPostal, addressPhone);
    }

    @FXML
    void backClick(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/startScreen.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

    @FXML
    void createClick(ActionEvent event) throws IOException, ClassNotFoundException {
        if(actorTab.isSelected()){
            FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/actor.fxml"));
            Scene sceneActor = new Scene(loader1.load());
            Stage actorStage = new Stage();
            actorStage.setScene(sceneActor);
            actorStage.showAndWait();
            actorLoad();
        }
           else if(filmTab.isSelected()){
//            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/film.fxml"));
            Scene sceneFilm = new Scene(loader.load());
            Stage filmStage = new Stage();
            filmStage.setScene(sceneFilm);
            filmStage.showAndWait();
            filmLoad();
            actorLoad();
//            Scene scene = new Scene(loader.load());
//            thisStage.setScene(scene);
//            thisStage.show();
        }
           else if (addressTab.isSelected()){
//            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/addresser.fxml"));
            Scene sceneAddress = new Scene(loader.load());
            Stage addressStage = new Stage();
            addressStage.setScene(sceneAddress);
            addressStage.showAndWait();
            addressLoad();
//            Scene scene = new Scene(loader.load());
//            thisStage.setScene(scene);
//            thisStage.show();
        }
           else if (customerTab.isSelected()){
//            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/customer.fxml"));
            Scene sceneCustomer = new Scene(loader.load());
            Stage customerStage = new Stage();
            customerStage.setScene(sceneCustomer);
            customerStage.showAndWait();
            customerLoad();
//            Scene scene = new Scene(loader.load());
//            thisStage.setScene(scene);
//            thisStage.show();
        }
           else if(storeTab.isSelected()) {
//            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/store.fxml"));
            Scene sceneStore = new Scene(loader.load());
            Stage storeStage = new Stage();
            storeStage.setScene(sceneStore);
            storeStage.showAndWait();
            storeLoad();
//            Scene scene = new Scene(loader.load());
//            thisStage.setScene(scene);
//            thisStage.show();

        }
           else if(staffTab.isSelected()){
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/staff.fxml"));
            Scene sceneStaff = new Scene(loader.load());
            Stage staffStage = new Stage();
            staffStage.setScene(sceneStaff);
            staffStage.showAndWait();
            storeLoad();
        }
    }

    @FXML
    void deleteClick(ActionEvent event) throws IOException, ClassNotFoundException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                ActorDAO actorDAO = new ActorDAO();
                actorDAO.delete(actorTable.getSelectionModel().getSelectedItem());
                actorLoad();
            }
        }
        if(filmTab.isSelected()){
            if(!(filmTable.getSelectionModel().getSelectedItem()==null)){
                FilmDAO filmDAO = new FilmDAO();
                filmDAO.delete(filmTable.getSelectionModel().getSelectedItem());
                filmLoad();
            }
        }
        if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                StaffDAO staffDAO = new StaffDAO();
                staffDAO.delete(staffTable.getSelectionModel().getSelectedItem());
                staffLoad();
            }
        }
        if(customerTab.isSelected()){
            if(!(customerTable.getSelectionModel().getSelectedItem()==null)){
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.delete(customerTable.getSelectionModel().getSelectedItem());
                customerLoad();
            }
        }
        if(addressTab.isSelected()){
            if(!(addressTable.getSelectionModel().getSelectedItem()==null)){
                AddressDAO addressDAO = new AddressDAO();
                addressDAO.delete(addressTable.getSelectionModel().getSelectedItem());
                addressLoad();
            }
        }
        if(storeTab.isSelected()){
            if(!(storeTable.getSelectionModel().getSelectedItem()==null)){
                StoreDAO storeDAO = new StoreDAO();
                storeDAO.delete(storeTable.getSelectionModel().getSelectedItem());
                storeLoad();
            }
        }
    }

    @FXML
    void readClick(ActionEvent event) throws IOException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                Actor actor = actorTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(actor.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(filmTab.isSelected()){
            if(!(filmTable.getSelectionModel().getSelectedItem()==null)){
                Film film = filmTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(film.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                Staff staff = staffTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(staff.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
        if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                Staff staff = staffTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(staff.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
        if(storeTab.isSelected()){
            if(!(storeTable.getSelectionModel().getSelectedItem()==null)){
                Store store = storeTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(store.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(customerTab.isSelected()){
            if(!(customerTable.getSelectionModel().getSelectedItem()==null)){
                Customer customer = customerTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(customer.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(addressTab.isSelected()){
            if(!(addressTable.getSelectionModel().getSelectedItem()==null)){
                Address address = addressTable.getSelectionModel().getSelectedItem();
                Stage thisStage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/FieldOfText.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(address.toStringHeavy());
                thisStage.initModality(Modality.APPLICATION_MODAL);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
    }

    @FXML
    void updateClick(ActionEvent event) throws IOException, ClassNotFoundException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                Actor actor = actorTable.getSelectionModel().getSelectedItem();
//                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upactor.fxml"));
                Scene scene = new Scene(loader.load());
                Stage actorStage = new Stage();
                upActor updateactor = loader.getController();
                updateactor.setFields(actor);
                actorStage.initModality(Modality.APPLICATION_MODAL);
                actorStage.setScene(scene);
                actorStage.showAndWait();
                actorLoad();
            }
        }
        if(filmTab.isSelected()){
            if(!(filmTable.getSelectionModel().getSelectedItem()==null)){
                Film film = filmTable.getSelectionModel().getSelectedItem();
//                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upfilm.fxml"));
                Scene filmScene = new Scene(loader.load());
                Stage filmStage = new Stage();
                upfilm upFilm = loader.getController();
                upFilm.setFields(film);
                filmStage.initModality(Modality.APPLICATION_MODAL);
                filmStage.setScene(filmScene);
                filmStage.showAndWait();
                filmLoad();
            }
        }
        if(addressTab.isSelected()){
            if(!(addressTable.getSelectionModel().getSelectedItem()==null)){
                Address address = addressTable.getSelectionModel().getSelectedItem();
//                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upaddresser.fxml"));
                Scene addressScene = new Scene(loader.load());
                Stage addressStage = new Stage();
                upaddress upAddress = loader.getController();
                upAddress.setFields(address);
                addressStage.initModality(Modality.APPLICATION_MODAL);
                addressStage.setScene(addressScene);
                addressStage.showAndWait();
                filmLoad();
            }
        }
        if(customerTab.isSelected()){
            if(!(customerTable.getSelectionModel().getSelectedItem()==null)){
                Customer customer = customerTable.getSelectionModel().getSelectedItem();
//                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upcustomer.fxml"));
                Scene customerScene = new Scene(loader.load());
                Stage customerStage = new Stage();
                upcustomer upCustomer = loader.getController();
                upCustomer.setFields(customer);
                customerStage.initModality(Modality.APPLICATION_MODAL);
                customerStage.setScene(customerScene);
                customerStage.showAndWait();
                filmLoad();
            }
        }
        if(storeTab.isSelected()){
            if(!(storeTable.getSelectionModel().getSelectedItem()==null)){
                Store store = storeTable.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upstore.fxml"));
                Scene storeScene = new Scene(loader.load());
                Stage storeStage = new Stage();
                upstore upStore = loader.getController();
                upStore.setFields(store);
                storeStage.initModality(Modality.APPLICATION_MODAL);
                storeStage.setScene(storeScene);
                storeStage.showAndWait();
                storeLoad();
            }
        }
        if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                Staff staff = staffTable.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upstaff.fxml"));
                Scene staffScene = new Scene(loader.load());
                Stage staffStage = new Stage();
                upstaff upStaff = loader.getController();
                upStaff.setFields(staff);
                staffStage.initModality(Modality.APPLICATION_MODAL);
                staffStage.setScene(staffScene);
                staffStage.showAndWait();
                storeLoad();
            }
        }

    }

}
