package Marco;

public class Dices {
    int value;

    public void diceRoll() {
        this.value = (int)(Math.random()*6+1);
    }

    public String getString() {
        return "Dice shows: " + this.value;
    }
}
