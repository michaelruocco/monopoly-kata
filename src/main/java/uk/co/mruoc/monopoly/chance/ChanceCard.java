package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public interface ChanceCard {

    void applyTo(Player player);

    String getText();

}
