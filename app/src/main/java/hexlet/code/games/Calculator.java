package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import hexlet.code.Question;


public class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final int MAX = 100;

    private static char getOperator() {
        int operatorIndex = Utils.generateNumber(OPERATORS.length - 1);
        return OPERATORS[operatorIndex];
    }
    private static int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
    private static Question generateQuestion() throws IllegalArgumentException {
        int num1 = Utils.generateNumber(MAX);
        int num2 = Utils.generateNumber(MAX);
        char operator = getOperator();
        int answer = calculate(num1, num2, operator);
        return new Question(String.format("%d %c %d", num1, operator, num2), Integer.toString(answer));
    }

    public static void launch() {
        Question[] questions = new Question[Engine.ROUNDS];
            for (int i = 0; i < Engine.ROUNDS; i++) {
                questions[i] = generateQuestion();
                Engine.flow(DESCRIPTION, questions);
            }
    }
}
