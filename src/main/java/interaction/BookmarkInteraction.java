package interaction;

import dictionary.DictionaryImprove;
import dictionary.Word;
import feature.IOHTML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookmarkInteraction extends DictionaryInteraction {
    public void insertFromFile() {
        System.out.println("Start insert bookmark from file.");
        IOHTML rd = new IOHTML();
        ArrayList<Word> adds = rd.readWord("src/main/resources/data/bookmark.txt");
        Collections.sort(adds, new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o1.getSpelling().compareTo(o2.getSpelling());
            }
        });
        dictionary.setWords(adds);
        System.out.println("End insert bookmark from file.");
    }

    public void saveWordsToFile() {
        IOHTML iohtml = new IOHTML();
        iohtml.writeWord(dictionary.getWords(), "src/main/resources/data/bookmark.txt");
    }

    public ArrayList<String> getStringSpelling() {
        ArrayList<Word> words = this.getWords();
        ArrayList<String> result = new ArrayList<>();

        for (Word word : words) {
            result.add(word.getSpelling());
        }

        return result;
    }
}
