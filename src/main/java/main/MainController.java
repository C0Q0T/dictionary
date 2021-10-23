package main;

import interaction.BookmarkInteraction;
import interaction.DictionaryInteraction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane main_frame;

    private AnchorPane anchorAddPane = null;
    private AnchorPane anchorBookmarkPane = null;
    private AnchorPane anchorHistoryPane = null;
    private AnchorPane anchorSearchPane = null;
    private AnchorPane anchorEditPane = null;

    private AnchorPane currentPane;

    @FXML
    protected void showAddPane() {
        loadPage("add");
    }
    @FXML
    protected void showChangePane() {
        loadPage("changeword");
    }
    @FXML
    protected void showSearchPane() {
        loadPage("search");
    }
    @FXML
    protected void showBookmarkPane() {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSearchPane();
    }

}
