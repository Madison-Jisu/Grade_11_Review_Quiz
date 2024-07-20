package model;

// This class contains the response of the quiz answered by students
public class StudentAnswer {
    private int[] answers; // Set of the answers
    private boolean[] corrects; // Set of the correct or incorrect answers responded by students

    public StudentAnswer(int numQuestions) {
        answers = new int[numQuestions];
        for (int i = 0; i < numQuestions; i++) {
            answers[i] = -1;
        }
        corrects = new boolean[numQuestions];
    }

    public int getCorrectRate() {
        int numCorrects = 0;
        for (boolean correct : corrects) {
            if (correct) {
                numCorrects++;
            }
        }
        return (int) ((double) numCorrects / corrects.length * 100);
    }

    public void setAnswer(int questionIndex, int answerIndex) {
        answers[questionIndex] = answerIndex;
    }

    public void setCorrect(int questionIndex, boolean correct) {
        corrects[questionIndex] = correct;
    }

    public int getAnswer(int questionIndex) {
        return answers[questionIndex];
    }

    public boolean getCorrect(int questionIndex) {
        return corrects[questionIndex];
    }
}
