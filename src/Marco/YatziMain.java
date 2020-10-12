package Marco;

import java.util.Scanner;

public class YatziMain {
    static Dices[] ds = new Dices[5];
    private static int gameTurns = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello! Do you want to play a game of Yatzi? (type y for start, rules to read the rules, hacks to test to auto generate Yatzi and anything else for no)");
        switch (sc.next()) {
            case "y" -> gameIsOn();
            case "hacks" -> gameIsOnHax();
        }
    }

    static void createDices() {
        for (int d = 0; d < 5; d++) {
            ds[d] = new Dices();
        }
    }

    static void rollDices() {
        for (Dices die: ds) {
            die.diceRoll();
        }
    }

    static void rollDicesAlwaysYatzi() {
        for(Dices die: ds) {
            die.value = 6;
        }
    }

    static void printDices() {
        for (Dices die: ds) {
            System.out.println(die.getString());
        }
    }

    static boolean isItYatzi(Dices[] dices) {
        for (int i = 1; i < dices.length; i++) {
            if (dices[i].value != dices[i - 1].value) {
                return false;
            }
        }
        return true;
    }

    public static void nextRound() {
        if (!isItYatzi(ds)) {
            if (gameTurns != 3) {
                System.out.println("Want to throw again?");
                if (sc.next().equals("y")) {
                    gameTurns++;
                    gameIsOn();
                } else {
                    System.out.println("See you another time!");
                    System.exit(0);
                }
            } else {
                gameOver();
            }
        } else {
            System.out.println("Wowowowow, you got yatzi in " + ds[0].value + "'s!!!!!");
            System.exit(0);
        }
    }

    static void gameIsOnHax() {
        while (gameTurns <= 3) {
            if (gameTurns == 1) {
                createDices();
                System.out.println("Welcome to Yatzi with hacks!");
            }
            rollDicesAlwaysYatzi();
            printDices();
            nextRound();
        }
    }

    static void gameIsOn() {
        while (gameTurns <= 3) {
            if (gameTurns == 1) {
                createDices();
                System.out.println("Welcome to Yatzi!");
            }
            rollDices();
            printDices();
            nextRound();
        }
    }

    public static void gameOver(){
        System.out.println("Game over! Want to play again? ('y' for new game, 'hacks' for cheat)");
        if (sc.next().equals("y")) {
            gameTurns = 1;
            gameIsOn();
        } else if (sc.next().equals("hacks")) {
            gameTurns = 1;
            gameIsOnHax();
        } else {
            System.out.println("See you another time!");
            System.exit(0);
        }
    }
}