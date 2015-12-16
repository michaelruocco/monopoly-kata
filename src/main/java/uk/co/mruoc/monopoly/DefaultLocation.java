package uk.co.mruoc.monopoly;

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
        return nameEquals("Go To Jail");
    }

    @Override
    public boolean isIncomeTax() {
        return nameEquals("Income Tax");
    }

    @Override
    public boolean isSuperTax() {
        return nameEquals("Super Tax");
    }

    @Override
    public int getCost() {
        return cost;
    }

}
