package listeners;

import game.GameLevel;
import sprites.Ball;
import sprites.Block;
import animations.Counter;

/**
 * a listeners.BlockRemover is in charge of removing getBlocks from the game, as well as keeping count
 * of the number of getBlocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param game          the game
     * @param removedBlocks a counter which counts the number of getBlocks that remain.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Remove Blocks that are hit and reach 0 hit-points and remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit the block which is being hit
     * @param hitter   the ball which hits the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 0) {
            beingHit.removeHitListener(this);
            beingHit.removeFromGame(this.game);
            this.remainingBlocks.decrease(1);
        }
    }
}