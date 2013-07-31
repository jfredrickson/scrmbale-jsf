package org.ejeff.scrmbale.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.ejeff.scrmbale.Game;

@ManagedBean(name = "game")
@ViewScoped
public class GameBacking implements Serializable {

    private static final long serialVersionUID = 1L;

    private Game game;

    private String wordInput;

    public GameBacking() {
        game = new Game();
        game.startRound();
    }

    public String submitWord() {
        return null;
    }

    public String getWordInput() {
        return wordInput;
    }

    public void setWordInput(String wordInput) {
        this.wordInput = wordInput;
    }

}
