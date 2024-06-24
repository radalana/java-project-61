package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I ask your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        scanner.close();
    }

    public  static void launch() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);
        if (userChoice.equals("1")) {
            greetUser();
        }
    }
}
