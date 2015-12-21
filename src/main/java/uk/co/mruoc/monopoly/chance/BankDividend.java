package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class BankDividend implements ChanceCard {

    private static final int VALUE = 50;

    @Override
    public void applyTo(Player player) {
        player.incrementBalance(VALUE);
    }

    @Override
    public String getText() {
        return "Bank pays you dividend of £" + VALUE;
    }

}
