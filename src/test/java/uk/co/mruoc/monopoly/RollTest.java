package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RollTest {

    @Test
    public void shouldReturnDefaultValueOfZero() {
        Roll roll = new Roll();
        assertThat(roll.value()).isEqualTo(0);
    }

    @Test
    public void shouldReturnDefaultIsDoubleAsFalse() {
        Roll roll = new Roll();
        assertThat(roll.isDouble()).isFalse();
    }

    @Test
    public void shouldReturnTotalValue() {
        Roll roll = new Roll(1, 6);
        assertThat(roll.value()).isEqualTo(7);
    }

    @Test
    public void shouldReturnIsDoubleFalseIfBothValueAreNotTheSame() {
        Roll roll = new Roll(1, 6);
        assertThat(roll.isDouble()).isFalse();
    }

    @Test
    public void shouldReturnIsDoubleTrueIfBothValueAreTheSame() {
        Roll roll = new Roll(6, 6);
        assertThat(roll.isDouble()).isTrue();
    }

}
