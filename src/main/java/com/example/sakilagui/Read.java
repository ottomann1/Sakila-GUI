package com.example.sakilagui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Read {

    @FXML
    private TextArea textField;

    void setText(String text){textField.setText(text);}
}