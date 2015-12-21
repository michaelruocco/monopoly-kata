package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class AdvanceToTrafalgarSquare implements ChanceCard {

    @Override
    public void applyTo(Player player) {
        player.advanceTo("Trafalgar Square");
    }

    @Override
    public String getText() {
        return "Advance to Trafalgar Square. If you pass GO, collect £200";
    }

}
