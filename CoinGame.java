import java.util.ArrayList;

public class CoinGame
{
    private ArrayList<Integer> chances;
    private int pointsToWin;
    private double prizeMoney;
    private Outcome root;

    private class Outcome
    {
        private final int aScore;
        private final int bScore;
        private final int rootDistance;
        private Outcome left, right;

        /**
         * Constructor for objects of class MatchInstance
         */
        public Outcome(int aScore, int bScore, int rootDistance)
        {
            this.aScore = aScore;
            this.bScore = bScore;
            this.rootDistance = rootDistance;

            if (aScore == pointsToWin) {
                chances.add(rootDistance);
            }
            else {
                if (bScore < pointsToWin) {
                    left = new Outcome(aScore + 1, bScore, rootDistance + 1);
                    right = new Outcome(aScore, bScore + 1, rootDistance + 1);
                }
            }

        }
    }


    /**
     * Constructor for objects of class CoinGame
     */
    public CoinGame(int pointsToWin)
    {
        chances = new ArrayList<>();
        this.pointsToWin = pointsToWin;
        prizeMoney = 20;
    }

    public void start(int aScore, int bScore)
    {
        root = new Outcome(aScore, bScore, 0);
    }

    private double aProbability()
    {
        double aProbability =
                chances.stream()
                        .mapToDouble(s -> Math.pow(2, -s))
                        .sum();
        return aProbability;
    }

    public String whoGetsWhat()
    {
        double aProbability = aProbability();
        double bProbability = 1 - aProbability;
        double aShare = prizeMoney * aProbability;
        double bShare = prizeMoney * bProbability;
        return ("Person A gets $" + aShare + ". " +
                "Person B gets $" + bShare + ".");
    }
}
