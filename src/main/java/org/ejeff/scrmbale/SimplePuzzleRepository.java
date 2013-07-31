package org.ejeff.scrmbale;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SimplePuzzleRepository implements PuzzleRepository {

    private Map<String, Puzzle> puzzles;

    public SimplePuzzleRepository() {
        puzzles = new LinkedHashMap<String, Puzzle>();

        Set<Word> words1 = new LinkedHashSet<Word>();
        words1.add(new Word("REDDER"));
        words1.add(new Word("ERRED"));
        words1.add(new Word("REED"));
        words1.add(new Word("DEER"));
        words1.add(new Word("DEED"));
        words1.add(new Word("RED"));
        words1.add(new Word("ERR"));
        words1.add(new Word("ERE"));
        Puzzle puzzle1 = new Puzzle("DDEERR", words1);

        Set<Word> words2 = new LinkedHashSet<Word>();
        words2.add(new Word("EXTERN"));
        words2.add(new Word("EXERT"));
        words2.add(new Word("ENTER"));
        words2.add(new Word("TREE"));
        words2.add(new Word("TERN"));
        words2.add(new Word("TEEN"));
        words2.add(new Word("RENT"));
        words2.add(new Word("NEXT"));
        words2.add(new Word("TEN"));
        words2.add(new Word("TEE"));
        words2.add(new Word("RET"));
        words2.add(new Word("NET"));
        words2.add(new Word("NEE"));
        words2.add(new Word("ERE"));
        Puzzle puzzle2 = new Puzzle("EENRTX", words2);

        Set<Word> words3 = new LinkedHashSet<Word>();
        words3.add(new Word("BACKUP"));
        words3.add(new Word("PUCK"));
        words3.add(new Word("PACK"));
        words3.add(new Word("BUCK"));
        words3.add(new Word("BACK"));
        words3.add(new Word("PUB"));
        words3.add(new Word("CUP"));
        words3.add(new Word("CUB"));
        words3.add(new Word("CAP"));
        words3.add(new Word("CAB"));
        Puzzle puzzle3 = new Puzzle("ABCKPU", words3);

        puzzles.put(puzzle1.getKeyLetters(), puzzle1);
        puzzles.put(puzzle2.getKeyLetters(), puzzle2);
        puzzles.put(puzzle3.getKeyLetters(), puzzle3);
    }

    @Override
    public Puzzle getPuzzle() {
        // Just get the first puzzle.
        return puzzles.get("DDEERR");
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
