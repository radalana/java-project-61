package hexlet.code;

public class NumberGenerator {
    public static int generateNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
    public static int generateNumber(int max) {
       return  generateNumber(0, max);
    }
}
