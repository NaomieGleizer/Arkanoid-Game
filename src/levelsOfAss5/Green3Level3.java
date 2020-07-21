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
///**
// * Level 3.
// */
//public class Green3Level3 implements LevelInformation {
//
//    private int frameWidth;
//    private int frameHeight;
//
//    /**
//     * Constructor.
//     *
//     * @param width  width of frame
//     * @param height height of frame
//     */
//    public Green3Level3(int width, int height) {
//        this.frameWidth = width;
//        this.frameHeight = height;
//    }
//
//    /**
//     * @return the number of balls in the level
//     */
//    public int getNumberOfBalls() {
//        return 2;
//    }
//
//    /**
//     * @return the initial velocity of each ball
//     */
//    public List<Velocity> getBallVelocities() {
//        List<Velocity> ballsVelocity = new ArrayList<>();
//        Velocity v = Velocity.fromAngleAndSpeed(225, 8);
//        ballsVelocity.add(v);
//        v = Velocity.fromAngleAndSpeed(315, 8);
//        ballsVelocity.add(v);
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
//        return 130;
//    }
//
//    /**
//     * @return the level name will be displayed at the top of the screen.
//     */
//    public String getLevelName() {
//        return "Level 3: Green Level";
//    }
//
//    /**
//     * @return a sprite with the background of the level
//     */
//    public Sprite getBackground() {
//        return new Level3Sprite(this.frameWidth, this.frameHeight, this.getLevelName());
//    }
//
//    /**
//     * @return the Blocks that make up this level, each block contains its size, color and location.
//     */
//    public List<Block> getBlocks() {
//        List<Block> blocks = new ArrayList<>();
//        int numOfBlocksRows = 5;
//        int indexColor = 0;
//        Color[] blocksColors = {Color.decode("#366B2B"), Color.decode("#008000"), Color.decode("#2AD200")
//                , Color.decode("#47FF18"), Color.decode("#ADFF2F")};
//        // upper-left point of each block: (x,y)
//        for (int y = 150, i = 1; i <= numOfBlocksRows; y += 30, i++) {
//            for (int x = this.frameWidth - 85; x >= 250 + 60 * (i - 1); x -= 60) {
//                Block block = new Block(new Rectangle(new Point(x, y), 60, 30), 1);
//                block.getCollisionRectangle().setColor(blocksColors[indexColor]);
//                blocks.add(block);
//            }
//            indexColor++;
//        }
//        return blocks;
//    }
//
//    /**
//     * @return the number of levels that should be removed before the level is considered to be "cleared".
//     */
//    public int getNumberOfBlocksToRemove() {
//        return this.getBlocks().size();
//    }
//}
