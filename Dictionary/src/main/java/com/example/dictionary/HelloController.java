package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;

public class HelloController {
    wordDictionary dictionaryList;
    @FXML

    TextField searching;
    @FXML
    TextField add;
    @FXML
    TextField meaning;
    @FXML
    protected void search() {
        //System.out.println("Searching the Word");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();
        if(searching.textProperty().get().equals("")){
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText("Alert");
            warning.setContentText("Please Enter a Word");
            warning.showAndWait();
        }
        else if (dictionaryList.getWordlist().containsKey(searching.textProperty().get())){
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setHeaderText("Searching");
            infoAlert.setContentText(dictionaryList.getWordlist().get(searching.textProperty().get()));
            infoAlert.showAndWait();
            //System.out.println(dictionaryList.getWordlist().get(searching.textProperty().get()));
        }
        else{
            //System.out.println("Not Found");
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText("Not Found");
            warning.setContentText("Add this Word in Your Dictionary");
            warning.showAndWait();
        }


    }
    @FXML
    protected void add() throws IOException {
        //System.out.println("New Word Added");
        dictionaryList = new wordDictionary();
        dictionaryList.deserializeMap();
        if (add.textProperty().get().equals("")) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText("Alert");
            warning.setContentText("Please Enter a Word");
            warning.showAndWait();
        } else if (meaning.textProperty().get().equals("")) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText("Alert");
            warning.setContentText("Please Enter the Meaning of Word");
            warning.showAndWait();
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.CONFIRMATION);
            infoAlert.setHeaderText("New Word Adding");
            dictionaryList.addWord(add.textProperty().get(), meaning.textProperty().get());
            dictionaryList.serializeMap();
            infoAlert.setContentText("New Word added in Your Dictionary");
            infoAlert.showAndWait();
        }
    }
}