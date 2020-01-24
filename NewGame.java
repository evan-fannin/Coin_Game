import java.util.Scanner;

public class NewGame
{

    public static void main(String[] args) {
        new NewGame();
    }


    public NewGame()
    {
        System.out.println("Enter player A's score as an integer");
        int aScore = takeInput();

        System.out.println("Enter player B's score as an integer");
        int bScore = takeInput();

        System.out.println("Enter the number of points needed to win");
        int pointsToWin = takeInput();

        newGame(aScore, bScore, pointsToWin);
    }

    public void newGame(int aScore, int bScore, int pointsToWin)
    {
        CoinGame game = new CoinGame(pointsToWin);
        game.start(aScore, bScore);
        System.out.println(game.whoGetsWhat());
    }

    public int takeInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }
}
