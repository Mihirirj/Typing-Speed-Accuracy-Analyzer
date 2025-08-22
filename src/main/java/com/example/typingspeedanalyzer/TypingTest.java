

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingTest {

    private final String paragraph;

    public TypingTest() {
        this.paragraph = Paragraphs.getRandomParagraph();
    }

    public TestResult runTest(String userName, Scanner scanner) {
        System.out.println("--------------------------------------------------");
        System.out.println("Type the following paragraph:");
        System.out.println(paragraph);
        System.out.println("--------------------------------------------------");
        System.out.print("Press Enter when you are ready to start...");
        scanner.nextLine(); // Wait for user to press Enter

        System.out.println("Go!");
        long startTime = System.currentTimeMillis();

        String userInput = scanner.nextLine();

        long endTime = System.currentTimeMillis();

        return calculateResults(userName, userInput, startTime, endTime);
    }

    private TestResult calculateResults(String userName, String userInput, long startTime, long endTime) {
        long totalTimeMillis = endTime - startTime;
        double timeInMinutes = totalTimeMillis / 60000.0; // Convert milliseconds to minutes

        // WPM calculation based on the standard of 5 characters per word
        // (Gross WPM)
        double wpm = (userInput.length() / 5.0) / timeInMinutes;

        // Prevent division by zero if test is too fast
        if (timeInMinutes == 0) {
            wpm = 0;
        }

        String[] originalWords = paragraph.split("\\s+");
        String[] typedWords = userInput.split("\\s+");

        int correctWords = 0;
        List<String> mistypedWords = new ArrayList<>();

        // Compare word by word up to the length of the shorter array
        int limit = Math.min(originalWords.length, typedWords.length);
        for (int i = 0; i < limit; i++) {
            if (originalWords[i].equals(typedWords[i])) {
                correctWords++;
            } else {
                mistypedWords.add(originalWords[i]); // Add the word that *should* have been typed
            }
        }

        // Accuracy is the percentage of correctly typed words out of the original paragraph's words
        double accuracy = (originalWords.length > 0) ? ((double) correctWords / originalWords.length) * 100 : 0.0;

        return new TestResult(userName, wpm, accuracy, mistypedWords);
    }
}