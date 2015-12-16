package uk.co.mruoc.monopoly.board;

public class DefaultLocation extends Location {

    private final int cost;

    public DefaultLocation(String name) {
        this(name, 0);
    }

    public DefaultLocation(String name, int cost) {
        super(name);
        this.cost = cost;
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
        return false;
    }

    @Override
    public int getCost() {
        return cost;
    }

}
