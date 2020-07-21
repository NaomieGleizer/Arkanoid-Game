package listeners;

import game.GameLevel;
import sprites.Ball;
import sprites.Block;
import animations.Counter;

/**
 * Remove a ball from the game.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     *
     * @param game        the game
     * @param ballRemover a counter which counts the number of getBlocks that remain.
     */
    public BallRemover(GameLevel game, Counter ballRemover) {
        this.game = game;
        this.remainingBalls = ballRemover;

    }

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the object that's being hit
     * @param hitter   the sprites.Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}
