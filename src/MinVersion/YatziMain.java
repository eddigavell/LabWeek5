package MinVersion;

import java.util.Scanner;

public class YatziMain {
    private static Die[] dices = new Die[5];
    private static boolean boardGameIsPlaying = true;
    private static int gameTurn = 1;


    static void createFiveDices() {
        for(int i=0;i<5;i++) {
            dices[i] = new Die();
        }
    }

    private static void rollAllDices() {
        for (int i=0; i<5;i++) {
            dices[i].dieRoll();
        }
    }

    private static void printAllDieValues() {
        for(int i = 0; i<5; i++) {
            System.out.println("Die " +i + ": " + dices[i].printDieValue());
        }
    }

    private static boolean checkIfYatzi() {
        boolean thisIsYatzi = true;
        for (int i = 1; i<= dices.length-1; i++) {
            if (dices[i].getDieValue() != dices[i - 1].getDieValue()) {
                thisIsYatzi = false;
                break;
            }
        }
        return thisIsYatzi;
    }

    private static void activateAlwaysYatzi() {
        for (int i=0; i<5;i++) {
            dices[i].setDieValue(6);
            System.out.println("Die " + i +": " + dices[i].getDieValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createFiveDices();
        //We will continue until the game is over
        while(boardGameIsPlaying) {
            System.out.println("Welcome to Yatzi!");
            while (gameTurn <= 3) {
                System.out.println("Starting turn " + (gameTurn) + " of 3, rolling dices");
                rollAllDices();
                printAllDieValues();
                //activateAlwaysYatzi();
                if(!checkIfYatzi()) {
                    //No yatzi
                    if(gameTurn != 3) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        if(sc.next().equals("y")) {
                            ++gameTurn;
                        } else {
                            boardGameIsPlaying = !boardGameIsPlaying;
                            break;
                        }
                    } else {
                        //Lastround
                        System.out.println("Game over! Want to play again?");
                        if(sc.next().equals("y")) {
                            gameTurn = 1;
                        } else {
                            boardGameIsPlaying = !boardGameIsPlaying;
                            break;
                        }
                    }
                } else {
                    //If we get a Yatzi
                    System.out.println("You got YATZI! in " + dices[0].getDieValue() + "'s");
                    return;
                }
            }
        }
        sc.close();
    }
}

