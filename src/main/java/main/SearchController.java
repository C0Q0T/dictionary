package main;

import interaction.BookmarkInteraction;
import interaction.DictionaryInteraction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController extends ViewController {
    protected BookmarkInteraction bookmarkInteraction = new BookmarkInteraction();
    protected DictionaryInteraction dictionaryInteraction = new DictionaryInteraction();
    public ArrayList<String> words = dictionaryInteraction.getStringSpelling();

    @FXML
    protected Button bookmarkFilledStar;

    @FXML
    protected Button bookmarkStar;

    public void loadWord() {
        System.out.println("Start load word");
        listViewWord.getItems().setAll(words);
        btnDelete.setVisible(false);
    }

    @FXML
    public void onSelectListView(MouseEvent e) {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        if (spelling == null) return;

        if (isExistBookmark(spelling)) {
            loadOptionOn();
        } else {
            loadOptionOff();
        }
        String explain = dictionaryInteraction.dictionaryLookup(spelling).getExplain();

        spellingWord.setText(spelling);
        engine = explainWord.getEngine();
        engine.loadContent(explain);
        actionSearch(spelling);
    }

    @FXML
    public void onChangeSearchField(KeyEvent event) {
        if (event.getSource() == searchFieldWord) {
            String searchText = searchFieldWord.getText();
            if (!searchText.isEmpty()) {
                listViewWord.getItems().setAll(dictionaryInteraction.getStringSpelling(searchText));
            } else {
                listViewWord.getItems().setAll(words);
            }
        }
    }

    @FXML
    public void deleteWord() {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        dictionaryInteraction.removeWord(dictionaryInteraction.dictionaryLookup(spelling));
        words = dictionaryInteraction.getStringSpelling();
        listViewWord.getItems().setAll(dictionaryInteraction.getStringSpelling(searchFieldWord.getText()));
        hideAllOption();
        engine.loadContent("");
    }

    @FXML
    public void onClickStar() {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        bookmarkInteraction.removeWord(spelling);
        loadOptionOn();

    }

    @FXML
    public void onClickFilledStar() {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        bookmarkInteraction.addWord(dictionaryInteraction.dictionaryLookup(spelling));
        loadOptionOff();

    }

    public void loadOptionOn() {
        btnDelete.setVisible(true);
        bookmarkFilledStar.setVisible(true);
        bookmarkStar.setVisible(false);
    }

    public void loadOptionOff() {
        btnDelete.setVisible(true);
        bookmarkFilledStar.setVisible(false);
        bookmarkStar.setVisible(true);
    }

    public void hideAllOption() {
        btnDelete.setVisible(false);
        bookmarkFilledStar.setVisible(false);
        bookmarkStar.setVisible(false);
    }

    public boolean isExistBookmark(String spelling) {
        return bookmarkInteraction.dictionaryLookup(spelling) != null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadWord();
    }
}
