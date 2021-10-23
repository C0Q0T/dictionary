package main;

import feature.GoogleTranslate;
import feature.TextToSpeech;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TranslateGoogleController implements Initializable {
    GoogleTranslate translates = new GoogleTranslate();
    TextToSpeech textToSpeech = new TextToSpeech();

    @FXML
    protected TextArea spellingWord;

    @FXML
    protected TextArea explainWord;

    public void onTranslate() {
        String spelling = spellingWord.getText();
        String explain = null;
        try {
            explain = translates.translate("en", "vi", spelling);
        } catch (IOException e) {
            e.printStackTrace();
        }
        explainWord.setText(explain);
    }

    public void onAudio() {
        String spelling = spellingWord.getText();
        textToSpeech.makeSound(spelling);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spellingWord.setWrapText(true);
        explainWord.setWrapText(true);
    }
}
