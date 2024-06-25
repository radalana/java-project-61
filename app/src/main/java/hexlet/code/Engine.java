package hexlet.code;

public class Engine {
    public static final int ROUNDS = 3;

    public static void flow(String description, String userName, Question[] questions) {
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println(description);
            System.out.println("Question: " + questions[i].getQuestion());

            String userAnswer = Cli.scanner.next();
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
