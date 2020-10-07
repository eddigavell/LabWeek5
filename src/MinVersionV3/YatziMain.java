package MinVersionV3;

import java.util.Scanner;

class YatziMain {
    private static Die[] dices = new Die[5];
    private static boolean boardGameIsPlaying = true;
    private static int gameTurn = 1;

    YatziMain() {
        createFiveDices();
        rollAllDices();
        printAllDieValues();
    }

    void createFiveDices() {
        for(int i=0;i<5;i++) {
            dices[i] = new Die();
        }
    }

    void rollAllDices() {
        for (int i=0; i<5;i++) {
            dices[i].dieRoll();
        }
    }

    void printAllDieValues() {
        for(int i = 0; i<=4; i++) {
            System.out.println("Die " + i + ": " + dices[i].getDieValue());
        }
    }

    static boolean checkIfYatzi(Die[] dices) {
        boolean isItYatzi = true;
        for (int i = 1; i<= dices.length-1; i++) {
            if (dices[i].getDieValue() != dices[i - 1].getDieValue()) {
                isItYatzi = false;
                break;
            }
        }
        return isItYatzi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //We will continue until the game is over
        while(boardGameIsPlaying) {
            System.out.println("Welcome to Yatzi!");
            while (gameTurn <= 3) {
                System.out.println("Starting turn " + (gameTurn) + " of 3, rolling dices");
                new YatziMain();
                if(!checkIfYatzi(dices)) {
                    if(gameTurn != 3) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        if(sc.next().equals("y")) {
                            gameTurn++;
                        } else {
                            boardGameIsPlaying = !boardGameIsPlaying;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again?");
                        if(sc.next().equals("y")) {
                            gameTurn = 1;
                        } else {
                            boardGameIsPlaying = !boardGameIsPlaying;
                            break;
                        }
                    }
                } else {
                    System.out.println("You got YATZI! in " + dices[0].getDieValue() + "'s");
                    return;
                }
            }
        }
        sc.close();
    }
}

