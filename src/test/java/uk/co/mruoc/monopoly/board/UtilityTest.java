package uk.co.mruoc.monopoly.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilityTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;

    private final Property property = new Utility(NAME, COST);

    @Test
    public void shouldCalculateRent() {
        assertThat(property.calculateRent()).isEqualTo(0);
    }

}
