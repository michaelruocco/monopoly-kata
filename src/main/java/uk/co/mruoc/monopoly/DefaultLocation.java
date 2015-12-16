package uk.co.mruoc.monopoly;

public class DefaultLocation implements Location {

    private final String name;
    private final int cost;
    private Player owner;

    public DefaultLocation(String name) {
        this(name, 0);
    }

    public DefaultLocation(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean nameEquals(String name) {
        return this.name.equalsIgnoreCase(name);
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

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public boolean hasOwner() {
        return getOwner() != null;
    }

}
