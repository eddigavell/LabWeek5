import java.util.Scanner;

class YatziMain {
    private int gameTurns;
    private Scanner sc = new Scanner(System.in);
    private Die[] ds = new Die[5];

    private YatziMain(int gameMode) {
        gameTurns=1;
        createDie();
        rollDie(gameMode);
        gameIsOn(gameMode);
    }

    private YatziMain () {
        System.out.println("Hello! Do you want to play a game of Yatzi? ('y' / 'hacks')");
        switch (sc.next()) {
            case "y" -> new YatziMain(1);
            case "hacks" -> new YatziMain(2);
            default -> System.exit(0);
        }
    }

    private void createDie(){
        for (int d = 0; d < 5; d++) {
            ds[d] = new Die();
        }
    }

    private void rollDie(int gameMode) {
        if (gameMode == 1) {
            for (Die die: ds) {
                die.dieRoll();
            }
        } else {
            int randomNumber = (int)(Math.random()*6+1);
            for (Die die: ds) {
                die.setDieValue(randomNumber);
            }
        }
    }

    private void rollDie() {
        rollDie(1);
    }

    private void printDie() {
        int dieNumber = 1;
        for (Die die: ds) {
            System.out.println("Die " + dieNumber + ": shows a " + die.getDieValue());
            dieNumber++;
        }
    }

    private void gameIsOn(int gameMode) {
        if (gameMode == 1 && gameTurns == 1) {
            System.out.println("Welcome to Yatzi!");
        } else {
            System.out.println("Welcome to Yatzi! Now with hacks 2.0!");
        }
        while (gameTurns <= 3) {
            System.out.println("Starting turn " + (gameTurns) + " of 3, rolling dice.");
            printDie();
            newRound();
        }
    }

    static boolean checkIfYatzi(Die[] dices) {
        for (int i = 1; i < dices.length; i++) {
            if (dices[i].getDieValue() != dices[i - 1].getDieValue()) {
                return false;
            }
        }
        return true;
    }

    private void newRound() {
        if(!checkIfYatzi(ds)){
            if (gameTurns != 3) {
                System.out.println("Want to throw again? ('y' / 'n')");
                if (sc.next().equals("y")) {
                    ++gameTurns;
                    rollDie();
                } else {
                    System.exit(0);
                }
            } else {
                gameOver();
            }
        } else {
            youGotYatzi();
        }
    }

    private void youGotYatzi() {
        System.out.println();
        System.out.println("WOW you YATZI!");
        System.out.println("You got it in " + ds[0].getDieValue() + "'s");
        System.out.println();
        System.out.println("Want to play again? ('y' / 'hacks')");
        switch (sc.next()) {
            case "y" -> new YatziMain(1);
            case "hacks" -> new YatziMain(2);
            default -> System.exit(0);
        }
    }

    private void gameOver(){
        System.out.println("Game over! Want to play again? ('y' / 'hacks')");
        switch (sc.next()) {
            case "y" -> new YatziMain(1);
            case "hacks" -> new YatziMain(2);
            default -> System.exit(0);
        }
    }

    public static void main(String[] args) {
        new YatziMain();
    }
}