package Marco;

public class Die {
    int value;

    public void dieRoll() {
        this.value = (int)(Math.random()*6+1);
    }

    void setDieValue(int v) {
        this.value = v;
    }
}
