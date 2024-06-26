package hexlet.code.Games;

import hexlet.code.Engine;
import hexlet.code.NumberGenerator;
import hexlet.code.Question;


public class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final int MAX = 100;

    private static char getOperator() {
        int operatorIndex = (int) (Math.random() * 3);
        return OPERATORS[operatorIndex];
    }
    private static int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException(
                    "Invalid operator: " + operator
            );
        };
    }
    private static Question generateQuestion() throws IllegalArgumentException {
        int num1 = NumberGenerator.generateNumber(MAX);
        int num2 = NumberGenerator.generateNumber(MAX);
        char operator = getOperator();
        int answer = calculate(num1, num2, operator);
        return new Question(String.format("%d %c %d", num1, operator, num2), Integer.toString(answer));
    }

    public static void launch(String userName) {
        Question[] questions = new Question[Engine.ROUNDS];
        try {
            for (int i = 0; i < Engine.ROUNDS; i++) {
                questions[i] = generateQuestion();
            }
            Engine.flow(DESCRIPTION, userName, questions);
        } catch (IllegalArgumentException e) {
            System.out.println("Error by generating questions in calculator");
        }
    }
}
