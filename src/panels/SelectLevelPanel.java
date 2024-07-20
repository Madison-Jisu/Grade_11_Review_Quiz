package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// The page to select the lavel
public class SelectLevelPanel extends JPanel {

    private JLabel titleLabel;
    private JButton basicButton;
    private JButton normalButton;
    private JButton advancedButton;

    // panel for selecting the level
    public SelectLevelPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(Box.createRigidArea(new Dimension(0, 50)));

        // title
        titleLabel = new JLabel("empty");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(titleLabel);

        add(Box.createRigidArea(new Dimension(0, 50)));

        // Basic button
        basicButton = new JButton("Basic");
        basicButton.setFont(new Font("Arial", Font.PLAIN, 25));
        basicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(basicButton);

        // Normal button
        normalButton = new JButton("Normal");
        normalButton.setFont(new Font("Arial", Font.PLAIN, 25));
        normalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(normalButton);

        // Advanced button
        advancedButton = new JButton("Advanced");
        advancedButton.setFont(new Font("Arial", Font.PLAIN, 25));
        advancedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(advancedButton);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    public void addBasicButtonListener(ActionListener actionListener) {
        basicButton.addActionListener(actionListener);
    }

    public void addNormalButtonListener(ActionListener actionListener) {
        normalButton.addActionListener(actionListener);
    }

    public void addAdvancedButtonListener(ActionListener actionListener) {
        advancedButton.addActionListener(actionListener);
    }
}
