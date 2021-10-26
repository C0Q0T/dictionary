package main;

import feature.TextToSpeech;
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
  //  protected BookmarkInteraction bookmarkInteraction = new BookmarkInteraction();
    protected DictionaryInteraction dictionaryInteraction = new DictionaryInteraction();
    public ArrayList<String> words = dictionaryInteraction.getStringSpelling();
    protected TextToSpeech textToSpeech = new TextToSpeech();

    @FXML
    protected Button btnDelete;

    @FXML
    protected Button btnAudio;

    public void loadWord() {
        System.out.println("Start load word");
        listViewWord.getItems().setAll(words);
        btnDelete.setVisible(false);
    }

    @FXML
    public void onSelectListView(MouseEvent e) {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        if (spelling == null) return;
        String explain = dictionaryInteraction.dictionaryLookup(spelling).getExplain();

        spellingWord.setText(spelling);
        engine = explainWord.getEngine();
        engine.loadContent(explain);
        showAllOption();
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
        spellingWord.setText("xóa thành công");
        spellingWord.setStyle("-fx-text-fill: #40c057;");
        engine.loadContent("");
        hideAllOption();
    }

    @FXML
    public void onAudio() {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        textToSpeech.makeSound(spelling);
    }

    public void showAllOption() {
        btnDelete.setVisible(true);
        btnAudio.setVisible(true);

    }

    public void hideAllOption() {
        btnDelete.setVisible(false);
        btnAudio.setVisible(false);

    }

//    public boolean isExistBookmark(String spelling) {
//        return bookmarkInteraction.dictionaryLookup(spelling) != null;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hideAllOption();
        loadWord();
    }
}
