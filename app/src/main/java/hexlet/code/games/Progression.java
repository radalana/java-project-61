package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;
import hexlet.code.Question;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 10;
    private static final int MAX_START_NUMBER = 100;
    private static final int MIN_DIFF = 1;
    private static final int MAX_DIFF = 10;

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + step * i);
        }
        return progression;
    }
    private static Question generateProgression() {
        int sizeOfProgression = Utils.generateNumber(MIN_SIZE, MAX_SIZE);
        int hiddenIndex = Utils.generateNumber((sizeOfProgression - 1));
        int difference = Utils.generateNumber(MIN_DIFF, MAX_DIFF);
        int firstNumber = Utils.generateNumber(MAX_START_NUMBER);
        String[] progression = makeProgression(firstNumber, difference, sizeOfProgression);
        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        String question = String.join(" ", progression);
        return new Question(question, answer);
    }

    public static void launch() {
        Question[] questions = new Question[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questions[i] = generateProgression();
        }
        Engine.flow(DESCRIPTION, questions);
    }
}
