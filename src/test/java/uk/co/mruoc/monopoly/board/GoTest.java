package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.monopoly.players.Player;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GoTest {

    private static final BigDecimal SALARY = BigDecimal.TEN;

    private final Location go = new Go(SALARY);

    @Test
    void shouldReturnName() {
        assertThat(go.getName()).isEqualTo("Go");
    }

    @Test
    void shouldPaySalaryToPlayerWhenPlayerLands() {
        Player player = mock(Player.class);

        go.land(player);

        verify(player).receive(SALARY);
    }

}