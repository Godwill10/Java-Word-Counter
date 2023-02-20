import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public void actionPerformed(ActionEvent e) {

    }
}
