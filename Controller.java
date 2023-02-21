import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Controller implements ActionListener {

    /** The model of the WordCountModel. */
    private final WordCountModel model = new WordCountModel();

    /** The gui for the WordCountGUI. */
    private final WordCountGUI view;

    public Controller(){
        view = new WordCountGUI(this);
        view.setVisible( true);
    }

    @Override
    public void actionPerformed(ActionEvent eo) {

        if(eo.getActionCommand().equals("Upload")){
            JFileChooser file_upload = new JFileChooser();
            file_upload.setCurrentDirectory(new File("."));

            int response = file_upload.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
                System.out.println(file_path);
            }
        }
        if(eo.getActionCommand().equals("Submit")){
            try {
                String inputFileName = "document.txt";
                String outputFileName = "output.txt";
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                Map<String, Integer> wordCount = new HashMap<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}

