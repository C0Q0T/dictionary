package main;

import dictionary.Word;
import javafx.fxml.FXML;

public class ChangeController extends AddWordController {

    @FXML
    public void onSpellingChange() {
        String spellingValue = spellingInput.getText().trim();

        if (this.isExistSpelling()) {
            statusUpdate.setText("Từ đã tồn tại, bạn có thể thay đổi.");
            statusUpdate.setStyle("-fx-text-fill: #03fc2c;");
            isAccept = true;
        } else {
            statusUpdate.setText("Từ không tồn tại, bạn có muốn thêm từ?");
            statusUpdate.setStyle("-fx-text-fill: #f54242;");
            isAccept = false;
//            this.createAlert("Word doesn't exist!", "You can add a new word.");
        }

        if (spellingValue.isEmpty()) {
            statusUpdate.setText("Đang nhập ....");
            statusUpdate.setStyle("-fx-text-fill: #000;");
            isAccept = false;
        }
    }

    @FXML
    public void onSaveBtn() {
        if (isAccept) {
            Word word = new Word(spellingInput.getText().trim(), explainInput.getText().trim());
            dictionaryImprove.removeWord(word.getSpelling());
            dictionaryImprove.addWord(word);
            spellingInput.setText("");
            explainInput.setText("");
            statusUpdate.setText("Đang nhập ....");
            statusUpdate.setStyle("-fx-text-fill: #000;");
            isAccept = false;
        } else {
            System.out.println("Can't add this word");
        }
    }
}
