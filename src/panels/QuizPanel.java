package panels;

import model.Question;
import model.Quiz;
import model.StudentTestSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// panel for selecting the subjects
public class QuizPanel extends JPanel {
    private StudentTestSheet testSheet;
    private JButton submitButton;

    public QuizPanel(StudentTestSheet testSheet) {
        this.testSheet = testSheet;
        Quiz quiz = testSheet.getQuiz();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Create the panel for questions and allow the user to scroll the page
        JPanel questionsPanel = questionsPanel(quiz);
        JScrollPane scrollPane = new JScrollPane(questionsPanel);
        add(scrollPane);

        add(Box.createRigidArea(new Dimension(0, 10)));

        // submit button
        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(CENTER_ALIGNMENT);
        add(submitButton);
    }

    // Panel for the question
    private JPanel questionsPanel(Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Rendering every questions
        Question[] questions = quiz.getQuestions();
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            JPanel questionPanel = questionPanel(question, i);
            panel.add(questionPanel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return panel;
    }

    // Rendering each of the questions (a single question)
    private JPanel questionPanel(Question question, int questionIndex) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel(question.getQuestion());
        panel.add(label);

        // Make the group of the radio button
        ButtonGroup buttonGroup = new ButtonGroup();
        String[] choices = question.getChoices();
        for (int i = 0; i < choices.length; i++) {
            String choice = choices[i];
            JRadioButton radioButton = new JRadioButton(choice);
            int choiceIndex = i;
            radioButton.addActionListener(e -> {
                System.out.println("Question " + question.getQuestion() + " selected");
                this.testSheet.answer(questionIndex, choiceIndex);
            });
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        return panel;
    }

    // actionlistener for the submit button
    public void addSubmitButtonListener(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }

}
