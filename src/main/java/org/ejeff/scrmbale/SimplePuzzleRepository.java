package org.ejeff.scrmbale;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SimplePuzzleRepository implements PuzzleRepository {

    private Map<String, Puzzle> puzzles;

    public SimplePuzzleRepository() {
        puzzles = new HashMap<String, Puzzle>();

        Set<Word> words1 = new LinkedHashSet<Word>();
        words1.add(new Word("EXTERN"));
        words1.add(new Word("EXERT"));
        words1.add(new Word("ENTER"));
        words1.add(new Word("TREE"));
        words1.add(new Word("TERN"));
        words1.add(new Word("TEEN"));
        words1.add(new Word("RENT"));
        words1.add(new Word("NEXT"));
        words1.add(new Word("TEN"));
        words1.add(new Word("TEE"));
        words1.add(new Word("RET"));
        words1.add(new Word("NET"));
        words1.add(new Word("NEE"));
        words1.add(new Word("ERE"));
        Puzzle puzzle1 = new Puzzle("EENRTX", words1);

        Set<Word> words2 = new LinkedHashSet<Word>();
        words2.add(new Word("BACKUP"));
        words2.add(new Word("PUCK"));
        words2.add(new Word("PACK"));
        words2.add(new Word("BUCK"));
        words2.add(new Word("BACK"));
        words2.add(new Word("PUB"));
        words2.add(new Word("CUP"));
        words2.add(new Word("CUB"));
        words2.add(new Word("CAP"));
        words2.add(new Word("CAB"));
        Puzzle puzzle2 = new Puzzle("ABCKPU", words2);

        puzzles.put(puzzle1.getKeyLetters(), puzzle1);
        puzzles.put(puzzle2.getKeyLetters(), puzzle2);
    }

    @Override
    public Puzzle getPuzzle() {
        // Just get the first puzzle.
        return puzzles.get("EENRTX");
    }

    @Override
    public Puzzle getPuzzle(Collection<Puzzle> exclusions) {
        for (Puzzle potential : puzzles.values()) {
            if (!exclusions.contains(potential)) {
                return potential;
            }
        }
        return null;
    }
}
