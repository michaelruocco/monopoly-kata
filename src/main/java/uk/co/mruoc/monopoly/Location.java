package uk.co.mruoc.monopoly;

public class Location {

    private final String name;
    private final int cost;
    private Player owner;

    public Location(String name) {
        this(name, 0);
    }

    public Location(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public boolean isGoToJail() {
        return getName().equalsIgnoreCase("Go To Jail");
    }

    public boolean isIncomeTax() {
        return getName().equalsIgnoreCase("Income Tax");
    }

    public boolean isSuperTax() {
        return getName().equalsIgnoreCase("Super Tax");
    }

    public int getCost() {
        return cost;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean hasOwner() {
        return getOwner() != null;
    }

}
