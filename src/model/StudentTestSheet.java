package model;

import java.text.SimpleDateFormat;
import java.util.Date;

// This presents the test sheet that students use to take the quiz
public class StudentTestSheet {
    private final Quiz quiz; // Quiz
    private String studentName; // Name of the student
    private String studentId; // Id of the student
    private String testDate; // Date of the quiz taken
    private StudentAnswer studentAnswer; // Response of the student

    public StudentTestSheet(Quiz quiz) {
        this.quiz = quiz;
    }

    // When a student started the quiz, it saves the input values of the students (name, id)
    public void startTest(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        this.studentAnswer = new StudentAnswer(quiz.getQuestions().length);
    }

    public String getSubject() {
        return quiz.getSubject();
    }

    public String getScore() {
        return studentAnswer.getCorrectRate() + "%";
    }

    // When a student choose on of the option in the multiple choice, this method determines whether the response is correct or incorrect
    public void answer(int questionIndex, int answerIndex) {
        studentAnswer.setAnswer(questionIndex, answerIndex);

        Question question = quiz.getQuestions()[questionIndex];
        int correctChoice = question.getCorrectChoice();
        boolean correct = correctChoice == answerIndex;
        studentAnswer.setCorrect(questionIndex, correct);

        System.out.println("Answer " + answerIndex + ": " + correct);
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTestDate() {
        return testDate;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public StudentAnswer getStudentAnswer() {
        return studentAnswer;
    }

}
