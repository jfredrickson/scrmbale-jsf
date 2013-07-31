package org.ejeff.scrmbale;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimplePuzzleRepositoryTest {

    private SimplePuzzleRepository repo;

    @Before
    public void setUp() throws Exception {
        repo = new SimplePuzzleRepository();
    }

    @Test
    public void test() {
        Set<Puzzle> exclusions = new HashSet<Puzzle>();

        Puzzle puzzle1 = repo.getPuzzle();
        Assert.assertNotNull(puzzle1);
        Assert.assertEquals(6, puzzle1.getKeyLetters().length());
        exclusions.add(puzzle1);

        Puzzle puzzle2 = repo.getPuzzle(exclusions);
        Assert.assertNotNull(puzzle2);
        Assert.assertEquals(6, puzzle2.getKeyLetters().length());
        exclusions.add(puzzle2);

        Puzzle puzzle3 = repo.getPuzzle(exclusions);
        Assert.assertNotNull(puzzle3);
        Assert.assertEquals(6, puzzle3.getKeyLetters().length());
        exclusions.add(puzzle3);

        Puzzle nonexistentPuzzle = repo.getPuzzle(exclusions);
        Assert.assertNull(nonexistentPuzzle);
    }

}
