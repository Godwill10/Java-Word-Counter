import javax.swing.*;
import java.awt.*;

public class WordCountGUI extends JFrame{

    private final JLabel selectLabel = new JLabel( "Select file: ");
    private final JButton submitLabel = new JButton( "Submit");


    public WordCountGUI(Controller controller){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(90, 90, 30, 90));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(selectLabel);
        panel.add(submitLabel);

        frame.setTitle("Word Counter");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setResizable( false);
        frame.pack();
        frame.setVisible(true);

        this.submitLabel.addActionListener( controller);

    }
}