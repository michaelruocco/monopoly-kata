package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class BuildingLoan implements ChanceCard {

    private static final int VALUE = 150;

    @Override
    public void applyTo(Player player) {
        player.incrementBalance(VALUE);
    }

    @Override
    public String getText() {
        return "Your building loan matures. Receive £" + VALUE;
    }

}
