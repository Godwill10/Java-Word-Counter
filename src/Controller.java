import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * The controller class for the word counter application.
 * @author Godwill Afolabi
 */
public class Controller implements ActionListener {

    /** The model of the WordCountModel. */
    private final WordCountModel model = new WordCountModel();

    /** The gui for the WordCountGUI. */
    private final WordCountGUI view;

    /**
     * Creates a controller
     */
    public Controller(){
        view = new WordCountGUI(this);
    }
    /**
     * Performs the actions for the upload and submit buttons.
     * Retrieves the path of the file selected
     * then uses the path to read each line in the file,  
     * count the occurrences of every word, and output a the result in a seperate text file.
     * @param eo The event which occurred, identifying which button was pushed.
     */

    @Override
    public void actionPerformed(ActionEvent eo) {
        String inputFileName = "src/document.txt";
        String outputFileName = "src/output.txt";

        if(eo.getActionCommand().equals("Upload")){
            JFileChooser file_upload = new JFileChooser();
            file_upload.setCurrentDirectory(new File("."));

            int response = file_upload.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
                String path = file_path.toString();
                view.uploadLabel.setText(path);
                inputFileName = path;
            }
        }
        if(eo.getActionCommand().equals("Submit")){
            try {
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

                // Print the message on the WordCountGUI screen
                view.selectLabel.setText("Total word count: " + totalCount);

                // Disable the labels and buttons
                view.uploadLabel.setEnabled(false);
                view.submitLabel.setEnabled(false);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    /**
     * Removes punctuation from a given string.
     *
     * @param s the string to remove punctuation from
     * @return the cleaned string without any punctuation
     */
    protected static String removePunctuations(String s) {
        String punctuation_removed = s.replaceAll("[^a-zA-Z0-9\\s]", "");
        return punctuation_removed;
    }

    /**
     * Removes hyphens from a given string.
     *
     * @param s the string to remove hyphens from
     * @return the cleaned string with hyphens replaced by spaces
     */
    protected static String removeHyphens(String s) {
        String hyphens_removed = s.replaceAll("-", ""); // Replace all hyphens with spaces
        return hyphens_removed;
    }

    /**
     * Gets the total word count from an output file that contains words and their counts.
     *
     * @param outputFileName the path to the output file
     * @return the total number of words in the output file
     * @throws Exception if an error occurs while reading the output file
     */
    protected static int getWordCount(String outputFileName) throws Exception {
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

