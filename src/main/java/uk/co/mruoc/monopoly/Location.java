package uk.co.mruoc.monopoly;

public class Location {

    private final String name;
    private final int cost;

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

}
