import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

// Word guessing game
public class WordGame implements Game {
    private final Scanner scanner;  // Scanner object for reading user input

    // Constructor that takes a scanner as input
    public WordGame(Scanner scanner) {
        this.scanner = scanner;
    }

    // Word guesser starts 
    @Override
    public void start() {
        // List of words to guess
        String[] wordList = {"doggy", "guitar", "hangman", "program", "computer", "games", "table"};
        
        // Picks a random word
        Random rand = new Random();
        String wordToGuess = wordList[rand.nextInt(wordList.length)];

        // Create an array to hold the word starting with underscores
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        // Track the number of attempts left
        int attemptsLeft = 6;
        
        // Set to track guessed letters
        Set<Character> guessedLetters = new HashSet<>();

        // Game loop
        while (attemptsLeft > 0 && new String(guessedWord).contains("_")) {
            System.out.println("Word: " + String.valueOf(guessedWord));  // Display the current guessed word
            System.out.println("Attempts left: " + attemptsLeft);  // Display remaining attempts

            System.out.print("Guess a letter: ");
            String input = scanner.next().toLowerCase();  // Read the user's guess

            // Checks if guess was one letter
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single valid letter.");
                continue;  // Skip the rest of the loop and ask again
            }

            char guess = input.charAt(0);  // Takes character from guess

            // Check if the letter was already guessed
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;  // Skip the round
            }

            guessedLetters.add(guess);  // Add the guess to the set of guessed letters

            boolean correctGuess = false;

            // Loop through the word and reveal letters
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;  // Update the word
                    correctGuess = true;  // Marks the guess true
                }
            }

            // If the guess was wrong takes away trys
            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong!");
            }
        }

        // After the loop ends display
        System.out.println("\n====================");

        // Check if the word was guessed right
        if (new String(guessedWord).equals(wordToGuess)) {
            System.out.println("Congrats! You guessed the word: " + wordToGuess);
        } else {
            // No more guesses
            System.out.println("You lost. The word was: " + wordToGuess);
        }
    }
}
