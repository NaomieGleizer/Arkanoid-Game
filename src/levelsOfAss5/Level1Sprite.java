package levelsOfAss5;

import biuoop.DrawSurface;
import game.GameLevel;
import geometry.Point;
import sprites.Sprite;

import java.awt.Color;

/**
 * Level 1 background.
 */
public class Level1Sprite implements Sprite {
    private Point middleCircles;
    private int frameWidth;
    private int frameHeight;
    private String nameOfLevel;

    /**
     * Constructor.
     *
     * @param middle the middle of the "sun"
     * @param width  width of the game screen
     * @param height height of the game screen
     * @param name   name of the level
     */
    public Level1Sprite(Point middle, int width, int height, String name) {
        this.middleCircles = middle;
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
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, this.frameWidth, this.frameHeight);

        d.setColor(Color.BLUE);
        int middleOfCircleX = (int) this.middleCircles.getX();
        int middleOfCircleY = (int) this.middleCircles.getY();
        d.drawCircle(middleOfCircleX, middleOfCircleY, 150);
        d.drawCircle(middleOfCircleX, middleOfCircleY, 110);
        d.drawCircle(middleOfCircleX, middleOfCircleY, 70);

        d.drawLine(this.frameWidth / 2, 0, this.frameWidth / 2, 340);
        d.drawLine(middleOfCircleX - 170, middleOfCircleY, middleOfCircleX + 170, middleOfCircleY);

        // draw the name of the level
        d.setColor(Color.decode("#95FF95"));
        d.fillRectangle(450, 0, 350, 24);
        d.setColor(Color.BLACK);
        d.drawText(600, 18, this.nameOfLevel, 16);
    }

    /**
     * this function notify the sprite that time has passed.
     * @param dt dt
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
