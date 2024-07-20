package model;
// This presents the questions and choices and the answers for the quiz
public class Question {
    private String question; // Question
    private String[] choices; // Choices (options) for the quiz program that can be chosen by the questions
    private int correctChoice;  // 0, 1, 2, 3 (zero-based index) (the answer of the questions)

    public Question(String question, String[] choices, int correctChoice) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getCorrectChoice() {
        return correctChoice;
    }
}
