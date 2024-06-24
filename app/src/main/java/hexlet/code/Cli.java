package hexlet.code;
import hexlet.code.Games.Even;
import hexlet.code.Games.Calculator;

import java.util.Scanner;

public class Cli {
    public static Scanner scanner = new Scanner(System.in);
    public static String getUserName() {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I ask your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        return userName;
    }

    public  static void launch() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");

        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);
        if (!userChoice.equals("0")) {
            String userName = getUserName();
            if (userChoice.equals("2")) {
                Even.launchEven(userName);
            }
            if (userChoice.equals("3")) {
                Calculator.launchCalc(userName);
            }
        }
        scanner.close();
    }
}
