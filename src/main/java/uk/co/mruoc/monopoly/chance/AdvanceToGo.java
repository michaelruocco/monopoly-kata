package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

public class AdvanceToGo implements ChanceCard {

    @Override
    public void applyTo(Player player) {
        player.advanceTo("Go");
    }

    @Override
    public String getText() {
        return "Advance to GO";
    }

}
