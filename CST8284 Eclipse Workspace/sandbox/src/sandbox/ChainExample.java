package sandbox;

class ChainExample {
    private int value;

    public ChainExample setValue(int value) {
        this.value = value;
        return this;
    }

    public ChainExample add(int x) {
        this.value += x;
        return this;
    }

    public ChainExample multiply(int x) {
        this.value *= x;
        return this;
    }

    public ChainExample chain() {
        return this;
    }

    public int getValue() {
        return value;
    }
}
