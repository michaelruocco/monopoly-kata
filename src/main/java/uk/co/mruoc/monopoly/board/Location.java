package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public abstract class Location {

    private final String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public void applyTo(Player player) {
        applyTo(player, new Roll());
    }

    public abstract void applyTo(Player player, Roll roll);

}
