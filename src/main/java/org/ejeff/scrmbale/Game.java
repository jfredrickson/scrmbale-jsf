package org.ejeff.scrmbale;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
        nextRound();
    }

    public boolean guess(String guess) {
        Iterator<Word> wordsIter = currentPuzzle.getWords().iterator();
        while (wordsIter.hasNext()) {
            Word word = wordsIter.next();
            if (!word.isDiscovered() && word.getText().equalsIgnoreCase(guess)) {
                word.setDiscovered(true);
                incrementScore(guess.length() * 100);
                return true;
            }
        }
        return false;
    }

    public void shuffle() {
        currentPuzzle.shuffleLetters();
    }

    public boolean isCurrentPuzzleComplete() {
        return currentPuzzle.isComplete();
    }

    private void incrementScore(int amount) {
        score += amount;
    }

    public void nextRound() {
        completedPuzzles.add(currentPuzzle);
        currentRound++;
        currentPuzzle = puzzleRepository.getPuzzle(completedPuzzles);
        System.out.println("starting next round with puzzle: " + currentPuzzle);
    }

    public Set<Word> getWords() {
        return currentPuzzle.getWords();
    }

    public List<String> getLetters() {
        return currentPuzzle.getLetters();
    }

    public int getScore() {
        return score;
    }

    public int getCurrentRound() {
        return currentRound;
    }

}
