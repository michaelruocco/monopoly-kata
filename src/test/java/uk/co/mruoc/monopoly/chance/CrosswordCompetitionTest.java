package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class CrosswordCompetitionTest {

    private final ChanceCard chanceCard = new CrosswordCompetition();
    private final Player player = new Player("NAME");

    @Test
    public void shouldPayPlayerOneHundred() {
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(100);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("You have won a crossword competition. Collect £100");
    }

}
