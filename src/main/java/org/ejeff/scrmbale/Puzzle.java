package org.ejeff.scrmbale;

import java.util.Arrays;
import java.util.Set;

public class Puzzle {

    private String keyLetters;
    private char[] letters;
    private Set<Word> words;
    private String recentEntry;

    public Puzzle(String keyLetters, Set<Word> words) {
        this.keyLetters = keyLetters;
        this.letters = keyLetters.toCharArray();
        this.words = words;
        this.recentEntry = null;
    }

    public boolean isComplete() {
        for (Word word : words) {
            if (!word.isDiscovered()) {
                return false;
            }
        }
        return true;
    }

    public String getKeyLetters() {
        return keyLetters;
    }

    public char[] getLetters() {
        return letters;
    }

    public Set<Word> getWords() {
        return words;
    }

    public String getRecentEntry() {
        return recentEntry;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keyLetters.toCharArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Puzzle)) return false;

        Puzzle other = (Puzzle) obj;
        return keyLetters.equals(other.keyLetters);
    }

    @Override
    public String toString() {
        return "[Puzzle " + keyLetters + "]";
    }
}
