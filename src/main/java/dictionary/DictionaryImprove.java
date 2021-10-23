package dictionary;

import feature.IOHTML;
import feature.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DictionaryImprove extends DictionaryManagement {
    @Override
    public void insertFromFile() {
        System.out.println("Start insert from file...");
        IOHTML iohtml = new IOHTML();
        ArrayList<Word> wordArrayList = iohtml.readWord();
        Collections.sort(wordArrayList, new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o1.getSpelling().compareTo(o2.getSpelling());
            }
        });
        dictionary.setWords(wordArrayList);
        System.out.println("End insert from file...");
    }

    @Override
    public void saveWordsToFile() {
        IOHTML iohtml = new IOHTML();
        iohtml.writeWord(dictionary.getWords());
    }

    @Override
    public void addWord(Word word) {
        String explain = word.getExplain();
        if (!explain.startsWith("<html>") || !explain.contains("</html>")) {
            word.setExplain("<html>" + explain + "</html>");
        }

        dictionary.push(word);
        this.saveWordsToFile();
    }

    public void removeWord(Word word) {
        if (word != null) {
            dictionary.getWords().remove(word);
            this.saveWordsToFile();
        }
    }

    public void removeWord(String spelling) {
        Word word = dictionary.lookup(spelling);
        if (word != null) {
            this.removeWord(word);
        }
    }

}
