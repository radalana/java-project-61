package hexlet.code;
import java.util.Scanner;

public class Even {
    public static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int SUP = 100;
    public static final int ROUNDS = 3;

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

    public static void launchEven(String userName) {
        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = getRandomNumber();
            String correctAnswer = getCorrectAnswer(randomNumber);

            System.out.println(TASK);
            System.out.println("Question: " + randomNumber);

            String userAnswer = Cli.scanner.next();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct");
            } else {
                String errorMessage = String.format(
                        "'%s' is wrong answer ;(. Correct answer was '%s'.\n" + "Let's try again, %s!",
                        userAnswer, correctAnswer, userName);
                System.out.println(errorMessage);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
