package animations;

import biuoop.DrawSurface;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * The End screen.
 */
public class EndScreen implements Animation {
    private int score;
    private int numOfBallsRemained;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param score              score of the game
     * @param numOfBallsRemained number of remained balls in the game
     */
    public EndScreen(int score, int numOfBallsRemained) {
        this.score = score;
        this.numOfBallsRemained = numOfBallsRemained;
        this.stop = false;
    }

    /**
     * In charge of the logic.
     *
     * @param d  surface
     * @param dt It specifies the amount of seconds passed since the last call
     */
    public void doOneFrame(DrawSurface d, double dt) {
        if (numOfBallsRemained == 0) { // lost
            Image gameOver = null;
            try {
                gameOver = ImageIO.read(new File("endScreen_images/gameOver.jpg"));
            } catch (IOException e) {
                System.exit(0);
            }
            d.drawImage(0, 0, gameOver);
            d.setColor(Color.WHITE);
            d.drawText(300, d.getHeight() - 100, "Your Score Is " + String.valueOf(this.score), 26);

        } else { // win
            Image winGame = null;
            try {
                winGame = ImageIO.read(new File("endScreen_images/winGame.jpg"));
            } catch (IOException e) {
                System.exit(0);
            }
            d.drawImage(0, 0, winGame);
            d.setColor(Color.BLACK);
            d.drawText(240, 560, "Your Score Is " + String.valueOf(this.score), 35);
        }
    }

    /**
     * change the state of should stop.
     *
     * @param state true or false
     */
    public void setStop(boolean state) {
        this.stop = state;
    }

    /**
     * is in charge of stopping condition.
     *
     * @return true or false
     */
    public boolean shouldStop() {
        return this.stop;
    }
}


