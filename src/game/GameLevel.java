package game;

import animations.Animation;
import animations.AnimationRunner;
import animations.CountdownAnimation;
import animations.PauseScreen;
import animations.Counter;
import animations.KeyPressStoppableAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import sprites.Ball;
import sprites.Paddle;
import sprites.Block;
import sprites.Sprite;
import sprites.Collidable;
import sprites.SpriteCollection;
import sprites.Velocity;
import sprites.ScoreIndicator;
import sprites.LivesIndicator;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import levels.LevelInformation;
import levels.ColorBackground;

import java.util.List;
import java.awt.Color;

/**
 * The game.
 */
public class GameLevel implements Animation {
    public static final int BORDERS_BLOCKS_SIZE = 25;
    public static final int BLOCKS_HEIGHT = 30;
    public static final double SCORE_BLOCK_HEIGHT = 24;
    public static final int PADDLE_HEIGHT = 25;

    private int frameHeight;
    private int frameWidth;
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter remainedBlocks = new Counter(0);
    private Counter remainedBalls = new Counter(0);
    private static Counter score = null;
    private static Counter numOfLives = null;
    private AnimationRunner runner;
    private boolean running = this.remainedBlocks.getValue() > 0 && this.remainedBalls.getValue() > 0;
    private KeyboardSensor keyboard;
    private LevelInformation level;
    private Paddle paddle;

    /**
     * Constructor.
     *
     * @param levelInformation level of the game
     * @param ar               animation runner
     * @param keyboard         keyboard
     * @param width            width of the screen
     * @param height           height of the screen
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner ar, KeyboardSensor keyboard, int width
            , int height) {
        this.level = levelInformation;
        this.frameWidth = width;
        this.frameHeight = height;
        this.keyboard = keyboard;
        this.runner = ar;
    }

    /**
     * @param c a collidable to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s a sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks, balls and sprites.Paddle, and add them to the game.
     *
     * @param withReset true if its a new game
     */
    public void initialize(boolean withReset) {
        if (withReset) {
            numOfLives = new Counter(7);
            score = new Counter(0);
        }
        BlockRemover blockRemover = new BlockRemover(this, this.remainedBlocks);
        BallRemover ballRemover = new BallRemover(this, this.remainedBalls);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        // Add the background of the level as a sprite to the game
        Sprite backGround = this.level.getBackground();
        backGround.addToTheGame(this);
        // create the lives block;
        this.createLivesBlock();
        // create score block
        this.createScoreBlock();
        // create getBlocks at the borders
        this.createBlocksAtTheBorders();
        // Create a special block that will sit at the bottom of the screen, and will function as a "death region"
        Block killBlock = this.createBottomKillBlock();
        killBlock.addHitListener(ballRemover);

        // creates the blocks
        List<Block> blocks = this.level.getBlocks();
        this.remainedBlocks.increase(this.level.getNumberOfBlocksToRemove());
        for (Block block : blocks) {
            Block currentBlock = new Block(block);
            currentBlock.addToTheGame(this);
            currentBlock.addHitListener(blockRemover);
            currentBlock.addHitListener(scoreTrackingListener);
        }
    }

    /**
     * Create the balls  and the paddle for the game.
     */
    public void createBallsAndPaddle() {
        // create paddle
        Point upperLeftPaddle = new Point((this.frameWidth - this.level.getPaddleWidth()) / 2, this.frameHeight - 25);
        Rectangle paddleRect = new Rectangle(upperLeftPaddle, this.level.getPaddleWidth(), PADDLE_HEIGHT);
        paddleRect.setColor(Color.decode("#FFD700"));
        this.paddle = new Paddle(this.keyboard, BORDERS_BLOCKS_SIZE, this.frameWidth - BORDERS_BLOCKS_SIZE
                , this.level.getPaddleSpeed());
        this.paddle.setShape(paddleRect);
        this.paddle.addToTheGame(this);

        // create the balls
        int numOfBalls = this.level.getNumberOfBalls();
        Ball[] balls = new Ball[numOfBalls];
        List<Velocity> velocities = this.level.getBallVelocities();
        for (int i = 0; i < numOfBalls; i++) {
            int centerX = this.frameWidth / 2;
            Point center = new Point(centerX, this.frameHeight - 32);
            balls[i] = new Ball(center, 8, Color.WHITE);
            balls[i].setVelocity(velocities.get(i));
            // add the ball to the game
            balls[i].addToTheGame(this);
            balls[i].setGameEnvironment(this.environment);
        }
    }

