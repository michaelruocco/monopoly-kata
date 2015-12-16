package uk.co.mruoc.monopoly.board;

public class GoToJail extends Location {

    public GoToJail() {
        super("Go To Jail");
    }

    @Override
    public boolean isGoToJail() {
        return true;
    }

    @Override
    public boolean isIncomeTax() {
        return false;
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
