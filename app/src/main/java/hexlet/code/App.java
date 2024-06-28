package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
    }
    public static void main(String[] args) {
        printMenu();
        String selectedGame = SCANNER.next();
        System.out.println("Your choice: " + selectedGame);
        switch (selectedGame) {
            case "0":
                return;
            case "1":
                Cli.greet();
                break;
            case "2":
                Even.launch();
                break;
            case "3":
                Calculator.launch();
                break;
            case "4":
                Gcd.launch();
                break;
            case "5":
                Progression.launch();
                break;
            case "6":
                Prime.launch();
                break;
            default:
                System.out.println("There is no such game!");
                break;
        }
        SCANNER.close();
    }
}
