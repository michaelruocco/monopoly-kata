package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public abstract class Property extends Location {

    private final int cost;
    private final PropertyGroup group;
    private Player owner;

    public Property(String name, PropertyGroup group, int cost) {
        super(name);
        this.group = group;
        this.cost = cost;
        group.addProperty(this);
    }

    @Override
    public void applyTo(Player player) {
        applyTo(player, 0);
    }

    @Override
    public void applyTo(Player player, int roll) {
        if (hasOwner()) {
            collectRentFrom(player, roll);
            return;
        }

        if (player.canAfford(this))
            setOwner(player);
    }

    public void setOwner(Player owner) {
        owner.decrementBalance(cost);
        owner.addProperty(this);
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean hasOwner() {
        return getOwner() != null;
    }

    public int getCost() {
        return cost;
    }

    private void collectRentFrom(Player player, int roll) {
        int rent = calculateRent(roll);
        player.decrementBalance(rent);
        getOwner().incrementBalance(rent);
    }

    public int calculateRent() {
        return calculateRent(0);
    }

    public abstract int calculateRent(int roll);

    public PropertyGroup getGroup() {
        return group;
    }

}
