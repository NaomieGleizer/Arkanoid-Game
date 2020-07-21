package game;

import animations.AnimationRunner;
import animations.KeyPressStoppableAnimation;
import animations.HighScoresAnimation;
import animations.Animation;
import animations.EndScreen;
import biuoop.DialogManager;
import biuoop.KeyboardSensor;
import levels.LevelInformation;
import scores.HighScoresTable;
import scores.ScoreInfo;

import java.util.List;
import java.io.File;

/**
 * Start the game.
 */
public class StartGameTask implements Task<Void> {
    private AnimationRunner runner;
    private List<LevelInformation> levels;
    private KeyboardSensor keyboard;
    private int frameWidth;
    private int frameHeight;
    private HighScoresTable highScoresTable;
    private File scoresFile;

    /**
     * Constructor.
     *
     * @param animationRunner animation runner
     * @param levels          levels of the game
     * @param k               keyboard
     * @param width           width of the frame
     * @param height          height of the frame
     * @param highScores      high scores animation
     * @param file            score file
     */
    public StartGameTask(AnimationRunner animationRunner, List<LevelInformation> levels, KeyboardSensor k
            , int width, int height, HighScoresTable highScores, File file) {
        this.runner = animationRunner;
        this.levels = levels;
        this.keyboard = k;
        this.frameWidth = width;
        this.frameHeight = height;
        this.highScoresTable = highScores;
        this.scoresFile = file;
    }

    /**
     * run the animation.
     *
     * @return void
     */
    public Void run() {
        int score = 0, remainedBalls = 0;
        boolean startGame = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.runner, this.keyboard, this.frameWidth, this.frameHeight);
            level.initialize(startGame);
            startGame = false;
            // run every level until it's over(lose or win)
            while (level.getNumOfLife() != 0 && level.getNumOfRemainedBlocks() != 0) {
                level.getNumOfRemainedBall().increase(levelInfo.getNumberOfBalls());
                level.playOneTurn();
            }
            score = level.getScore();
            remainedBalls = level.getNumOfRemainedBall().getValue();
            if (level.getNumOfLife() == 0) {
                break;
            }
        }

        // end screen- win or lose
        Animation endScreen = new EndScreen(score, remainedBalls);
        this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, endScreen));
        printHighScores(score);
        return null;
    }

    /**
     * Print high score table.
     *
     * @param score current score
     */
    public void printHighScores(int score) {
        int scoreRank = this.highScoresTable.getRank(score);
        if (scoreRank <= this.highScoresTable.size()) { //new high score
            DialogManager dialog = this.runner.getGui().getDialogManager();
            String name = dialog.showQuestionDialog("Name", "What is your name?", "");
            this.highScoresTable.add(new ScoreInfo(name, score));
            try {
                this.highScoresTable.save(this.scoresFile);
            } catch (Exception e) {
                return;
            }
        }
        Animation highScoresAnimation = new HighScoresAnimation(this.highScoresTable, KeyboardSensor.SPACE_KEY
                , this.keyboard);
        this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, highScoresAnimation));
    }

    /**
     * @return the Animation.
     */
    public Animation getAnimation() {
        return null;
    }
}
