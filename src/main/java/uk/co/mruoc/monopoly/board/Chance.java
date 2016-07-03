package uk.co.mruoc.monopoly.board;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;
import uk.co.mruoc.monopoly.chance.ChanceCard;
import uk.co.mruoc.monopoly.chance.ChanceCards;

public class Chance extends Location {

    private static final Logger LOG = Logger.getLogger(Chance.class);
    private final ChanceCards chanceCards;

    public Chance(String name, ChanceCards chanceCards) {
        super(name);
        this.chanceCards = chanceCards;
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        ChanceCard chanceCard = chanceCards.getNext();
        chanceCard.applyTo(player);
        logInfo("player " + player.getName() + " got chance card " + chanceCard.getText());
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

}
