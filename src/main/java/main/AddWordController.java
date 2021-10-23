package main;

import dictionary.DictionaryImprove;
import dictionary.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddWordController implements Initializable {
    DictionaryImprove dictionaryImprove = new DictionaryImprove();

    boolean isAccept = false;

    @FXML
    protected TextField spellingInput;

    @FXML
    protected TextField explainInput;

    @FXML
    protected Label statusUpdate;

    @FXML
    public void onSpellingChange() {
        String spellingValue = spellingInput.getText().trim();

        if (this.isExistSpelling()) {
            statusUpdate.setText("Word existed!, you can only edit word.");
            statusUpdate.setStyle("-fx-text-fill: #f54242;");
            isAccept = false;
        } else {
            statusUpdate.setText("You can add this word");
            statusUpdate.setStyle("-fx-text-fill: #03fc2c;");
            isAccept = true;
//            this.createAlert("Word doesn't exist!", "You can add a new word.");
        }

        if (spellingValue.isEmpty()) {
            statusUpdate.setText("Please typing word");
            statusUpdate.setStyle("-fx-text-fill: #000;");
            isAccept = false;
        }
    }

    public void onAddBtn() {
        if (isAccept) {
            Word word = new Word(spellingInput.getText().trim(), explainInput.getText().trim());
            dictionaryImprove.removeWord(word.getSpelling());
            dictionaryImprove.addWord(word);
            spellingInput.setText("");
            explainInput.setText("");
            statusUpdate.setText("Please typing word");
            statusUpdate.setStyle("-fx-text-fill: #000;");
            isAccept = false;
        } else {
            System.out.println("Can't add this word");
        }
    }

    protected boolean isExistSpelling() {
        String spellingValue = spellingInput.getText().trim();
        Word word = dictionaryImprove.dictionaryLookup(spellingValue);
        return word != null && word.getSpelling().equals(spellingValue);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
