package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;

    private final Location location = new Property(NAME, COST);
    private final Player player = new Player("PLAYER");

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo(NAME);
    }

    @Test
    public void shouldReturnTrueIfEqualsName() {
        assertThat(location.nameEquals(NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfDoesNotEqualName() {
        assertThat(location.nameEquals("NOT_EQUAL")).isFalse();
    }

    @Test
    public void shouldNotHaveOwnerByDefault() {
        assertThat(location.hasOwner()).isFalse();
        assertThat(location.getOwner()).isNull();
    }

    @Test
    public void shouldSetOwner() {
        location.setOwner(player);

        assertThat(location.hasOwner()).isTrue();
        assertThat(location.getOwner()).isEqualTo(player);
        assertThat(player.ownsProperty(location)).isTrue();
    }

    @Test
    public void shouldBePurchasedIfPlayerCanAfford() {
        player.setBalance(30);

        location.applyTo(player);

        assertThat(location.hasOwner()).isTrue();
        assertThat(location.getOwner()).isEqualTo(player);
        assertThat(player.ownsProperty(location)).isTrue();
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldNotBePurchasedIfPlayerCanNotAfford() {
        player.setBalance(10);

        location.applyTo(player);

        assertThat(location.hasOwner()).isFalse();
        assertThat(location.getOwner()).isNull();
        assertThat(player.ownsProperty(location)).isFalse();
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldNotBePurchasedIfAlreadyHasOwner() {
        Player owner = new Player("OWNER");
        location.setOwner(owner);

        player.setBalance(30);

        location.applyTo(player);

        assertThat(location.hasOwner()).isTrue();
        assertThat(location.getOwner()).isEqualTo(owner);
        assertThat(player.ownsProperty(location)).isFalse();
        assertThat(player.getBalance()).isEqualTo(30);
    }

}
