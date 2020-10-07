import java.util.Scanner;


class Yatzi {
    private static Die[] dices = new Die[5];

    private static void createFiveDices() {
        for(int i=0;i<5;i++) {
            dices[i] = new Die();
        }
    }

    private static void RollAllDices() {
        for (int i = 0; i < 5; i++) {
            dices[i].rollDie();
        }
    }

    private static void printAllDices() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Dice " + i +": " + dices[i].getDieValue());
        }
    }

    private static boolean checkIfYatzi() {
        boolean isYatzi = true;
        for (int i=1; i<5; i++) {
            if (dices[i].getDieValue() != dices[i - 1].getDieValue()) {
                isYatzi = false;
                break;
            }
        }
        return isYatzi;
    }

    private static void cheatAllDices() {
        for (int i = 0; i < 5; i++) {
            dices[i].setDieValue(6);
        }
    }

    public static void main(String[] args) {
        boolean gameIsStillRunning = true;
        int gameTurn = 1;
        System.out.println("Welcome to Yatzi!");
        createFiveDices();
        Scanner sc = new Scanner(System.in);
        while (gameIsStillRunning && gameTurn <= 3) {
            System.out.println("Starting turn " + gameTurn + " of 3, rolling dices");
            RollAllDices();
            printAllDices();
            if(checkIfYatzi()) {
                System.out.println("You got YATZI! in " + dices[0].getDieValue() + "'s");
                break;
            } else {
                if(gameTurn != 3) {
                    System.out.println("Want to throw again? (y for yes, anything else for no)");
                    if (sc.next().equals("y")) {
                        ++gameTurn;
                    } else {
                        gameIsStillRunning = false;
                        break;
                    }
                } else {
                    System.out.println("Game over! Want to play again?");
                    if(sc.next().equals("y")) {
                        gameTurn=1;
                    } else {
                        gameIsStillRunning = false;
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}

