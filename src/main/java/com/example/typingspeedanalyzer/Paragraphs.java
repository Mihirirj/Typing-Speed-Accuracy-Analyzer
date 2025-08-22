

import java.util.Random;

public class Paragraphs {


    private static final String[] PARAGRAPHS = {
            "The quick brown fox jumps over the lazy dog. This sentence contains all the letters of the alphabet. It is a classic pangram used for testing typing skills.",
            "Technology has revolutionized the way we live and work. From smartphones to artificial intelligence, these advancements continue to shape our daily lives in profound ways.",
            "The sun dipped below the horizon, painting the sky in shades of orange and pink. A gentle breeze rustled the leaves of the trees, creating a peaceful evening ambiance.",
            "Reading is a fundamental skill that opens up a world of knowledge and imagination. A good book can transport you to different times and places without ever leaving your chair.",
            "To be successful in any field, one must possess a combination of hard work, dedication, and a willingness to learn from failures. Persistence is the key to overcoming challenges."
    };

    private static final Random random = new Random();


    public static String getRandomParagraph() {
        return PARAGRAPHS[random.nextInt(PARAGRAPHS.length)];
    }
}