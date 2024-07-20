package model;

import java.io.Serializable;

// This class represents the scores earned by students after taking the quiz
// This saves the mark of the students
public class Score implements Serializable {
    private String subject; // Type of the test (subjects/levels)
    private String date; // Date of the quiz taken
    private String score; // Score of the quiz in percentage

    public Score(String subject, String date, String score) {
        this.subject = subject;
        this.date = date;
        this.score = score;
    }

    public static Score empty() {
        return new Score("", "", "");
    }

    public String getSubject() {
        return subject;
    }

    public String getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }
}
