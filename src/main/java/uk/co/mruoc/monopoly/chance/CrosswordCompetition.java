package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class CrosswordCompetition implements ChanceCard {

    private static final int VALUE = 100;

    @Override
    public void applyTo(Player player) {
        player.incrementBalance(VALUE);
    }

    @Override
    public String getText() {
        return "You have won a crossword competition. Collect £" + VALUE;
    }

}
