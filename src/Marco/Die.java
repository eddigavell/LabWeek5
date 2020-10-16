package Marco;

class Die {
    private int value;

    void dieRoll() {
        this.value = (int)(Math.random()*6+1);
    }

    void setDieValue(int v) {
        this.value = v;
    }

    int getDieValue() {
        return this.value;
    }
}