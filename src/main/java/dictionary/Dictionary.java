package dictionary;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();

    public void push(Word word) {
        int len = words.size();
        int vt = search_vt(0, len - 1, word.getSpelling());
        if (vt <= len && vt >= 0) {
            words.add(vt, word);
        }
    }

    private int search_vt(int start, int end, String spelling) {
        if (end < start) {
            return start;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == words.size()) {
                return mid;
            }
            Word word = words.get(mid);
            int cmp = word.getSpelling().compareTo(spelling);
            if (cmp == 0) {
                return -1;
            }
            if (cmp > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public Word lookup(String spelling) {

        int len = words.size();
        int start = 0;
        int end = len - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            Word word = words.get(mid);
            String currentSpelling = word.getSpelling();
            int cmp = currentSpelling.compareTo(spelling);
            if (cmp == 0) {
                return word;
            } else if (cmp > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;

    }

    public ArrayList<Word> searcher(String spelling) {
        ArrayList<Word> result = new ArrayList<>();
        int vt = -1;
        int start = 0;
        int end = words.size() - 1;
        int mid;
        if (start > end) {
            vt = -1;
        } else {
            while (start <= end) {
                mid = (start + end) / 2;
                Word word = words.get(mid);
                String currentSpelling = word.getSpelling();
                if (currentSpelling.startsWith(spelling)) {
                    vt = mid;
                    break;
                }
                int cmp = currentSpelling.compareTo(spelling);
                if (cmp == 0) {
                    vt = mid;
                    break;
                } else if (cmp > 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        if (vt >= 0) {
            result.add(words.get(vt));
            int left = vt - 1, right = vt + 1;

            while (left >= 0) {
                Word leftWord = words.get(left--);
                if (leftWord.getSpelling().startsWith(spelling))
                    result.add(leftWord);
                else
                    break;
            }
            int length = words.size();
            while (right < length) {
                Word leftWord = words.get(right++);
                if (leftWord.getSpelling().startsWith(spelling))
                    result.add(leftWord);
                else
                    break;
            }
        }
        return result;
    }

    public ArrayList<Word> getWords () {
        return words;
    }

    public void setWords (ArrayList < Word > words) {
        this.words = words;
    }

}
