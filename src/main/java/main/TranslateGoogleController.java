package main;

import feature.GoogleTranslate;
import feature.TextToSpeech;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    protected Button exchange_btn;
    @FXML
    protected Button voice_l;
    @FXML
    protected Button voice_r;

    private String from = "en";
    private String to = "vi";
    private boolean v_l = true;
    private boolean v_r = false;

    public void onTranslate() {
        String spelling = spellingWord.getText();
        String explain = null;
        try {
            explain = translates.translate(from, to, spelling);
        } catch (IOException e) {
            e.printStackTrace();
        }
        explainWord.setText(explain);

    }
    public void on_exchange() {
        if(from == "en") {
            from = "vi";
            to = "en";
            spellingWord.setText("");
            explainWord.setText("");
            spellingWord.setPromptText("Tiếng Việt");
            explainWord.setPromptText("Tiếng Anh");
            v_l = false;
             v_r = true;
        } else {
            from = "en";
            to = "vi";
            spellingWord.setText("");
            explainWord.setText("");
            spellingWord.setPromptText("Tiếng Anh");
            explainWord.setPromptText("Tiếng Việt");
            v_l = true;
            v_r = false;

        }
        voice_l.setVisible(v_l);
        voice_r.setVisible(v_r);
    }

    public void onAudio() {
        String text;
        if(v_l) {
            text = spellingWord.getText();
        } else {
            text = explainWord.getText();
        }
        textToSpeech.makeSound(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spellingWord.setWrapText(true);
        explainWord.setWrapText(true);
        voice_l.setVisible(true);
        voice_r.setVisible(false);
    }
}
