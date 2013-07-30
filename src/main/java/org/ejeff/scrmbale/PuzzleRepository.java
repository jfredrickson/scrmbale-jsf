package org.ejeff.scrmbale;

import java.util.Collection;

public interface PuzzleRepository {

    public Puzzle getPuzzle();

    public Puzzle getPuzzle(Collection<Puzzle> exclusions);

}
