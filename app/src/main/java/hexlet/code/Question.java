package hexlet.code;

/**
 * This class represents a question with an answer.
 * It can be extended to add more functionalities.
 */
public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns the question.
     *
     * @return the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Returns the answer to the question.
     *
     * @return The answer as a string.
     */
    public String getAnswer() {
        return this.answer;
    }
}
