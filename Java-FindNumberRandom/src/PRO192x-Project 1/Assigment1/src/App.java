import java.lang.Math;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int Total_games = 0;
        int Best_game = 0;
        int Guess_time;
        int Total_guess = 0;
        String Continue_game = "y";
        Scanner sc = new Scanner(System.in);
        while (Continue_game.equals("y") || Continue_game.equals("yes")) {
            // Play(sc);
            Guess_time = Play(sc);
            System.out.print("Do you want to play again? ");
            Continue_game = sc.next().toLowerCase();
            System.out.println();
            Total_games += 1;
            if (Total_games == 1) {
                Best_game = Guess_time;
            } else if (Guess_time < Best_game) {
                Best_game = Guess_time;
            }
            Total_guess += Guess_time;

        }
        Report(Total_games, Total_guess, Best_game);
    }

    public static int Play(Scanner sc) {
        int Lucky_number = (int) (Math.random() * 101);
        System.out.println("I'm thinking of a number between 0 and 100");
        System.out.print("Your guess? ");
        int x = sc.nextInt();
        int Guess = 1;
        while (x != Lucky_number) {
            if (x > Lucky_number) {
                System.out.println("It's lower");
            } else {
                System.out.println("It's higher");
            }
            System.out.print("Your guess? ");
            x = sc.nextInt();
            Guess += 1;
        }
        System.out.println("You got it right in " + Guess + " guesses!");
        return Guess;
    }

    public static void Report(int Total_games, int Total_guess, int Best_game) {
        double Avg_guess = (double) (Total_guess) / (double) (Total_games);
        System.out.println("Over results:");
        System.out.println("Total game = " + Total_games);
        System.out.println("Total guesses = " + Total_guess);
        System.out.println("Guesses/game = " + Avg_guess);
        System.out.println("Best game = " + Best_game);
    }

}
