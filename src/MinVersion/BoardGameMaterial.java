package MinVersion;
import java.util.Random;

abstract class BoardGameMaterial {
    /* Will be used to store all boardgamematerials in one class */
    Random rand = new Random();
    private int dieValue;

    BoardGameMaterial() {
        this.dieValue = randomNumberBetweenOneToSix();
    }

    private int randomNumberBetweenOneToSix() {
        return rand.nextInt(6)+1;
    }

    public int dieRoll() {
        this.dieValue = randomNumberBetweenOneToSix();
        return this.dieValue;
    }

    public String printDieValue() {
        return "Dice shows " + this.dieValue;
    }

    public int getDieValue() {
        return this.dieValue;
    }

    public void setDieValue(int x) {
        this.dieValue = x;
    }
}
