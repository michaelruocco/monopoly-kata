package uk.co.mruoc.monopoly;

public class SuperTax extends Location {

    public SuperTax(String name) {
        super(name);
    }

    @Override
    public boolean isGoToJail() {
        return false;
    }

    @Override
    public boolean isIncomeTax() {
        return false;
    }

    @Override
    public boolean isSuperTax() {
        return true;
    }

    @Override
    public int getCost() {
        return 0;
    }

}
