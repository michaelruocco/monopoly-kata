package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.chance.BankDividend;
import uk.co.mruoc.monopoly.chance.ChanceCard;
import uk.co.mruoc.monopoly.chance.ChanceCards;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ChanceTest {

    private final Chance chance = new Chance("Chance", new StubbedChanceCards());
    private final Player player = new Player("Name");

    @Test
    public void shouldApplyNextChanceCardToPlayer() {
        player.setBalance(0);

        chance.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(50);
    }

    private static class StubbedChanceCards implements ChanceCards {

        @Override
        public ChanceCard getNext() {
            return new BankDividend();
        }

        @Override
        public int size() {
            return 1;
        }

    }

}
