

import java.util.List;

public class TestResult {
    private final String userName;
    private final double wpm;
    private final double accuracy;
    private final List<String> mistypedWords;

    public TestResult(String userName, double wpm, double accuracy, List<String> mistypedWords) {
        this.userName = userName;
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.mistypedWords = mistypedWords;
    }

    // Getters for all fields
    public String getUserName() {
        return userName;
    }

    public double getWpm() {
        return wpm;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public List<String> getMistypedWords() {
        return mistypedWords;
    }
}