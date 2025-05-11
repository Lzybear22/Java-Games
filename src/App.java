import java.util.Scanner;

// Main entry point for program
public class App {
    public static void main(String[] args) {
        // Create a shared scanner
        Scanner scanner = new Scanner(System.in);

        // Run the program in a loop
        while (true) {
            // Display a welcome message and ask user for what game
            System.out.println("Welcome to the Game!");
            System.out.println("Choose a game to play:");
            System.out.println("1. Word Guessing Game");
            System.out.println("2. Number Guessing Game");
            System.out.println("3. Quit");

            // Read user's choice
            int choice = scanner.nextInt();

            // Selects user's choice
            if (choice == 1) {
                // If the user chooses the word guessing game
                Game wordGame = new WordGame(scanner);  // Create a WordGame instance
                wordGame.start();  // Start the game
            } else if (choice == 2) {
                // If the user chooses the number guessing game
                Game numberGame = new NumberGuessGame(scanner);  // Create a NumberGuessGame instance
                numberGame.start();  // Start the game
            } else if (choice == 3) {
                // If the user chooses to quit, exit the program
                System.out.println("Thanks for playing! Goodbye!");
                break;
            } else {
                // If the user selects an invalid option
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
