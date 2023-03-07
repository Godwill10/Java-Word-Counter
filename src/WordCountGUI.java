import javax.swing.*;
import java.awt.*;

/**
 * The Word Counter application graphical user interface.
 * An instance of this gui contains a reference to the Controller.
 * @author Godwill Afolabi
 */
public class WordCountGUI extends JFrame {

    protected final JLabel selectLabel = new JLabel( "Select file: ");
    protected final JButton uploadLabel = new JButton( "Upload");
    protected final JButton submitLabel = new JButton( "Submit");

    /**
     * Creates a WordCountGui application.
     * Sets the components and their positions in the gui.
     * Sets the Controller as the buttons' action listener.
     */
    public WordCountGUI(Controller controller){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(selectLabel);
        panel.add(uploadLabel);
        panel.add(submitLabel);

        frame.setTitle("Word Counter");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setResizable( true);
        frame.pack();
        frame.setVisible(true);

        this.submitLabel.addActionListener( controller);
        this.uploadLabel.addActionListener(controller);

    }
}