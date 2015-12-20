package uk.co.mruoc.monopoly.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilityTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;
    private static final int ROLL = 10;

    private final Property property = new Utility(NAME, COST);

    @Test
    public void shouldCalculateRentAsFourTimesDiceValueIfOneUtilityOwned() {
        assertThat(property.calculateRent(ROLL)).isEqualTo(4 * ROLL);
    }

}
