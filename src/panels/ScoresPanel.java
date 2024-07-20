package panels;

import model.Scores;
import table.ScoresTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// the collection of the scores of each subject
public class ScoresPanel extends JPanel {
    private JTable scoresTable; // table for the score
    private JButton returnToMainMenuButton; // returnToMainMenuButton to return to the main page

    // drawing the table
    public ScoresPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(0, 50)));

        // title of the table
        JLabel titleLabel = new JLabel("High Scores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        add(Box.createRigidArea(new Dimension(0, 30)));

        // create the table
        scoresTable = new JTable(10, 2);
        JScrollPane scrollPane = new JScrollPane(scoresTable);
        add(scrollPane);

        add(Box.createRigidArea(new Dimension(0, 10)));

        returnToMainMenuButton = new JButton("Return to Main Menu");
        returnToMainMenuButton.setAlignmentX(CENTER_ALIGNMENT);
        add(returnToMainMenuButton);
    }

    // actionListener for the button to return to the main page
    public void addReturnToMainMenuButtonListener(ActionListener actionListener) {
        returnToMainMenuButton.addActionListener(actionListener);
    }

    // From the score object, create the table model to show the data to the table component
    public void setScores(Scores scores) {
        scoresTable.setModel(new ScoresTableModel(scores));
    }
}
