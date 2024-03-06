package io.codeforall.ourgame;

import java.io.*;
public class HighScoreManager {
    private static final String FILENAME = System.getProperty("user.home") + File.separator + "highscore.txt";

    public static void saveHighScore(int highScore) {
        File file = new File(FILENAME);
        File directory = file.getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            System.err.println("Failed to create directory: " + directory.getAbsolutePath());
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            writer.write(Integer.toString(highScore));
        } catch (IOException e) {
            System.err.println("Error saving high score: " + e.getMessage());
        }
    }

    public static int loadHighScore() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            return 0;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                Score.highScore = Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading high score: " + e.getMessage());
        }
        return Score.highScore;
    }
}