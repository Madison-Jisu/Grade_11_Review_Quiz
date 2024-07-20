package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Scores implements Serializable {
    private String studentName; // Name of the student
    private ArrayList<Score> scores = new ArrayList<>(); // The overall score of the quiz taken in each trial

    public Scores(String studentName) {
        this.studentName = studentName;
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public String getStudentName() {
        return studentName;
    }

    // Finding the the specific score of the quiz with the name of the subject and the index of the quiz
    public Score getSubjectResult(String subject, int index) {
        ArrayList<Score> subjectScores = findSubjectScores(subject);
        if (index < subjectScores.size()) {
            return subjectScores.get(index);
        } else {
            return Score.empty();
        }
    }

    // Search all of the score of the quiz taken in each trial based on the subjects
    private ArrayList<Score> findSubjectScores(String subject) {
        ArrayList<Score> subjectScores = new ArrayList<>();
        for (Score score : scores) {
            if (score.getSubject().equals(subject)) {
                subjectScores.add(score);
            }
        }
        return subjectScores;
    }

    // Search the maximum number of the quiz taken within the subjects
    // The result in this method is used in building the table of the score (high score)
    public int maxSubjectResultCount(String[] subjects) {
        int max = 0;
        for (String subject : subjects) {
            int subjectResultCount = findSubjectScores(subject).size();
            if (subjectResultCount > max) {
                max = subjectResultCount;
            }
        }
        return max;
    }

    public static Scores empty(String studentName) {
        return new Scores(studentName);
    }

    public static Scores sample() {
        Scores scores = new Scores("Student");
        scores.addScore(new Score("Math 20-1", "2020-09-01", "90%"));
        scores.addScore(new Score("Math 20-1", "2020-09-08", "95%"));
        scores.addScore(new Score("Math 20-1", "2020-09-15", "100%"));
        scores.addScore(new Score("Physics 20", "2020-09-22", "100%"));
        return scores;
    }
}
