package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

public class AdvanceToGo implements ChanceCard {

    private static final String LOCATION_NAME = "Go";

    @Override
    public void applyTo(Player player) {
        player.advanceTo(LOCATION_NAME);
    }

    @Override
    public String getText() {
        return "Advance to " + LOCATION_NAME.toUpperCase();
    }

}
