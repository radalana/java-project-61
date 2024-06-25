package hexlet.code.Games;
import hexlet.code.Question;
import hexlet.code.Engine;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    public static int findGcd(int num1, int num2) {
        while(num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 = num1 % num2;
            }else {
                num2 = num2 % num1;
            }
        }
        return Math.max(num1, num2);
    }
    public static Question generateQuestion() {
        int num1 = Even.getRandomNumber();
        int num2 = Even.getRandomNumber();
        int answer = findGcd(num1, num2);
        String question = String.format("%d %d", num1, num2);
        return new Question(question, Integer.toString(answer));
    }
    public static void launch(String userName) {
        Question[] questions = new Question[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questions[i] = generateQuestion();
        }
        Engine.flow(DESCRIPTION, userName, questions);
    }
}
