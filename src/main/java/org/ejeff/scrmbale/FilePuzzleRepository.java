package org.ejeff.scrmbale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FilePuzzleRepository implements PuzzleRepository {

    private List<Puzzle> puzzles;

    public FilePuzzleRepository() {
        puzzles = new LinkedList<Puzzle>();
        File puzzleFile = new File(this.getClass().getResource("/puzzles.txt").getFile());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(puzzleFile));
            String line;
            while ((line = br.readLine()) != null) {
                List<String> tokens = Arrays.asList(line.split(","));
                String key = tokens.get(0);
                Set<Word> words = new LinkedHashSet<Word>();
                boolean firstToken = true;
                for (String word : tokens) {
                    if (!firstToken) words.add(new Word(word));
                    firstToken = false;
                }
                puzzles.add(new Puzzle(key, words));
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read the puzzles file.");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

        Collections.shuffle(puzzles);
    }

    @Override
    public Puzzle getPuzzle() {
        return puzzles.get(0);
    }

    @Override
    public Puzzle getPuzzle(Collection<Puzzle> exclusions) {
        for (Puzzle potential : puzzles) {
            if (!exclusions.contains(potential)) {
                return potential;
            }
        }
        return null;
    }

}
