package MinVersionV2;

import java.util.Random;

class Die {
    private Random randomInt = new Random();
    private int dieValue;

    Die() {
        this.dieValue = randomValueBetweenOneToSix();
    }

    int randomValueBetweenOneToSix() {
        return randomInt.nextInt(6)+1;
    }

    int getDieValue() {
        return this.dieValue;
    }

    void rollDie() {
        this.dieValue = randomValueBetweenOneToSix();
    }

    void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
