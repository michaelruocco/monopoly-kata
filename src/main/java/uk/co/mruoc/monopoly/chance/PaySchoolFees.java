package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class PaySchoolFees implements ChanceCard {

    private static final int VALUE = 150;

    @Override
    public void applyTo(Player player) {
        player.decrementBalance(VALUE);
    }

    @Override
    public String getText() {
        return "Pay school fees of £" + VALUE;
    }

}
