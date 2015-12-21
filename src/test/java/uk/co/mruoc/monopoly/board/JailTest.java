package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JailTest {

    private final Jail jail = new Jail();
    private final Board board = new Board(jail);
    private final Player player = new Player("NAME", board);

    @Test
    public void shouldNotContainPlayerThatIsNotInJail() {
        assertThat(player.isInJail()).isFalse();
    }

    @Test
    public void shouldPutPlayerInJail() {
        jail.put(player);
        assertThat(player.isInJail()).isTrue();
    }

    @Test
    public void shouldRemovePlayerFromJail() {
        jail.put(player);
        jail.remove(player);
        assertThat(player.isInJail()).isFalse();
    }

}
