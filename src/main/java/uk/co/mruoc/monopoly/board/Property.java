package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public abstract class Property extends Location {

    private final int cost;
    private Player owner;

    public Property(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public void applyTo(Player player) {
        if (hasOwner()) {
            collectRentFrom(player);
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

    private void collectRentFrom(Player player) {
        int rent = calculateRent();
        player.decrementBalance(rent);
        getOwner().incrementBalance(rent);
    }

    public abstract int calculateRent();

}
