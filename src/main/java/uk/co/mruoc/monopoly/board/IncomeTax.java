package uk.co.mruoc.monopoly.board;

public class IncomeTax extends Location {

    public IncomeTax() {
        super("Income Tax");
    }

    @Override
    public boolean isGoToJail() {
        return false;
    }

    @Override
    public boolean isIncomeTax() {
        return true;
    }

    @Override
    public boolean isSuperTax() {
        return false;
    }

    @Override
    public int getCost() {
        return 0;
    }

}
