package uk.co.mruoc.monopoly;

public abstract class Location {

    private final String name;
    private Player owner;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equalsIgnoreCase(name);
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

    abstract boolean isGoToJail();

    abstract boolean isIncomeTax();

    abstract boolean isSuperTax();

    abstract int getCost();

}
