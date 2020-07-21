package levelsOfAss5;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * Level 4 background.
 */
public class Level4Sprite implements Sprite {
    private int frameWidth;
    private int frameHeight;
    private String nameOfLevel;

    /**
     * Constructor.
     *
     * @param width  width of the game screen
     * @param height height of the game screen
     * @param name   name of the level
     */
    public Level4Sprite(int width, int height, String name) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.nameOfLevel = name;
    }

    /**
     * this function draws the sprites on the screen.
     *
     * @param d the surface of the game
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#00BFFF"));
        d.fillRectangle(0, 0, this.frameWidth, this.frameHeight);

        int middleOfCircleX = 200;
        int middleOfCircleY = 400;
        d.setColor(Color.decode("#DDE5DB"));
        // the rain for the left cloud
        for (int i = 130; i <= 226; i += 10) {
            d.drawLine(i, middleOfCircleY, i - 25, this.frameHeight);
        }
        // circles for the left cloud
        d.fillCircle(middleOfCircleX - 74, middleOfCircleY, 23);
        d.setColor(Color.decode("#DDE5DB"));
        d.fillCircle(middleOfCircleX - 62, middleOfCircleY + 24, 25);
        d.setColor(Color.decode("#C0C0C0"));
        d.fillCircle(middleOfCircleX - 40, middleOfCircleY - 10, 28);
        d.setColor(Color.decode("#A9A9A9"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 35);
        d.setColor(Color.decode("#A9A9A9"));
        d.fillCircle(middleOfCircleX - 27, middleOfCircleY + 27, 23);

        middleOfCircleX = 700;
        middleOfCircleY = 500;
        d.setColor(Color.decode("#DDE5DB"));
        // rain for the right cloud
        for (int i = 630; i <= 720; i += 10) {
            d.drawLine(i, middleOfCircleY, i - 35, this.frameHeight);
        }
        // circles for the right cloud
        d.fillCircle(middleOfCircleX - 76, middleOfCircleY - 12, 23);
        d.setColor(Color.decode("#DDE5DB"));
        d.fillCircle(middleOfCircleX - 62, middleOfCircleY + 17, 25);
        d.setColor(Color.decode("#C0C0C0"));
        d.fillCircle(middleOfCircleX - 40, middleOfCircleY - 10, 28);
        d.setColor(Color.decode("#A9A9A9"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 35);
        d.setColor(Color.decode("#A9A9A9"));
        d.fillCircle(middleOfCircleX - 27, middleOfCircleY + 27, 23);

        // draw the name of the level
        d.setColor(Color.decode("#95FF95"));
        d.fillRectangle(450, 0, 350, 24);
        d.setColor(Color.BLACK);
        d.drawText(600, 18, this.nameOfLevel, 16);
    }

    /**
     * this function notify the sprite that time has passed.
     * @param dt
     */
    public void timePassed(double dt) {
    }

    /**
     * add the score block to the game as a sprite.
     *
     * @param g the game
     */
    public void addToTheGame(GameLevel g) {
        g.addSprite(this);
    }
}
