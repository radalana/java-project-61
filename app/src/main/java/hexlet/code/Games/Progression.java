package hexlet.code.Games;
import hexlet.code.Engine;
import hexlet.code.NumberGenerator;
import hexlet.code.Question;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 10;
    private static final int MAX_START_NUMBER = 100;

    private static String formatProgression(String[] progression, int hiddenIndex) {
        progression[hiddenIndex] = "..";
        return StringUtils.join(progression, ' ');
    }
    private static Question generateProgression() {
        int sizeOfProgression = NumberGenerator.generateNumber(MIN_SIZE, MAX_SIZE);
        int hiddenIndex = NumberGenerator.generateNumber(sizeOfProgression);
        int minDiff = 1;
        int maxDiff = 11;
        int difference = NumberGenerator.generateNumber(minDiff, maxDiff);
        int firstNumber = NumberGenerator.generateNumber(MAX_START_NUMBER);
        String[] progression = new String[sizeOfProgression];
        for (int i = 0; i < sizeOfProgression; i++) {
            progression[i] =  Integer.toString(firstNumber + difference * i);
        }
        String answer = progression[hiddenIndex];
        return new Question(formatProgression(progression, hiddenIndex), answer);
    }

    public static void launch(String userName) {
        Question[] questions = new Question[Engine.ROUNDS];
        for(int i = 0; i < Engine.ROUNDS; i++) {
            questions[i] = generateProgression();
        }
        Engine.flow(DESCRIPTION, userName, questions);
    }
}
