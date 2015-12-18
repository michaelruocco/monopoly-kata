package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class TrainStation extends Property {

    private static final int RENT = 25;

    public TrainStation(String name) {
        super(name, 200);
    }

    @Override
    public void applyTo(Player player) {
        if (hasOwner()) {
            collectRentFrom(player);
            return;
        }
        
        if (isPurchasableBy(player))
            setOwner(player);
    }

    private void collectRentFrom(Player player) {
        int rent = calculateRent();
        player.decrementBalance(rent);
        getOwner().incrementBalance(rent);
    }

    private int calculateRent() {
        return RENT;
    }

}
