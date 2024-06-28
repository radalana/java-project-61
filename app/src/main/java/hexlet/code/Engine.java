package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final Scanner SCANNER = new Scanner(System.in);
    public static String getUserName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?");
        String userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void flow(String description, Question[] questions) {
        String userName = getUserName();
        System.out.println(description);
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Question: " + questions[i].getQuestion());

            String userAnswer = SCANNER.next();
            String correctAnswer = questions[i].getAnswer();
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
