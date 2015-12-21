package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class BankDividendTest {

    private final ChanceCard chanceCard = new BankDividend();
    private final Player player = new Player("NAME");

    @Test
    public void shouldPayPlayerFifty() {
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(50);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Bank pays you dividend of £50");
    }

}
