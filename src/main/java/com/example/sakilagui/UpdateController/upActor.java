package com.example.sakilagui.UpdateController;

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

public class upActor {

    @FXML
    private TextField actorFirstNameField;

    @FXML
    private TextField actorLAstNameField;

    private Actor actor;

    public void setFields(Actor actorx){
        actor = actorx;
        actorFirstNameField.setText(actor.getFirstName());
        actorLAstNameField.setText(actor.getLastName());
    }

    @FXML
    void addActorOnClick(ActionEvent event) throws IOException, ClassNotFoundException {
        ActorDAO actorDAO = new ActorDAO();
        actor.setFirstName(actorFirstNameField.getText());
        actor.setLastName(actorLAstNameField.getText());
        actorDAO.update(actor, new Actor());
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/sakilagui/BusinessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();

    }

}
