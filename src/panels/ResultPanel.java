package panels;

import model.Question;
import model.Quiz;
import model.StudentTestSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// panel for looking at the result of the quiz (scores)
public class ResultPanel extends JPanel {
    private StudentTestSheet testSheet; // page of the quiz students are taking

    private JButton returnToMainMenuButton; // Button to return to the main page

    // Create the results of the quiz
    public ResultPanel(StudentTestSheet testSheet) {
        this.testSheet = testSheet;
        Quiz quiz = testSheet.getQuiz();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Rendering the page for the results of the quiz (correct or incorrect)
        JPanel questionsPanel = questionsResultPanel(quiz);
        JScrollPane scrollPane = new JScrollPane(questionsPanel);
        add(scrollPane);

        add(Box.createRigidArea(new Dimension(0, 10)));

        //  button to return to the main page
        returnToMainMenuButton = new JButton("Return to Main Menu");
        returnToMainMenuButton.setAlignmentX(CENTER_ALIGNMENT);
        add(returnToMainMenuButton);
    }

    // Rendering the page for the results of the quiz (correct or incorrect)
    private JPanel questionsResultPanel(Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        Question[] questions = quiz.getQuestions();
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            JPanel questionPanel = questionResultPanel(question, i);
            panel.add(questionPanel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return panel;
    }

    // A single result of a question
    private JPanel questionResultPanel(Question question, int questionIndex) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel(question.getQuestion());
        panel.add(label);

        int correctAnswer = question.getCorrectChoice();
        int studentAnswer = testSheet.getStudentAnswer().getAnswer(questionIndex);
        boolean correct = testSheet.getStudentAnswer().getCorrect(questionIndex);

        String[] choices = question.getChoices();
        for (int i = 0; i < choices.length; i++) {
            String choice = choices[i];

            choice = "   " + choice;

            if (i == studentAnswer) {
                choice = choice + " (YourAnswer)";
            }
            if (i == correctAnswer) {
                choice = choice + " (CorrectAnswer)";
            }

            JLabel optionLabel = new JLabel(choice);
            panel.add(optionLabel);
        }

        if (correct) {
            JLabel correctLabel = new JLabel("Correct");
            correctLabel.setForeground(Color.BLUE);
            panel.add(correctLabel);
        } else {
            JLabel incorrectLabel = new JLabel("Incorrect");
            incorrectLabel.setForeground(Color.RED);
            panel.add(incorrectLabel);
        }

        return panel;
    }

    // ButtonListener to return to main button
    public void addReturnToMainMenuButtonListener(ActionListener actionListener) {
        returnToMainMenuButton.addActionListener(actionListener);
    }
}