    /**
     * Play one life.
     */
    public void playOneTurn() {
        this.createBallsAndPaddle();
        this.runner.setFramesPerSecond(2); // frames for the countdown
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner.setFramesPerSecond(60); // frames for the game
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

        if (remainedBlocks.getValue() == 0) {
            score.increase(100);
        } else {
            numOfLives.decrease(1);
        }
        this.removeSprite(this.paddle);
        this.removeCollidable(this.paddle);
    }

    /**
     * Remove the sprites.Collidable from the game.
     *
     * @param c sprites.Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);

    }

    /**
     * Remove the sprite from the game.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Crates the getBlocks at the borders.
     */
    public void createBlocksAtTheBorders() {
        Rectangle r1 = new Rectangle(new Point(0, SCORE_BLOCK_HEIGHT), BORDERS_BLOCKS_SIZE
                , this.frameHeight - SCORE_BLOCK_HEIGHT); // left
        Rectangle r2 = new Rectangle(new Point(0, SCORE_BLOCK_HEIGHT), this.frameWidth, BORDERS_BLOCKS_SIZE);  // top
        Rectangle r4 = new Rectangle(new Point(this.frameWidth - BORDERS_BLOCKS_SIZE, SCORE_BLOCK_HEIGHT)      // right
                , BORDERS_BLOCKS_SIZE, this.frameHeight - SCORE_BLOCK_HEIGHT);

        // add them to the game
        Block top = new Block(r1, 0);
        top.setDefaultBackground(new ColorBackground(Color.GRAY));
        top.addToTheGame(this);
        Block left = new Block(r2, 0);
        left.setDefaultBackground(new ColorBackground(Color.GRAY));
        left.addToTheGame(this);
        Block right = new Block(r4, 0);
        right.setDefaultBackground(new ColorBackground(Color.GRAY));
        right.addToTheGame(this);
    }

    /**
     * @return the block which is located below the screen and is responsible for the lost of the balls.
     */
    public Block createBottomKillBlock() {
        Block bottomBlock = new Block(new Rectangle(new Point(0, this.frameHeight), this.frameWidth, BLOCKS_HEIGHT), 0);
        bottomBlock.getCollisionRectangle().setColor(Color.BLACK);
        bottomBlock.addToTheGame(this);
        return bottomBlock;
    }

    /**
     * create the block for the score at top of the screen.
     */
    public void createScoreBlock() {
        ScoreIndicator scoreIndicator = new ScoreIndicator(new Rectangle(new Point(150, 0), this.frameWidth - 400
                , SCORE_BLOCK_HEIGHT), score);
        scoreIndicator.getShape().setColor(Color.CYAN);
        scoreIndicator.addToTheGame(this);
    }

    /**
     * create the block for the lives-indicator at top of the screen.
     */
    public void createLivesBlock() {
        LivesIndicator livesIndicator = new LivesIndicator(new Rectangle(new Point(0, 0), 150
                , SCORE_BLOCK_HEIGHT), this.remainedBalls, numOfLives);
        livesIndicator.getShape().setColor(Color.PINK);
        livesIndicator.addToTheGame(this);
    }

    /**
     * is in charge of the logic.
     *
     * @param d  surface
     * @param dt It specifies the amount of seconds passed since the last call
     */
    public void doOneFrame(DrawSurface d, double dt) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt);
        if (!(this.remainedBlocks.getValue() > 0 && this.remainedBalls.getValue() > 0)) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    /**
     * change the state of should stop.
     *
     * @param state true or false
     */
    public void setStop(boolean state) {
    }

    /**
     * is in charge of stopping condition.
     *
     * @return true or false
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * @return the number of life
     */
    public int getNumOfLife() {
        return numOfLives.getValue();
    }

    /**
     * @return the number of remaining getBlocks
     */
    public int getNumOfRemainedBlocks() {
        return this.remainedBlocks.getValue();
    }

    /**
     * @return the number of remaining balls
     */
    public Counter getNumOfRemainedBall() {
        return this.remainedBalls;
    }

    /**
     * @return the current score
     */
    public int getScore() {
        return score.getValue();
    }

}