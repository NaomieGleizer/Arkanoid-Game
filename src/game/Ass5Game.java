//package game;
//
//import animations.AnimationRunner;
//import levels.*;
//import biuoop.KeyboardSensor;
//import biuoop.GUI;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * this class contains the main that runs the program.
// */
//public class Ass5Game {
//
//    public static final int FRAME_WIDTH = 800;
//    public static final int FRAME_HEIGHT = 600;
//
//    /**
//     * main- run the game.
//     *
//     * @param args arguments- empty
//     */
//    public static void main(String[] args) {
//
//        List<LevelInformation> levels = new ArrayList<>();
//        // build four level
//        LevelInformation level1 = new DirectHitLevel1(FRAME_WIDTH, FRAME_HEIGHT);
//        LevelInformation level2 = new WideEasyLevel2(FRAME_WIDTH, FRAME_HEIGHT);
//        LevelInformation level3 = new Green3Level3(FRAME_WIDTH, FRAME_HEIGHT);
//        LevelInformation level4 = new FinalFourLevel4(FRAME_WIDTH, FRAME_HEIGHT);
//        int numLevel;
//        // go over all the arguments
//        for (int i = 0; i < args.length; i++) {
//            try {
//                numLevel = Integer.parseInt(args[i]);
//            } catch (Exception e) {
//                continue;
//            }
//            switch (numLevel) {
//                case 1:
//                    levels.add(level1);
//                    break;
//                case 2:
//                    levels.add(level2);
//                    break;
//                case 3:
//                    levels.add(level3);
//                    break;
//                case 4:
//                    levels.add(level4);
//                    break;
//                default: // if the argument is not a number between 1-4
//                    break;
//            }
//        }
//        // if non of the arguments is a level number, finish the program.
//        if (args.length != 0 && levels.isEmpty()) {
//            System.out.println("Non of your input arguments is a number of a level (1-4).");
//            return;
//        }
//
//        // when run without arguments, start a game with four levels that run one after the other
//        if (args.length == 0) {
//            levels.add(level1);
//            levels.add(level2);
//            levels.add(level3);
//            levels.add(level4);
//        }
//
//        // run the game
//        GUI gui = new GUI("Arkanoid", FRAME_WIDTH, FRAME_HEIGHT);
//        AnimationRunner animationRunner = new AnimationRunner(gui);
//        KeyboardSensor keyboard = animationRunner.getGui().getKeyboardSensor();
//        GameFlow game = new GameFlow(animationRunner, keyboard, FRAME_WIDTH, FRAME_HEIGHT);
//        game.runLevels(levels);
//    }
//}