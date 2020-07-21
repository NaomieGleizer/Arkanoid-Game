//package levels;
//
//import geometry.Point;
//import geometry.Rectangle;
//import sprites.Block;
//import sprites.Sprite;
//import sprites.Velocity;
//
//import java.awt.Color;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Level 1.
// */
//public class DirectHitLevel1 implements LevelInformation {
//    private int frameWidth;
//    private int frameHeight;
//
//    /**
//     * Constructor.
//     *
//     * @param width  width of frame
//     * @param height height of frame
//     */
//    public DirectHitLevel1(int width, int height) {
//        this.frameWidth = width;
//        this.frameHeight = height;
//    }
//
//    /**
//     * @return the number of balls in the level
//     */
//    public int getNumberOfBalls() {
//        return 1;
//    }
//
//    /**
//     * @return the initial velocity of each ball
//     */
//    public List<Velocity> getBallVelocities() {
//        List<Velocity> ballsVelocity = new ArrayList<>();
//        Velocity v = Velocity.fromAngleAndSpeed(270, 8);
//        for (int i = 0; i < this.getNumberOfBalls(); i++) {
//            ballsVelocity.add(v);
//        }
//        return ballsVelocity;
//    }
//
//    /**
//     * @return the speed of the paddle for the level
//     */
//    public int getPaddleSpeed() {
//        return 4;
//    }
//
//    /**
//     * @return the width of the paddle for the level
//     */
//    public int getPaddleWidth() {
//        return 100;
//    }
//
//    /**
//     * @return the level name will be displayed at the top of the screen.
//     */
//    public String getLevelName() {
//        return "Level 1: Direct Hit";
//    }
//
//    /**
//     * @return a sprite with the background of the level
//     */
//    public Sprite getBackground() {
//        return new Level1Sprite(new Point(400, 180), this.frameWidth, frameHeight, this.getLevelName());
//    }
//
//    // The Blocks that make up this level, each block contains
//    // its size, color and location.
//
//    /**
//     * @return the Blocks that make up this level, each block contains its size, color and location.
//     */
//    public List<Block> getBlocks() {
//        Block block = new Block(new Rectangle(new Point(380, 160), 40, 40), 1);
//        block.getCollisionRectangle().setColor(Color.red);
//        List<Block> blocks = new ArrayList<>();
//        blocks.add(block);
//        return blocks;
//    }
//
//    /**
//     * @return the number of Blocks that should be removed before the level is considered to be "cleared".
//     */
//    public int getNumberOfBlocksToRemove() {
//        return this.getBlocks().size();
//    }
//}
