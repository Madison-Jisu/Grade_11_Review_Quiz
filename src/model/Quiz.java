package model;

// This class represents the questions for each subject and the levels
public class Quiz {
    private String subject; // Represents the name of the subjects: Math 20-1, Physics 20, CS 20
    private String level;   // Represents the lavel of the subjects: Basic, Normal, Advanced
    private Question[] questions; // Set of the questions

    public Quiz(String subject, String level, int numQuestions) {
        this.subject = subject;
        this.level = level;
        this.questions = new Question[numQuestions];
    }

    public String getSubject() {
        return subject;
    }

    public String getLevel() {
        return level;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestion(Question question, int index) {
        this.questions[index] = question;
    }

    public static Quiz sample(String subject, String level) {
        Quiz quiz = new Quiz(subject, level, 10);

        Question question1 = new Question("1. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 0);
        quiz.setQuestion(question1, 0);

        Question question2 = new Question("2. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 1);
        quiz.setQuestion(question2, 1);

        Question question3 = new Question("3. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 2);
        quiz.setQuestion(question3, 2);

        Question question4 = new Question("4. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 3);
        quiz.setQuestion(question4, 3);

        Question question5 = new Question("5. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 0);
        quiz.setQuestion(question5, 4);

        Question question6 = new Question("6. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 1);
        quiz.setQuestion(question6, 5);

        Question question7 = new Question("7. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 2);
        quiz.setQuestion(question7, 6);

        Question question8 = new Question("8. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 3);
        quiz.setQuestion(question8, 7);

        Question question9 = new Question("9. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 0);
        quiz.setQuestion(question9, 8);

        Question question10 = new Question("10. What is the answer to this question?", new String[]{"a) Option 1", "b) Option 2", "c) Option 3", "d) Option 4"}, 1);
        quiz.setQuestion(question10, 9);
        return quiz;
    }
}
