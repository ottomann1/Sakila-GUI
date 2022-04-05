package com.example.sakilagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreen {

    @FXML
    private AnchorPane ap;

    @FXML
    void businessClick(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("BusinessTabs.fxml"));
        Scene scene = new Scene(loader.load());
        BusinessTabs businessTabs = loader.getController();
        thisStage.setScene(scene);
        thisStage.show();
    }

    @FXML
    void rentClick(ActionEvent event) {

    }

}
