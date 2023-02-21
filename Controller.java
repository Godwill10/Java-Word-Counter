import java.awt.event.ActionEvent;
import java.io.*;

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


    }
}

