package main;

import interaction.BookmarkInteraction;
import interaction.DictionaryInteraction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    protected WebEngine engine;

    @FXML
    protected TextField searchFieldWord;

    @FXML
    protected WebView explainWord;

    @FXML
    protected Label spellingWord;

    @FXML
    protected ListView<String> listViewWord;



    public void actionSearch(String spelling) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
