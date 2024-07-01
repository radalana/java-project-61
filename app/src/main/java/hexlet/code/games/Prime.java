package hexlet.code.games;
import hexlet.code.Question;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MAX_PRIME = 3571;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int FIRST_ODD_PRIME = 3;

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = FIRST_ODD_PRIME; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Question generateQuestion() {
        int number = Utils.generateNumber(MAX_PRIME);
        String answer = isPrime(number) ? "yes" : "no";
        return new Question(Integer.toString(number), answer);
    }
    public static void launch() {
        Question[] questions = new Question[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questions[i] = generateQuestion();
        }
        Engine.flow(DESCRIPTION, questions);
    }

}
