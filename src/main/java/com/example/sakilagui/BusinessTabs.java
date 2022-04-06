package com.example.sakilagui;

import Business.*;
import DAO.*;
import com.example.sakilagui.UpdateController.upActor;
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
import javafx.stage.Popup;
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
        filmLanguage.setCellValueFactory(new PropertyValueFactory<>("languageId"));
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

    void storeLoad(){
//        no DAO for it check if needed
//
//        StoreDAO storeDAO = new StoreDAO();
//        List<Store> store = storeDAO.readAll();
//        ObservableList<Store> observableStores = FXCollections.observableArrayList(store);
//        storeTable.setItems(observableStores);
//        storeTitle.setCellValueFactory(new PropertyValueFactory<>(""));
//        storeTable.setItems(observableStores);
//        storeTable.getColumns().setAll(storeTitle,);
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
        staffAddress.setCellValueFactory(new PropertyValueFactory<>("address")); // change to address with OneToOne
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
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("address")); // change to address with OneToOne
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
    void backClick(ActionEvent event) {

    }

    @FXML
    void createClick(ActionEvent event) throws IOException {
        if(actorTab.isSelected()){
//            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/actor.fxml"));
//            Scene scene = new Scene(loader.load());
//            thisStage.setScene(scene);
//            thisStage.show();
            FXMLLoader loader1 = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/actor.fxml"));
            Scene sceneActor = new Scene(loader1.load());
            Stage actorStage = new Stage();
            actorStage.setScene(sceneActor);
            actorStage.initModality(Modality.APPLICATION_MODAL);
            actorStage.showAndWait();
        }
           else if(filmTab.isSelected()){
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/film.fxml"));
            Scene scene = new Scene(loader.load());
            thisStage.setScene(scene);
            thisStage.show();
        }
           else if (addressTab.isSelected()){
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/addresser.fxml"));
            Scene scene = new Scene(loader.load());
            thisStage.setScene(scene);
            thisStage.show();
        }
           else if (customerTab.isSelected()){
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/customer.fxml"));
            Scene scene = new Scene(loader.load());
            thisStage.setScene(scene);
            thisStage.show();
        }
           else if(storeTab.isSelected()){
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/store.fxml"));
            Scene scene = new Scene(loader.load());
            thisStage.setScene(scene);
            thisStage.show();

        }
    }

    @FXML
    void deleteClick(ActionEvent event) throws IOException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                ActorDAO actorDAO = new ActorDAO();
                actorDAO.delete(actorTable.getSelectionModel().getSelectedItem());
            }
        }
        if(filmTab.isSelected()){
            if(!(filmTable.getSelectionModel().getSelectedItem()==null)){
                FilmDAO filmDAO = new FilmDAO();
                filmDAO.delete(filmTable.getSelectionModel().getSelectedItem());
            }
        }
        if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                StaffDAO staffDAO = new StaffDAO();
                staffDAO.delete(staffTable.getSelectionModel().getSelectedItem());
            }
        }
        if(customerTab.isSelected()){
            if(!(customerTable.getSelectionModel().getSelectedItem()==null)){
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.delete(customerTable.getSelectionModel().getSelectedItem());
            }
        }
        if(addressTab.isSelected()){
            if(!(addressTable.getSelectionModel().getSelectedItem()==null)){
                AddressDAO addressDAO = new AddressDAO();
                addressDAO.delete(addressTable.getSelectionModel().getSelectedItem());
            }
        }
    }

    @FXML
    void readClick(ActionEvent event) throws IOException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                Actor actor = actorTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/TextField.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(actor.toStringHeavy());
                thisStage.setScene(scene);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(filmTab.isSelected()){
            if(!(filmTable.getSelectionModel().getSelectedItem()==null)){
                Film film = filmTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/TextField.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(film.toStringHeavy());
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(staffTab.isSelected()){
            if(!(staffTable.getSelectionModel().getSelectedItem()==null)){
                Staff staff = staffTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/TextField.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(staff.toStringHeavy());
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(customerTab.isSelected()){
            if(!(customerTable.getSelectionModel().getSelectedItem()==null)){
                Customer customer = customerTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/TextField.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(customer.toStringHeavy());
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
                if(addressTab.isSelected()){
            if(!(addressTable.getSelectionModel().getSelectedItem()==null)){
                Address address = addressTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/TextField.fxml"));
                Scene scene = new Scene(loader.load());
                Read read = loader.getController();
                read.setText(address.toStringHeavy());
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
    }

    @FXML
    void updateClick(ActionEvent event) throws IOException {
        if(actorTab.isSelected()){
            if(!(actorTable.getSelectionModel().getSelectedItem()==null)){
                Actor actor = actorTable.getSelectionModel().getSelectedItem();
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/upactor.fxml"));
                Scene scene = new Scene(loader.load());
                upActor updateactor = loader.getController();
                updateactor.setFields(actor);
                thisStage.setScene(scene);
                thisStage.show();
            }
        }
    }

}
