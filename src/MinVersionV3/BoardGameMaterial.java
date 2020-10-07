package MinVersionV3;
import java.util.Random;

abstract class BoardGameMaterial {
    Random rand = new Random();
    private int value;

    BoardGameMaterial() {
        this.value = randomNumberBetweenOneToSix();
    }

    private int randomNumberBetweenOneToSix() {
        return rand.nextInt(6)+1;
    }

    void dieRoll() {
        this.value = randomNumberBetweenOneToSix();
    }

    int getDieValue() {
        return this.value;
    }

    void setDieValue(int x) {
        this.value = x;
    }
}