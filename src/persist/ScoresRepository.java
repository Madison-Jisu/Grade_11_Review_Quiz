package persist;

import java.io.*;
import model.Scores;

// Class to read and save the score
public class ScoresRepository {
    public void save(String studentName, Scores scores) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(studentName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(scores);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(studentName + "'s score is saved.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Scores read(String studentName) {
        Scores scores;
        try {
            FileInputStream fileInputStream = new FileInputStream(studentName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            scores = (Scores) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(studentName + "'s score was read.");
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return scores;
    }
}
