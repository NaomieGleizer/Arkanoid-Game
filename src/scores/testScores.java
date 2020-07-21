package scores;

public class testScores {
    public static void main(String[] args) {

        HighScoresTable highScoresTable = new HighScoresTable(4);
        ScoreInfo score1 = new ScoreInfo("Naomie", 550);
        ScoreInfo score2 = new ScoreInfo("aaa", 100);
        ScoreInfo score3 = new ScoreInfo("vvv", 550);
        ScoreInfo score4 = new ScoreInfo("ppp", 200);

        highScoresTable.add(score1);
        highScoresTable.add(score2);
        highScoresTable.add(score3);
        highScoresTable.add(score4);

        int i = 1;
        for (ScoreInfo scoreInfo : highScoresTable.getHighScores()) {
            System.out.println("Number " + i + ": Name: " + scoreInfo.getName() + " Score: " + scoreInfo.getScore());
            i++;
        }
        System.out.println();
        ScoreInfo score5 = new ScoreInfo("ddd", 600);
        highScoresTable.add(score5);

        for (ScoreInfo scoreInfo : highScoresTable.getHighScores()) {
            System.out.println("Number " + i + ": Name: " + scoreInfo.getName() + " Score: " + scoreInfo.getScore());
            i++;
        }
        System.out.println();
        ScoreInfo score6 = new ScoreInfo("xxx", 700);
        highScoresTable.add(score6);

        for (ScoreInfo scoreInfo : highScoresTable.getHighScores()) {
            System.out.println("Number " + i + ": Name: " + scoreInfo.getName() + " Score: " + scoreInfo.getScore());
            i++;
        }

    }
}
