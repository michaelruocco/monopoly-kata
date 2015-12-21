package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class SpeedingFine implements ChanceCard {

    private static final int VALUE = 15;

    @Override
    public void applyTo(Player player) {
        player.decrementBalance(VALUE);
    }

    @Override
    public String getText() {
        return "Spending fine £" + VALUE;
    }

}
