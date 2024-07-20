package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// panel to select subject
public class SelectSubjectPanel extends JPanel {
    private JButton mathButton; // button to select math 20-1
    private JButton physicsButton; // button to select physics 20
    private JButton csButton; // button to select computer science 20

    public SelectSubjectPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(0, 50)));

        // title
        JLabel titleLabel = new JLabel("Select Subject for Review");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(titleLabel);

        add(Box.createRigidArea(new Dimension(0, 50)));

        // math 20-1 button
        mathButton = new JButton("Math 20-1");
        mathButton.setFont(new Font("Arial", Font.PLAIN, 25));
        mathButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(mathButton);

        // physics 20 button
        physicsButton = new JButton("Physics 20");
        physicsButton.setFont(new Font("Arial", Font.PLAIN, 25));
        physicsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(physicsButton);

        // computer science 20 button
        csButton = new JButton("CS 20");
        csButton.setFont(new Font("Arial", Font.PLAIN, 25));
        csButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(csButton);
    }

    public void addMathButtonListener(ActionListener actionListener) {
        mathButton.addActionListener(actionListener);
    }

    public void addPhysicsButtonListener(ActionListener actionListener) {
        physicsButton.addActionListener(actionListener);
    }

    public void addCSButtonListener(ActionListener actionListener) {
        csButton.addActionListener(actionListener);
    }
}
