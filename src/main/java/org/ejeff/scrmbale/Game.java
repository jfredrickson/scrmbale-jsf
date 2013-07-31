package org.ejeff.scrmbale;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game {

    private PuzzleRepository puzzleRepository;
    private int score;
    private int currentRound;
    private Set<Puzzle> completedPuzzles;
    private Puzzle currentPuzzle;

    public Game() {
        puzzleRepository = new SimplePuzzleRepository();
        score = 0;
        currentRound = 0;
        completedPuzzles = new HashSet<Puzzle>();
        currentPuzzle = puzzleRepository.getPuzzle();
    }

    public boolean enterGuess(String guess) {
        Iterator<Word> wordsIter = currentPuzzle.getWords().iterator();
        while (wordsIter.hasNext()) {
            Word word = wordsIter.next();
            if (!word.isDiscovered() && word.getText().equalsIgnoreCase(guess)) {
                word.setDiscovered(true);
                incrementScore(word.getText().length() * 100);
                return true;
            }
        }
        return false;
    }

    private void incrementScore(int amount) {
        score += amount;
    }

    public Puzzle startRound() {
        currentRound++;
        currentPuzzle = puzzleRepository.getPuzzle(completedPuzzles);
        return currentPuzzle;
    }

    public void endRound() {
        completedPuzzles.add(currentPuzzle);
        currentPuzzle = null;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
