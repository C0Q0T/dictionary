package main;

import interaction.BookmarkInteraction;
import interaction.DictionaryInteraction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane main_frame;

    @FXML
    private Button btn_nav_find, btn_nav_change, btn_nav_add, btn_google_translate;

    private AnchorPane anchorAddPane = null;
    private AnchorPane anchorBookmarkPane = null;
    private AnchorPane anchorHistoryPane = null;
    private AnchorPane anchorSearchPane = null;
    private AnchorPane anchorEditPane = null;

    private AnchorPane currentPane;

    @FXML
    protected void showAddPane() {
        resetStyle();
        btn_nav_add.setStyle("-fx-background-color: #748ffc");
        loadPage("add");
    }
    @FXML
    protected void showChangePane() {
        resetStyle();
        btn_nav_change.setStyle("-fx-background-color: #748ffc");
        loadPage("changeword");
    }
    @FXML
    protected void showSearchPane() {
        resetStyle();
        btn_nav_find.setStyle("-fx-background-color: #748ffc");
        loadPage("search");
    }

//    @FXML
//    protected void showBookmarkPane() {
//        loadPage("bookmark");
//    }
    @FXML
    protected void showGoogleTranslatePane() {
        resetStyle();
        btn_google_translate.setStyle("-fx-background-color: #748ffc");
        loadPage("translategoogle");
    }

    @FXML
    protected void resetStyle() {
        btn_nav_find.setStyle("-fx-background-color:  inherit");
        btn_nav_change.setStyle("-fx-background-color:  inherit");
        btn_nav_add.setStyle("-fx-background-color:  inherit");
        btn_google_translate.setStyle("-fx-background-color: #4c6ef5");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSearchPane();
    }

}
