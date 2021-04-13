package uk.co.mruoc.monopoly.players;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private static final String NAME = "player-name";

    private final Player player = new Player(NAME);

    @Test
    void shouldReturnName() {
        assertThat(player.getName()).isEqualTo(NAME);
    }

    @Test
    void shouldReturnTrueIfHasName() {
        assertThat(player.hasName(NAME)).isTrue();
    }

    @Test
    void shouldReturnFalseIfDoesNotHaveName() {
        assertThat(player.hasName("other-name")).isFalse();
    }

    @Test
    void shouldHaveZeroBalanceByDefault() {
        assertThat(player.getBalance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void shouldIncreaseBalanceWhenMoneyReceived() {
        BigDecimal amount1 = BigDecimal.valueOf(150L);
        BigDecimal amount2 = BigDecimal.valueOf(50L);

        player.receive(amount1);
        player.receive(amount2);

        assertThat(player.getBalance()).isEqualTo(amount1.add(amount2));
    }

}