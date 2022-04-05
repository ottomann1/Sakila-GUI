package com.example.sakilagui.AddController;

import Business.Actor;
import DAO.ActorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class actor {

    @FXML
    private TextField actorFirstNameField;

    @FXML
    private TextField actorLAstNameField;

    @FXML
    void addActorOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Actor actor = new Actor();
        actor.setFirstName(actorFirstNameField.getText());
        actor.setLastName(actorLAstNameField.getText());
        ActorDAO actorDAO = new ActorDAO();
        actorDAO.create(actor);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/BusinessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}
