package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class StreetTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;
    private static final int RENT = 0;

    private final Property street = new Street(NAME, COST, RENT);
    private final Player player = new Player("PLAYER");

    @Test
    public void shouldNotHaveOwnerByDefault() {
        assertThat(street.hasOwner()).isFalse();
        assertThat(street.getOwner()).isNull();
    }

    @Test
    public void shouldSetOwner() {
        street.setOwner(player);

        assertThat(street.hasOwner()).isTrue();
        assertThat(street.getOwner()).isEqualTo(player);
        assertThat(player.ownsProperty(street)).isTrue();
    }

    @Test
    public void shouldBePurchasedIfPlayerCanAfford() {
        player.setBalance(30);

        street.applyTo(player);

        assertThat(street.hasOwner()).isTrue();
        assertThat(street.getOwner()).isEqualTo(player);
        assertThat(player.ownsProperty(street)).isTrue();
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldNotBePurchasedIfPlayerCanNotAfford() {
        player.setBalance(10);

        street.applyTo(player);

        assertThat(street.hasOwner()).isFalse();
        assertThat(street.getOwner()).isNull();
        assertThat(player.ownsProperty(street)).isFalse();
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldNotBePurchasedIfAlreadyHasOwner() {
        Player owner = new Player("OWNER");
        street.setOwner(owner);

        player.setBalance(30);

        street.applyTo(player);

        assertThat(street.hasOwner()).isTrue();
        assertThat(street.getOwner()).isEqualTo(owner);
        assertThat(player.ownsProperty(street)).isFalse();
        assertThat(player.getBalance()).isEqualTo(30);
    }

    @Test
    public void shouldCalculateRent() {
        assertThat(street.calculateRent()).isEqualTo(RENT);
    }

    @Test
    public void shouldReturnCost() {
        assertThat(street.getCost()).isEqualTo(COST);
    }

}
