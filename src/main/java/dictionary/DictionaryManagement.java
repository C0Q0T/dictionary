package dictionary;

//import app.helpers.IODictionaries;

import feature.IOFile;

import java.util.ArrayList;

public class DictionaryManagement {
    protected Dictionary dictionary = new Dictionary();

    public DictionaryManagement() {
        this.insertFromFile();
    }

    /*
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        String spelling = scanner.nextLine();
        String explain = scanner.nextLine();
        Word word = new Word(spelling, explain);
        dictionary.push(word);
    }
    */

    public void insertFromFile() {
        IOFile rd = new IOFile();
    //        dictionary.setWords(rd.read());   //TODO: Sort
        ArrayList<Word> adds = rd.readWord();
        for (Word add : adds) {
                dictionary.push(add);
            }
        }

    public void saveWordsToFile() {
        IOFile ioDictionaries = new IOFile();
        ioDictionaries.writeWord(dictionary.getWords(), "src/main/resources/data/dictionary.txt");
    }

    public void addWord(Word word) {
        dictionary.push(word);
        this.saveWordsToFile();
    }


    public Word dictionaryLookup(String text) {
        return dictionary.lookup(text);
    }



    public ArrayList<Word> dictionarySearcher(String searchText) {
        if (searchText.equals("")) return new ArrayList<>();
        return dictionary.searcher(searchText);
    }

    public void dictionaryExportToFile() {
        IOFile iod = new IOFile();
        iod.writeWord(dictionary.getWords());
    }

    public ArrayList<Word> getWords() {
        return dictionary.getWords();
    }
}
