package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilityTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;
    private static final int ROLL = 10;

    private final PropertyGroup group = new PropertyGroup();
    private final Player player = new Player("Player1");

    private final Property utility1 = new Utility(NAME, group, COST);
    private final Property utility2 = new Utility(NAME, group, COST);

    @Test
    public void shouldCalculateRentAsZeroIfNoUtilitiesOwned() {
        assertThat(utility1.calculateRent(ROLL)).isEqualTo(0);
    }

    @Test
    public void shouldCalculateRentAsFourTimesDiceValueIfOneUtilityOwned() {
        utility1.setOwner(player);

        assertThat(utility1.calculateRent(ROLL)).isEqualTo(4 * ROLL);
    }

    @Test
    public void shouldCalculateRentAsFourTimesDiceValueIfTwoUtilitiesOwned() {
        utility1.setOwner(player);
        utility2.setOwner(player);

        assertThat(utility1.calculateRent(ROLL)).isEqualTo(10 * ROLL);
    }

}
