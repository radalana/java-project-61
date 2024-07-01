package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Question;
import hexlet.code.Utils;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int SUP = 100;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static Question generateQuestion() {
        int number = Utils.generateNumber(SUP);
        String answer = isEven(number) ? "yes" : "no";
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
