package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

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

    public abstract boolean isGoToJail();

    public abstract boolean isIncomeTax();

    public abstract boolean isSuperTax();

    public abstract int getCost();

}
