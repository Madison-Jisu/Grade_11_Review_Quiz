
import model.Quiz;
import model.Score;
import model.Scores;
import model.StudentTestSheet;
import panels.*;
import persist.QuizRepository;
import persist.ScoresRepository;

import javax.swing.*;
import java.awt.*;

// This the main GUI class
public class ReviewMain extends JFrame {
    private static final Rectangle WINDOW_BOUNDS = new Rectangle(0, 0, 660, 500);
    private static final String StudentName = "Student";
    private static final String StudentID = "123456789";

    private MainPanel mainPanel; // panel for main page
    private SelectSubjectPanel selectSubjectPanel; // panel for selecting the subjects
    private SelectLevelPanel selectLevelPanel; // panel for selecting the levels
    private QuizPanel quizPanel; // panel to take the quiz (questions, multiple choice options)
    private ScoresPanel scoresPanel; // panel to observe the score of the quiz taken

    private QuizRepository quizRepository = new QuizRepository(); // Class to read the quiz file
    private ScoresRepository scoresRepository = new ScoresRepository(); // Class to read or save the score

    private String selectedSubject; // the subject selected by a student
    private String selectedLevel; // the level selected by a student
    private StudentTestSheet studentTestSheet; // the page of the quiz

    // This control the panels of the overall program and
    public ReviewMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(WINDOW_BOUNDS);

        setTitle("Gr. 11 Review");

        mainPanel = new MainPanel();
        selectSubjectPanel = new SelectSubjectPanel();
        selectLevelPanel = new SelectLevelPanel();
        scoresPanel = new ScoresPanel();

        setContentPane(mainPanel);

        setListeners();
    }

    // This controls the action of the buttons in the panel (moving the screens to another)
    private void setListeners() {
        // MainPanel listeners -----------------------------------------------
        mainPanel.addStartButtonListener(e -> {
            setContentPane(selectSubjectPanel);
            revalidate();
        });

        mainPanel.addScoreButtonListener(e -> {
            System.out.println("Score button clicked");
            Scores scores = readScores();
            scoresPanel.setScores(scores);
            setContentPane(scoresPanel);
            revalidate();
        });

        // SelectSubjectPanel listeners --------------------------------------
        selectSubjectPanel.addMathButtonListener(e -> {
            System.out.println("Math button clicked");
            selectedSubject = "Math 20-1";
            selectLevelPanel.setTitle("Math 20-1");
            setContentPane(selectLevelPanel);
            revalidate();
        });

        selectSubjectPanel.addPhysicsButtonListener(e -> {
            System.out.println("Physics button clicked");
            selectedSubject = "Physics 20";
            selectLevelPanel.setTitle("Physics 20");
            setContentPane(selectLevelPanel);
            revalidate();
        });

        selectSubjectPanel.addCSButtonListener(e -> {
            System.out.println("CS button clicked");
            selectedSubject = "CS 20";
            selectLevelPanel.setTitle("CS 20");
            setContentPane(selectLevelPanel);
            revalidate();
        });

        // SelectLevelPanel listeners ----------------------------------------
        selectLevelPanel.addBasicButtonListener(e -> {
            System.out.println("Basic button clicked");
            selectedLevel = "Basic";
            startQuizPanel();
            setContentPane(quizPanel);
            revalidate();
        });

        selectLevelPanel.addNormalButtonListener(e -> {
            System.out.println("Normal button clicked");
            selectedLevel = "Normal";
            startQuizPanel();
            setContentPane(quizPanel);
            revalidate();
        });

        selectLevelPanel.addAdvancedButtonListener(e -> {
            System.out.println("Advanced button clicked");
            selectedLevel = "Advanced";
            startQuizPanel();
            setContentPane(quizPanel);
            revalidate();
        });

        // ScoresPanel listeners ---------------------------------------------
        scoresPanel.addReturnToMainMenuButtonListener(e -> {
            System.out.println("Return to main menu button clicked");
            setContentPane(mainPanel);
            revalidate();
        });

    }

    // After the subject and the level have chosen, and when the quiz is started, this method is being called
    private void startQuizPanel() {
        Quiz quiz = quizRepository.read(selectedSubject, selectedLevel, 10);
        studentTestSheet = new StudentTestSheet(quiz != null ? quiz : Quiz.sample(selectedSubject, selectedLevel));
        studentTestSheet.startTest(StudentName, StudentID);

        quizPanel = new QuizPanel(studentTestSheet);

        quizPanel.addSubmitButtonListener(e -> {
            System.out.println("Submit button clicked");
            saveScores();

            ResultPanel resultPanel = new ResultPanel(studentTestSheet);
            resultPanel.addReturnToMainMenuButtonListener(e1 -> {
                System.out.println("Return to main menu button clicked");
                setContentPane(mainPanel);
                revalidate();
            });
            setContentPane(resultPanel);

            revalidate();
        });
    }

    // Method to read score of the quiz taken by a student
    private Scores readScores() {
        Scores scores = scoresRepository.read(StudentName);
        if (scores == null) {
            return Scores.empty(StudentName);
        }
        return scores;
    }

    // Method to save the score of the quiz taken by a student
    private void saveScores() {
        Scores scores = scoresRepository.read(StudentName);
        if (scores == null) {
            scores = new Scores(StudentName);
        }
        scores.addScore(new Score(studentTestSheet.getSubject(), studentTestSheet.getTestDate(), studentTestSheet.getScore()));
        scoresRepository.save(StudentName, scores);
    }

    // Main method to start GUI
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReviewMain frame = new ReviewMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
