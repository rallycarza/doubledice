import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Die firstDice = new Die();
    Die secondDice = new Die();
    double bet = -1;           // Amount user will bet
    double pot = 100.00;  // Current amount availble to bet
    int winCount = 0;     // Rounds won
    int loseCount = 0;    // Rounds lost


    do {
      // Begin turn by printing total available to bet
      System.out.print("You have $");
      System.out.printf("%.2f", pot);
      System.out.println();
      
      
      System.out.println("How much would you like to bet (Enter 0 to quit)?");
      try { // Make sure user does not enter a string
        bet = scnr.nextFloat(); // Float comparison
      } catch(InputMismatchException e) {
        System.out.println("Please enter a dollar amount.");
        System.out.println();
        scnr.next(); // Prevent error from posting
        continue;    // Prevent program from breaking
      }
      // Check conditions of bet
      // Bet cannot be less than money available
      if (bet > pot) {
        System.out.println("You can't bet more than you have!");
        System.out.print("Try a bet less than or equal to $");
        System.out.printf("%.2f", pot);
        System.out.println();
        continue;
      }
      // Bet cannot be a negative value
      else if (bet < 0) {
        System.out.println("You can't bet a negative dollar amount!");
        System.out.print("Try a bet between $0.01 and ");
        System.out.printf("%.2f", pot);
        System.out.println();
        continue;
      }
      // If input is valid, roll dice
      else {
          firstDice.roll();
          secondDice.roll();
          System.out.println("You rolled a " + firstDice.toString() + " and a " + secondDice.toString());
        // Win condition
        if (firstDice.equals(secondDice)) {
          System.out.print("You win $");
          System.out.printf("%.2f", bet);
          System.out.println();
          System.out.println();
          pot = pot + bet;
          winCount++;
        }
        // Lose condition
        else {
          System.out.print("You lose $");
          System.out.printf("%.2f", bet);
          System.out.println();
          System.out.println();
          pot = pot - bet;
          loseCount++;
        }
      }

      
      // End-game conditions
      if (pot == 0) {
        System.out.println("You are out of money!");
        System.out.println("Better luck next time");
        break;
      }
      else if (bet == 0 && winCount == 0 && loseCount == 0) {
        System.out.println("You didn't win or lose any rounds.");
        System.out.println("Thanks for playing!");
        break;
      }
      else if (bet == 0 && winCount > loseCount) {
        System.out.println("You won " + winCount + " times!");
        System.out.println("See you around, winner!");
        break;
      }
      else if (bet == 0 && winCount < loseCount) {
        System.out.println("You lost " + loseCount + " times.");
        System.out.println("Better luck next time.");
        break;
      }
      else if (bet == 0 && winCount == loseCount) {
        System.out.println("It's a tie!");
        System.out.println("You won " + winCount + " times, and lost " + loseCount + " times!");
        break;
      }
    } while (pot != 0); // Loop until player is out of money
    

  }
}