package main;

import interaction.BookmarkInteraction;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookmarkController extends ViewController {
    private BookmarkInteraction bookmarkInteraction = new BookmarkInteraction();

    public ArrayList<String> words = bookmarkInteraction.getStringSpelling();

    @FXML
    public void onSelectListView(MouseEvent e) {
        String spelling = listViewWord.getSelectionModel().getSelectedItem();
        System.out.println(spelling);
        String explain = bookmarkInteraction.dictionaryLookup(spelling).getExplain();
        if (spelling == null) return;
        spellingWord.setText(spelling);
        engine = explainWord.getEngine();
        engine.loadContent(explain);
        actionSearch(spelling);
    }



    public void loadWord() {
        System.out.println("Start load word");
        listViewWord.getItems().setAll(words);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadWord();
    }
}
