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
            case "rules" -> Rules.printRules();
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

    public static void notYatzi() {
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
    }

    static void gameIsOnHax() {
        while (gameTurns <= 3) {
            if (gameTurns == 1) {
                createDices();
                System.out.println("Welcome to Yatzi with hacks!");
            }
            rollDicesAlwaysYatzi();
            printDices();
            checkIfYatzi();
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
            checkIfYatzi();
        }
    }

    public static void checkIfYatzi() {
        boolean isItAYatzi = true;
        for (int i = 1; i < ds.length; i++) {
            if (ds[i].value != ds[i - 1].value) {
                isItAYatzi = false;
                break;
            }
        }

        if (isItAYatzi) {
            System.out.println("Wowowowow, you got yatzi in " + ds[0].value + "'s!!!!!");
            System.exit(0);
        } else {
            notYatzi();
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
