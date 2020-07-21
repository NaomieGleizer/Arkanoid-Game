package listeners;

import sprites.Ball;
import sprites.Block;
import animations.Counter;

/**
 * Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter current score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * notify that a hit has occurred.
     *
     * @param beingHit the block which is being hit
     * @param hitter   the ball which hits the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() > 0) {
            this.currentScore.increase(5);
        } else if (beingHit.getHitPoints() == 0) {
            this.currentScore.increase(10);
        }
    }
}