package levelsOfAss5;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * Background of the third level.
 */
public class Level3Sprite implements Sprite {

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
    public Level3Sprite(int width, int height, String name) {
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
        // background color
        d.setColor(Color.decode("#7AFF5F"));
        d.fillRectangle(0, 0, this.frameWidth, this.frameHeight);

        d.setColor(Color.BLACK);
        d.fillRectangle(60, 450, 100, 170);
        d.setColor(Color.WHITE);
        for (int x = 68; x < 140; x += 23) {
            for (int y = 458; y <= 600; y += 31) {
                d.fillRectangle(x, y, 15, 23);
            }
        }
        d.setColor(Color.decode("#464646"));
        d.fillRectangle(93, 395, 30, 55);
        d.setColor(Color.decode("#5F5F5F"));
        d.fillRectangle(102, 195, 12, 200);

        int middleOfCircleX = 108;
        int middleOfCircleY = 195;
        // 3 circles for the "light of the radar"
        d.setColor(Color.decode("#FFEE4B"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 15);
        d.setColor(Color.red);
        d.fillCircle(middleOfCircleX, middleOfCircleY, 11);
        d.setColor(Color.white);
        d.fillCircle(middleOfCircleX, middleOfCircleY, 6);

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
