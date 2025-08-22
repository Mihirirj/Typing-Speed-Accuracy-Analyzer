

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {
    private final List<TestResult> results;

    public Leaderboard() {
        this.results = new ArrayList<>();
    }

    public void addResult(TestResult result) {
        results.add(result);
    }

    public void display() {
        System.out.println("\n--- 🏆 LEADERBOARD 🏆 ---");
        if (results.isEmpty()) {
            System.out.println("The leaderboard is empty. Be the first to set a score!");
            return;
        }

        // Sort results by WPM in descending order
        results.sort(Comparator.comparingDouble(TestResult::getWpm).reversed());

        int rank = 1;
        System.out.printf("%-5s %-20s %-10s %-10s%n", "Rank", "User", "WPM", "Accuracy");
        System.out.println("-----------------------------------------------------");

        for (TestResult result : results) {
            System.out.printf("%-5d %-20s %-10.2f %-10.2f%%%n",
                    rank++,
                    result.getUserName(),
                    result.getWpm(),
                    result.getAccuracy());
        }
        System.out.println("-----------------------------------------------------");
    }
}