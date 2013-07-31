package org.ejeff.scrmbale.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ejeff.scrmbale.Game;
import org.ejeff.scrmbale.Word;

@ManagedBean(name = "game")
@ViewScoped
public class GameBacking implements Serializable {

    private static final long serialVersionUID = 1L;

    private Game game;

    private String wordInput;

    public GameBacking() {
        game = new Game();
    }

    public String submitWord() {
        game.guess(wordInput);
        if (game.isCurrentRoundComplete()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "Complete!"));
        }
        return null;
    }

    public String nextRound() {
        game.nextRound();
        return null;
    }

    public String shuffle() {
        game.shuffle();
        return null;
    }

    public String getWordInput() {
        return wordInput;
    }

    public void setWordInput(String wordInput) {
        this.wordInput = wordInput;
    }

    public List<String> getWords() {
        List<String> words = new LinkedList<String>();
        for (Word word : game.getWords()) {
            if (word.isDiscovered()) {
                words.add(word.getText());
            } else {
                String blanks = new String(new char[word.getText().length()]).replace("\0", "_ ");
                words.add(blanks);
            }
        }
        return words;
    }

    public int getScore() {
        return game.getScore();
    }

    public int getRoundNumber() {
        return game.getCurrentRound();
    }

    public List<String> getLetters() {
        return game.getLetters();
    }

    public boolean isRoundComplete() {
        return game.isCurrentRoundComplete();
    }
}
