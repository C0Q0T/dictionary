package interaction;

import dictionary.DictionaryImprove;
import dictionary.Word;

import java.util.ArrayList;

public class DictionaryInteraction extends DictionaryImprove {

    public ArrayList<String> getStringSpelling() {
        ArrayList<Word> words = this.getWords();
        ArrayList<String> result = new ArrayList<>();

        for (Word word : words) {
            result.add(word.getSpelling());
        }

        return result;
    }

    public ArrayList<String> getStringSpelling(String spelling) {
        ArrayList<Word> words = this.dictionarySearcher(spelling);
        ArrayList<String> result = new ArrayList<>();

        for (Word word : words) {
            result.add(word.getSpelling());
        }

        return result;
    }
}
