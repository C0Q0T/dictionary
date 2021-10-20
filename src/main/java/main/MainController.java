package main;

import dictionary.Word;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import feature.IOFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainController {
    @FXML
    private BorderPane main_frame;

    @FXML
    protected void addWord() {
        loadPage("add");
    }
    @FXML
    protected void changeWord() {
        loadPage("changeword");
    }
    @FXML
    protected void findWord() {
        loadPage("search");
    }
    @FXML
    protected void bookmark() {
        loadPage("bookmark");
    }

    private void loadPage(String page) {
        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource( page + ".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        main_frame.setCenter(root);
    }


}
