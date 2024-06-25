package hexlet.code.Games;
import hexlet.code.Engine;
import hexlet.code.Question;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_SIZE = 5;
    private static final int RANGE_SIZE = 5;

    private static String formatProgression(String[] progression, int hiddenIndex) {
        progression[hiddenIndex] = "..";
        return StringUtils.join(progression, ' ');
    }
    private static Question generateProgression() {
        int sizeOfProgression = MIN_SIZE + (int) (Math.random() * (RANGE_SIZE + 1));
        int hiddenIndex = (int) (Math.random() * sizeOfProgression);
        int minDiff = 1;
        int maxDiff = 11;
        int difference = minDiff + (int) (Math.random() * maxDiff);
        int firstNumber = Even.getRandomNumber();
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
