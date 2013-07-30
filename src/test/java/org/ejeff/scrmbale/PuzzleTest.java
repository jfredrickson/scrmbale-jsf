package org.ejeff.scrmbale;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PuzzleTest {

    private Puzzle puzzle;

    @Before
    public void setUp() throws Exception {
        Set<Word> words = new HashSet<Word>();
        words.add(new Word("AAAAAA"));
        words.add(new Word("AAAAA"));
        words.add(new Word("AAAA"));
        puzzle = new Puzzle("AAAAAA", words);
    }

    @Test
    public void testKeyLetters() {
        Assert.assertEquals("AAAAAA", puzzle.getKeyLetters());
    }

    @Test
    public void testGetWords() {
        Set<Word> words = puzzle.getWords();
        Assert.assertNotNull(words);
        Assert.assertEquals(3, words.size());
    }

}
