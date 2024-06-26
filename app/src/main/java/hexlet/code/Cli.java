package hexlet.code;
import hexlet.code.Games.Calculator;
import hexlet.code.Games.Even;
import hexlet.code.Games.Gcd;
import hexlet.code.Games.Prime;
import hexlet.code.Games.Progression;

import java.util.Scanner;
//TODO: create Launcher Class
public class Cli {
    private static final Scanner scanner = new Scanner(System.in);
    public static Scanner getScanner() {
        return scanner;
    }
    public static String getUserName() {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    public  static void launch() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);
        if (!userChoice.equals("0")) {
            String userName = getUserName();
            if (userChoice.equals("2")) {
                Even.launch(userName);
            }
            if (userChoice.equals("3")) {
                Calculator.launch(userName);
            }
            if (userChoice.equals("4")) {
                Gcd.launch(userName);
            }
            if (userChoice.equals("5")) {
                Progression.launch(userName);
            }
            if (userChoice.equals("6")) {
                Prime.launch(userName);
            }
        }
        scanner.close();
    }
}
