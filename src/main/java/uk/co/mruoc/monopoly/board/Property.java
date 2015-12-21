package uk.co.mruoc.monopoly.board;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public abstract class Property extends Location {

    private static final Logger LOG = Logger.getLogger(Property.class);

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
    public void applyTo(Player player, Roll roll) {
        logInfo("player " + player.getName() + " landed on location " + getName());
        if (hasOwner()) {
            collectRentFrom(player, roll);
            return;
        }

        if (player.canAfford(this))
            setOwner(player);
    }

    public void setOwner(Player owner) {
        owner.decrementBalance(cost);
        this.owner = owner;
        logInfo(owner.getName() + " brought " + getName() + " for " + cost);
    }

    public Player getOwner() {
        return owner;
    }

    public boolean hasOwner() {
        return getOwner() != null;
    }

    public boolean ownedBy(Player player) {
        if (!hasOwner())
            return false;
        return owner.equals(player);
    }

    public int getCost() {
        return cost;
    }

    public PropertyGroup getGroup() {
        return group;
    }

    public int calculateRent() {
        return calculateRent(new Roll());
    }

    public abstract int calculateRent(Roll roll);

    private void collectRentFrom(Player player, Roll roll) {
        int rent = calculateRent(roll);
        player.decrementBalance(rent);
        getOwner().incrementBalance(rent);
        logInfo(getName() + " is owned by " + getOwnerName() + " so " + player.getName() + " is paying rent " + rent);
    }

    private String getOwnerName() {
        return owner.getName();
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

}
