package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

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
    public void applyTo(Player player) {
        if (isPurchasableBy(player))
            setOwner(player);
    }

    @Override
    public void setOwner(Player player) {
        player.decrementBalance(cost);
        player.addProperty(this);
        super.setOwner(player);
    }

    public boolean isPurchasableBy(Player player) {
        if (hasOwner())
            return false;
        return player.getBalance() >= cost;
    }

    @Override
    public boolean isGoToJail() {
        return false;
    }

}
