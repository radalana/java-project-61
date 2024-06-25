package hexlet.code.Games;
import hexlet.code.Engine;
import hexlet.code.Question;

public class Even {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int SUP = 100;

    public static int getRandomNumber() {
        return (int) (Math.random() * SUP);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String getCorrectAnswer(int number) {
        if (isEven(number)) {
            return "yes";
        }
        return ("no");
    }
    public static Question generateQuestion() {
        int number = getRandomNumber();
        String answer = getCorrectAnswer(number);
        return new Question(Integer.toString(number), answer);
    }

    public static void launchEven(String userName) {
        Question[] questions = {generateQuestion(), generateQuestion(), generateQuestion()};
        Engine.flow(DESCRIPTION, userName, questions);
    }
}
