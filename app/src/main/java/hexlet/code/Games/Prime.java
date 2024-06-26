package hexlet.code.Games;
import hexlet.code.Question;
import hexlet.code.Engine;
import hexlet.code.NumberGenerator;

public class Prime {
    private static final int MAX_PRIME = 3571;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number%2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static String getAnswer(int number) {
        if (isPrime(number)) {
            return "yes";
        }
        return "no";
    }
    private static Question generateQuestion() {
        int number = NumberGenerator.generateNumber(MAX_PRIME);
        String answer = getAnswer(number);
        return new Question(Integer.toString(number), answer);
    }
    public static void launch(String userName) {
        Question[] questions = new Question[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questions[i] = generateQuestion();
        }
        Engine.flow(DESCRIPTION, userName, questions);
    }

}