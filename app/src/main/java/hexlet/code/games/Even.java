package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Question;
import hexlet.code.NumberGenerator;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int SUP = 100;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String getCorrectAnswer(int number) {
        if (isEven(number)) {
            return "yes";
        }
        return ("no");
    }
    private static Question generateQuestion() {
        int number = NumberGenerator.generateNumber(SUP);
        String answer = getCorrectAnswer(number);
        return new Question(Integer.toString(number), answer);
    }

    public static void launch() {
        Question[] questions = {generateQuestion(), generateQuestion(), generateQuestion()};
        Engine.flow(DESCRIPTION, questions);
    }
}
