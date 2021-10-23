package main;

import dictionary.DictionaryImprove;
import dictionary.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AddWordController implements Initializable {
    DictionaryImprove dictionaryImprove = new DictionaryImprove();
    protected WebEngine engine;

    boolean isAccept = false;

    @FXML
    protected TextField spellingInput;

    @FXML
    protected TextField explainInput;

    @FXML
    protected Label statusUpdate;

    @FXML
    protected WebView explainInputOld;

    @FXML
    public void onSpellingChange() {
        String spellingValue = spellingInput.getText().trim();

        if (this.isExistSpelling()) {
            statusUpdate.setText("Từ này đã tồn tại, bạn chỉ có thể thay đổi");
            statusUpdate.setStyle("-fx-text-fill: #fa5252;");


            isAccept = false;
        } else {
            statusUpdate.setText("Bạn có thể thêm từ này");
            statusUpdate.setStyle("-fx-text-fill: #40c057;");

            isAccept = true;
//            this.createAlert("Word doesn't exist!", "You can add a new word.");
        }

        if (spellingValue.isEmpty()) {
            statusUpdate.setText("Hãy nhập từ");
            statusUpdate.setStyle("-fx-text-fill: #495057;");
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
            statusUpdate.setText("Thêm từ thành công");
            statusUpdate.setStyle("-fx-text-fill: #495057;");
            isAccept = false;
        } else {
            statusUpdate.setText("Thêm từ thất bại");
            statusUpdate.setStyle("-fx-text-fill: #fa5252;");
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
