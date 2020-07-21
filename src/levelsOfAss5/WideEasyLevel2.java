//package levels;
//
//import geometry.Point;
//import geometry.Rectangle;
//import sprites.Block;
//import sprites.Sprite;
//import sprites.Velocity;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.awt.Color;
//
//
///**
// * Level 2.
// */
//public class WideEasyLevel2 implements LevelInformation {
//    private int frameWidth;
//    private int frameHeight;
//
//    /**
//     * Constructor.
//     *
//     * @param width  width of frame
//     * @param height height of frame
//     */
//    public WideEasyLevel2(int width, int height) {
//        this.frameWidth = width;
//        this.frameHeight = height;
//    }
//
//    /**
//     * @return the number of balls in the level
//     */
//    public int getNumberOfBalls() {
//        return 10;
//    }
//
//    /**
//     * @return the initial velocity of each ball
//     */
//    public List<Velocity> getBallVelocities() {
//        List<Velocity> ballsVelocity = new ArrayList<>();
//        for (int i = 0, v = 225; i < this.getNumberOfBalls(); i++, v += 10) {
//            Velocity vel = Velocity.fromAngleAndSpeed(v, 8);
//            ballsVelocity.add(vel);
//        }
//        return ballsVelocity;
//    }
//
//    /**
//     * @return the speed of the paddle for the level
//     */
//    public int getPaddleSpeed() {
//        return 2;
//    }
//
//    /**
//     * @return the width of the paddle for the level
//     */
//    public int getPaddleWidth() {
//        return 650;
//    }
//
//    /**
//     * @return the level name will be displayed at the top of the screen.
//     */
//    public String getLevelName() {
//        return "Level 2: Wide Easy";
//    }
//
//    /**
//     * @return a sprite with the background of the level
//     */
//    public Sprite getBackground() {
//        return new Level2Sprite(this.frameWidth, frameHeight, this.getLevelName());
//    }
//
//    /**
//     * @return the Blocks that make up this level, each block contains its size, color and location.
//     */
//    public List<Block> getBlocks() {
//        List<Block> blocks = new ArrayList<>();
//        Block block;
//        int blockWidth = (this.frameWidth - 50) / 15;
//        int indexColor = 0;
//        Color[] blocksColors = {Color.decode("#4BFFCA"), Color.decode("#5883CD"), Color.decode("#9E6AE1")
//                , Color.decode("#CD54F9"), Color.decode("#FC66FC"), Color.decode("#FC2968"), Color.decode("#FA2C2C")};
//        for (int i = 25, j = 1; i < this.frameWidth - 50; i += blockWidth, j++) {
//            block = new Block(new Rectangle(new Point(i, 250), blockWidth, 30), 1);
//            block.getCollisionRectangle().setColor(blocksColors[indexColor]);
//            blocks.add(block);
//            if (j < 8) {
//                if (j % 2 == 0) {
//                    indexColor++;
//                }
//            } else {
//                if (j % 2 == 1) {
//                    indexColor++;
//                }
//            }
//
//        }
//        return blocks;
//    }
//
//    /**
//     * @return the number of levels that should be removed before the level is considered to be "cleared".
//     */
//    public int getNumberOfBlocksToRemove() {
//        return 15;
//    }
//}
