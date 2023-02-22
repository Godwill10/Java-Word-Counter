package src;
/*
 * src.WordCount.java
 * Contains the main to create the src.WordCount application.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Driver class for the Word Count application.
 *
 * @author Godwill Afolabi
 */

public class WordCount {

    /**
     * Runs the word count program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String inputFileName = "src/document.txt";
            String outputFileName = "src/output.txt";

            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            Map<String, Integer> wordCount = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {

                String hyphenRemovedLine = removeHyphens(line);

                String cleanedLine = removePunctuations(hyphenRemovedLine);

                String[] words = cleanedLine.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();
                    if (!wordCount.containsKey(word)) {
                        wordCount.put(word, 1);
                    } else {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            for (String word : wordCount.keySet()) {
                writer.write(word + ": " + wordCount.get(word) + "\n");
            }

            writer.close();

            int totalCount = getWordCount(outputFileName);
            System.out.println("Total word count: " + totalCount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Removes punctuation from a given string.
     *
     * @param s the string to remove punctuation from
     * @return the cleaned string without any punctuation
     */
    private static String removePunctuations(String s) {
        String punctuation_removed = s.replaceAll("[^a-zA-Z0-9\\s]", "");
        return punctuation_removed;
    }

    /**
     * Removes hyphens from a given string.
     *
     * @param s the string to remove hyphens from
     * @return the cleaned string with hyphens replaced by spaces
     */
    private static String removeHyphens(String s) {
        String hyphens_removed = s.replaceAll("-", " "); // Replace all hyphens with spaces
        return hyphens_removed;
    }

    /**
     * Gets the total word count from an output file that contains words and their counts.
     *
     * @param outputFileName the path to the output file
     * @return the total number of words in the output file
     * @throws Exception if an error occurs while reading the output file
     */
    private static int getWordCount(String outputFileName) throws Exception {
        int totalCount = 0;
        BufferedReader reader = new BufferedReader(new FileReader(outputFileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] wordCount = line.split("\\s*:\\s*");
            if (wordCount.length == 2) {
                totalCount += Integer.parseInt(wordCount[1]);
            }
        }
        reader.close();
        return totalCount;
    }
}


