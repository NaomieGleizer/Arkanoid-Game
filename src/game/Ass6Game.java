package game;

import animations.AnimationRunner;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import scores.HighScoresTable;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Assignment 6 game.
 */
public class Ass6Game {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    /**
     * Main of the game.
     *
     * @param args arguments
     * @throws Exception if fail reading a file
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("level_sets.txt"));

        HighScoresTable highScoresTable;
        File highScoresFile = new File("src/highscores.txt");
        if (!highScoresFile.exists()) {
            highScoresTable = new HighScoresTable(4);
        } else {
            highScoresTable = HighScoresTable.loadFromFile(highScoresFile);
        }
        highScoresTable.save(highScoresFile);

        // run the game
        GUI gui = new GUI("Arkanoid", FRAME_WIDTH, FRAME_HEIGHT);
        AnimationRunner animationRunner = new AnimationRunner(gui);
        KeyboardSensor keyboard = animationRunner.getGui().getKeyboardSensor();
        GameFlow game = new GameFlow(animationRunner, keyboard, FRAME_WIDTH, FRAME_HEIGHT, highScoresTable
                , highScoresFile);
        game.openMenu(bufferedReader);
    }

}
