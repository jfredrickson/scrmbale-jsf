package org.ejeff.scrmbale;

import java.util.Arrays;

public class Word {

    private String text;
    private boolean discovered;

    public Word(String text) {
        this.text = text;
        this.discovered = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(text.toCharArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Word)) return false;

        Word other = (Word) obj;
        return text.equals(other.text);
    }

    @Override
    public String toString() {
        return "[Word " + text.toUpperCase() + "]";
    }

}
