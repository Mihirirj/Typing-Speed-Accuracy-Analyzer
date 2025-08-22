
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Leaderboard leaderboard = new Leaderboard();

        System.out.println("⌨️⚡ Welcome to the Typing Speed & Accuracy Analyzer! ⌨️⚡");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Start Typing Test");
            System.out.println("2. Show Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startTest(scanner, leaderboard);
                    break;
                case "2":
                    leaderboard.display();
                    break;
                case "3":
                    System.out.println("Thanks for playing! Goodbye.");
                    scanner.close();
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    private static void startTest(Scanner scanner, Leaderboard leaderboard) {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        TypingTest test = new TypingTest();
        TestResult result = test.runTest(userName, scanner);

        // Display the results immediately after the test
        System.out.println("\n--- Your Test Results ---");
        System.out.printf("Words Per Minute (WPM): %.2f%n", result.getWpm());
        System.out.printf("Accuracy: %.2f%%%n", result.getAccuracy());

        // Display the mistyped words list
        if (!result.getMistypedWords().isEmpty()) {
            System.out.println("\nMistyped words (for practice):");
            for (String word : result.getMistypedWords()) {
                System.out.println("- " + word);
            }
        } else {
            System.out.println("\nPerfect typing! No mistyped words.");
        }

        // Add result to the leaderboard
        leaderboard.addResult(result);
    }
}