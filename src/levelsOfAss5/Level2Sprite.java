package levelsOfAss5;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * Level 2 sprites.Sprite.
 */
public class Level2Sprite implements Sprite {

    private int frameWidth;
    private int frameHeight;
    private String nameOfLevel;

    /**
     * Constructor.
     * @param width width of the game screen
     * @param height height of the game screen
     * @param name name of the level
     */
    public Level2Sprite(int width, int height, String name) {
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
        d.setColor(Color.decode("#B7F1FF"));
        d.fillRectangle(0, 0, this.frameWidth, this.frameHeight);

        int middleOfCircleX = 150;
        int middleOfCircleY = 150;
        // sun rays from the middle of the sun to the getBlocks (y=250)
        d.setColor(Color.decode("#FFE010"));
        for (int i = 1, j = 0; j < this.frameWidth - 25; i++, j += 10) {
            d.drawLine(middleOfCircleX, middleOfCircleY, j, 250);
        }

        // 3 circles for the sun
        d.setColor(Color.decode("#DFE590"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 70);
        d.setColor(Color.decode("#DEC237"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 58);
        d.setColor(Color.decode("#FFE010"));
        d.fillCircle(middleOfCircleX, middleOfCircleY, 44);

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
