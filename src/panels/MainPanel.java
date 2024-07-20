package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// panel for the main page
public class MainPanel extends JPanel {
    private JButton startButton;
    private JButton scoreButton;

    public MainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(0, 50)));

        // title of the main page
        JLabel titleLabel = new JLabel("Gr. 11 Review");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(titleLabel);

        add(Box.createRigidArea(new Dimension(0, 50)));
        // starting button
        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 25));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(startButton);
        // score button
        scoreButton = new JButton("High Scores");
        scoreButton.setFont(new Font("Arial", Font.PLAIN, 25));
        scoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(scoreButton);
    }
    // actionListener for the startButton
    public void addStartButtonListener(ActionListener actionListener) {
        startButton.addActionListener(actionListener);
    }

    // actionListener for the scoreButton
    public void addScoreButtonListener(ActionListener actionListener) {
        scoreButton.addActionListener(actionListener);
    }
}
