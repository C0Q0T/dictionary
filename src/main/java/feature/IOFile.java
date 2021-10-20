package feature;

import dictionary.Word;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class IOFile {

    public IOFile() {
    }

    public ArrayList<Word> readWord() {
        ArrayList<Word> words = this.readWord("src/main/resources/data/dictionary.txt");
        return words;
    }

    public ArrayList<Word> readWord(String path) {
        String line;
        String[] tempWord;
        ArrayList<Word> words = new ArrayList<>();

        try {
            InputStreamReader inputStreamReader  = new InputStreamReader(new FileInputStream(path));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((line = bufferedReader.readLine()) != null) {
                tempWord = line.split("   ");

                if (tempWord.length >= 2) {
                    words.add(new Word(tempWord[0], tempWord[1]));
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open '" + path + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public void write(ArrayList<Word> words) {
        this.write(words, "src/main/resources/data/dictionary.txt");
    }

    public void write(ArrayList<Word> words, String path) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Word word : words) {
                bufferedWriter.write(word.getSpelling() + "\t" + word.getExplain());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
