package persist;

import model.Question;
import model.Quiz;

import java.io.*;

// Class to read the quiz file
public class QuizRepository {
    public Quiz read(String subject, String level, int numQuestions) {
        Quiz quiz = new Quiz(subject, level, numQuestions);
        try {
            FileInputStream fileInputStream = new FileInputStream(subject + "_" + level + ".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            for (int i = 0; i < numQuestions; i++) {
                String questionString = bufferedReader.readLine();
                String[] choices = {
                        bufferedReader.readLine(),
                        bufferedReader.readLine(),
                        bufferedReader.readLine(),
                        bufferedReader.readLine()
                };
                String correct = bufferedReader.readLine();
                Question question = new Question(questionString, choices, Integer.parseInt(correct));
                quiz.setQuestion(question, i);

                bufferedReader.readLine();
            }
            bufferedReader.close();
            fileInputStream.close();

            return quiz;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
