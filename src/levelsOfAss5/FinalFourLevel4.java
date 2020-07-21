//package levels;
//
//import geometry.Point;
//import geometry.Rectangle;
//import sprites.Block;
//import sprites.Sprite;
//import sprites.Velocity;
//
//import java.awt.Color;
//import java.util.List;
//import java.util.ArrayList;
//
//
///**
// * Level 4.
// */
//public class FinalFourLevel4 implements LevelInformation {
//    private int frameWidth;
//    private int frameHeight;
//
//    /**
//     * Constructor.
//     *
//     * @param width  width of frame
//     * @param height height of frame
//     */
//    public FinalFourLevel4(int width, int height) {
//        this.frameWidth = width;
//        this.frameHeight = height;
//    }
//
//    /**
//     * @return the number of balls in the level
//     */
//    public int getNumberOfBalls() {
//        return 3;
//    }
//
//    /**
//     * @return the initial velocity of each ball
//     */
//    public List<Velocity> getBallVelocities() {
//        List<Velocity> ballsVelocity = new ArrayList<>();
//        for (int i = 0, v = 225; i < this.getNumberOfBalls(); i++, v += 45) {
//            Velocity vel = Velocity.fromAngleAndSpeed(v, 7);
//            ballsVelocity.add(vel);
//        }
//        return ballsVelocity;
//    }
//
//    /**
//     * @return the speed of the paddle for the level
//     */
//    public int getPaddleSpeed() {
//        return 6;
//    }
//
//    /**
//     * @return the width of the paddle for the level
//     */
//    public int getPaddleWidth() {
//        return 120;
//    }
//
//    /**
//     * @return the level name will be displayed at the top of the screen.
//     */
//    public String getLevelName() {
//        return "Level 4: Final Four";
//    }
//
//    /**
//     * @return a sprite with the background of the level
//     */
//    public Sprite getBackground() {
//        return new Level4Sprite(this.frameWidth, this.frameHeight, this.getLevelName());
//    }
//
//    /**
//     * @return the Blocks that make up this level, each block contains its size, color and location.
//     */
//    public List<Block> getBlocks() {
//        List<Block> blocks = new ArrayList<>();
//        int numOfRowsBlocks = 7;
//        int blockWidth = (this.frameWidth - 50) / 15; // 15 getBlocks per row
//        Color[] blockColors = {Color.decode("#696969"), Color.decode("#FF69B4"), Color.decode("#F5F5DC")
//                , Color.decode("#5EFF36"), Color.decode("#FFFF00"), Color.decode("#8A2BE2"), Color.decode("#0000CD")};
//        for (int y = 110, i = 0; i < numOfRowsBlocks; y += 30, i++) {
//            for (int x = 25; x <= this.frameWidth - 25 - blockWidth; x += blockWidth) {
//                Block block = new Block(new Rectangle(new Point(x, y), blockWidth, 30), 1);
//                block.getCollisionRectangle().setColor(blockColors[i]);
//                blocks.add(block);
//            }
//        }
//        return blocks;
//    }
//
//    /**
//     * @return the number of levels that should be removed before the level is considered to be "cleared".
//     */
//    public int getNumberOfBlocksToRemove() {
//        return 105;
//    }
//}
