package uk.co.mruoc.monopoly;

public class Roll {

    private final int value1;
    private final int value2;

    public Roll() {
        this(0, 0);
    }

    public Roll(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int value() {
        return value1 + value2;
    }

    public boolean isDouble() {
        if (value1 < 1)
            return false;
        return value1 == value2;
    }

}
