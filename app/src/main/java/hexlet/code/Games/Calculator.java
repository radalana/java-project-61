package hexlet.code.Games;

import hexlet.code.Engine;
import hexlet.code.Question;


public class Calculator {
    public static final String DESCRIPTION = "What is the result of the expression?";
    public static final char[] OPERATORS = {'+', '-', '*'};

    public static char getOperator() {
        int operatorIndex =(int) (Math.random() * 3);
        return OPERATORS[operatorIndex];
    }
    public static int calculate(int num1, int num2, char operator) {
        switch(operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return  num1 * num2;
            default: throw new IllegalArgumentException(
                    "Invalid operator: " + operator
            );
        }
    }
    public static Question generateQuestion() throws IllegalArgumentException{
        int num1 = Even.getRandomNumber();
        int num2 = Even.getRandomNumber();
        char operator = getOperator();
        int answer = calculate(num1, num2, operator);
        return new Question(String.format("%d %c %d", num1, operator, num2), Integer.toString(answer));
    }

    public static void launchCalc(String userName) {
        Question[] questions = new Question[Engine.ROUNDS];
        try{
            for (int i = 0; i < Engine.ROUNDS; i++) {
                questions[i] = generateQuestion();
            }
            Engine.flow(DESCRIPTION, userName, questions);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error by generating questions in calcalator");
        }
    }
}
