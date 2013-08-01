package org.ejeff.scrmbale.util;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class PuzzleListGeneratorTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File dictionaryFile;
    private File puzzlesFile;

    @Before
    public void setUp() throws Exception {
        dictionaryFile = new File(this.getClass().getResource("/PuzzleListGeneratorTestDictionary.txt").getFile());
        puzzlesFile = new File(folder.getRoot(), "puzzles.txt");
    }

    @Test
    public void testGenerate() throws Exception {
        PuzzleListGenerator.generate(dictionaryFile, puzzlesFile);
        Scanner s = new Scanner(puzzlesFile);
        Assert.assertTrue(s.nextLine().startsWith("EENRTX"));
        Assert.assertTrue(s.nextLine().startsWith("DDEERR"));
        Assert.assertTrue(s.nextLine().startsWith("ABCKPU"));
        Assert.assertFalse(s.hasNext());
        s.close();
    }
}
