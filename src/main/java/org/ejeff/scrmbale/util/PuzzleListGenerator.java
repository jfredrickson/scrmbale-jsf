package org.ejeff.scrmbale.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PuzzleListGenerator {

    public static void main(String[] args) {
        File dictionaryFile = new File("src/main/resources/dictionary.txt");
        File puzzlesFile = new File("src/main/resources/puzzles.txt");
        if (!dictionaryFile.exists()) {
            System.out.println("Dictionary file doesn't exist: " + dictionaryFile.getAbsolutePath());
            System.exit(1);
        }
        if (puzzlesFile.exists()) {
            System.out.println("Puzzle file already exists: " + puzzlesFile.getAbsolutePath());
            System.exit(1);
        }
        System.out.println("Generating puzzles...");
        generate(dictionaryFile, puzzlesFile);
        System.out.println("Done!");
    }

    public static void generate(File dictionaryInputFile, File puzzleOutputFile) {
        Set<String> keys = new HashSet<String>();
        List<String> words = new ArrayList<String>();

        // Read in the dictionary
        System.out.println("Reading dictionary...");
        BufferedReader br = null;
        try {
            String word;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dictionaryInputFile)));
            while ((word = br.readLine()) != null) {
                words.add(word.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate a list of unique keys
        System.out.println("Generating unique keys...");
        for (String word : words) {
            if (word.length() == 6) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                keys.add(new String(chars));
            }
        }

        // Write out the puzzle list
        System.out.println("Finding puzzles...");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(puzzleOutputFile);
            for (String key : keys) {
                System.out.println("Finding puzzles for key: " + key);
                List<String> puzzleWords = new LinkedList<String>();
                for (String word : words) {
                    char[] chars = word.toCharArray();
                    boolean match = true;
                    for (char c : chars) {
                        if (key.indexOf(c) == -1) {
                            match = false;
                        }
                    }
                    if (match) puzzleWords.add(word);
                }
                if (puzzleWords.size() >= 4) {
                    Collections.sort(puzzleWords, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            if (o1.length() < o2.length()) {
                                return 1;
                            } else if (o1.length() > o2.length()) {
                                return -1;
                            }
                            return o1.compareTo(o2);
                        }
                    });
                    StringBuilder sb = new StringBuilder(key);
                    for (String s : puzzleWords) {
                        sb.append("," + s);
                    }
                    writer.println(sb);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

}
