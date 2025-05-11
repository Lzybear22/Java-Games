import java.util.Scanner;
import java.util.Random;

// Number guessing game
public class NumberGuessGame implements Game {
    private final Scanner scanner;  // Scanner object for reading user input

    // Reads scanner as a input
    public NumberGuessGame(Scanner scanner) {
        this.scanner = scanner;
    }

    // The number game starts
    @Override
    public void start() {
        Random rand = new Random();
        int secretNumber = rand.nextInt(100) + 1; // Secret number between 1 and 100
        int guess = -1;
        int attempts = 0;
        Integer previousGuess = null;

        System.out.println("\nI'm thinking of a number between 1 and 100. Start guessing!");

        // Loops until the player guesses the correct number
        while (guess != secretNumber) {
            System.out.print("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Takes invalid input
                continue;
            }

            guess = scanner.nextInt();  // Read the player's guess
            attempts++;

            // Checks if the guess is right
            if (guess == secretNumber) {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
            } else {
                // Warmer/Colder
                if (previousGuess != null) {
                    int prevDiff = Math.abs(secretNumber - previousGuess); // Difference from previous guess
                    int currentDiff = Math.abs(secretNumber - guess);  // Difference from current guess
                    if (currentDiff < prevDiff) {
                        System.out.print("Getting warmer! ");
                    } else if (currentDiff > prevDiff) {
                        System.out.print("Getting colder. ");
                    } else {
                        System.out.print("Same distance. ");
                    }
                }

                // Gives user feedback on whether the guess is too high or low
                if (guess < secretNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            previousGuess = guess;  // Stores the guess
        }
    }
}
