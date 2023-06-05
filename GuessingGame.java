import java.util.Random;
import java.util.Scanner;

public class Guess {
   public static final int MAX_NUMBER = 100;  // I GOT THIS FROM INTERNET RESEARCH FOR EXTRA CREDIT! - change this to change the maximum number
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int totalGames = 0;
      int totalGuesses = 0;
      int bestGame = MAX_NUMBER;
      boolean playAgain = true;
      introduction(); // introduce the game to the user
      
      while (playAgain) {
         int answer = pickNumber(); // pick a new number for each game
         int guesses = playGame(answer, in); // play one game and return the number of guesses
         totalGames++; //total games added everytime it runs
         totalGuesses += guesses; //total guesses added everytime it runs
         if (guesses < bestGame) { //code for the best game equation
            bestGame = guesses; // shows best game
         }
         System.out.print("Do you want to play again? (y/n) ");
         playAgain = in.next().toLowerCase().startsWith("y"); //makes it so you can put Yes, or anything starting with a Y or y
      }
      
      reportResults(totalGames, totalGuesses, bestGame); // Value of the results
   }
   
   /**
    * Introduce the game to the user.
    */
   public static void introduction() {
      System.out.println("Welcome to the Guessing Game!");
      System.out.println("I will think of a number between 1 and " + MAX_NUMBER
             + " and will allow you to guess until you get it.");
      System.out.println("For each guess, I will tell you whether the right answer is higher or lower.");
      System.out.println();
   }
   
   /**
    * Pick a random number between 1 and MAX_NUMBER.
    */
   public static int pickNumber() {
      Random rand = new Random();
      return rand.nextInt(MAX_NUMBER) + 1;
   }
   
   /**
    * Play one game with the user.
    * Return the number of guesses.
    */
   public static int playGame(int answer, Scanner in) {
      int guess;
      int numGuesses = 0;
      do {
         System.out.print("Your guess? ");         
         numGuesses++;
         if (guess < answer) {
            System.out.println("It's higher.");
         } else if (guess > answer) {
            System.out.println("It's lower.");
         } 
      } while (guess != answer);
      if (numGuesses == 1) {
         System.out.println("You got it right in 1 guess");
      } else {
         System.out.println("You got it right in " + numGuesses + " guesses");
      }
      System.out.println();
      return numGuesses;
   }
   
   /**
    * Report overall results to the user.
    */
   public static void reportResults(int totalGames, int totalGuesses, int bestGame) {
      double avgGuesses = (double) totalGuesses / totalGames;
      System.out.println("Overall results:");
      System.out.println("Total games = " + totalGames);
      System.out.println("Total guesses = " + totalGuesses);
      System.out.printf("Guesses/game = %.1f%n", avgGuesses);
      System.out.println("Best game = " + bestGame);
   }
}
