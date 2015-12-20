package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class StreetTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;
    private static final int RENT = 10;

    private final PropertyGroup group = new PropertyGroup();
    private final Player player = new Player("PLAYER");

    private final Property street = new Street(NAME, group, COST, RENT);

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
    }

    @Test
    public void shouldBePurchasedIfPlayerCanAfford() {
        player.setBalance(30);

        street.applyTo(player);

        assertThat(street.hasOwner()).isTrue();
        assertThat(street.getOwner()).isEqualTo(player);
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldNotBePurchasedIfPlayerCanNotAfford() {
        player.setBalance(10);

        street.applyTo(player);

        assertThat(street.hasOwner()).isFalse();
        assertThat(street.getOwner()).isNull();
        assertThat(player.getBalance()).isEqualTo(10);
    }

    @Test
    public void shouldPayRentIfPropertyAlreadyHasOwner() {
        Player owner = new Player("OWNER");
        street.setOwner(owner);
        owner.setBalance(0);
        player.setBalance(30);

        street.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(10);
        assertThat(owner.getBalance()).isEqualTo(20);
    }

    @Test
    public void shouldCalculateBasicRent() {
        Property anotherStreet = new Street(NAME, group, COST, RENT);

        anotherStreet.setOwner(player);

        assertThat(street.calculateRent()).isEqualTo(RENT);
        assertThat(anotherStreet.calculateRent()).isEqualTo(RENT);
    }

    @Test
    public void shouldCalculateRentIfAllPropertiesInGroupOwned() {
        Property anotherStreet = new Street(NAME, group, COST, RENT);

        street.setOwner(player);
        anotherStreet.setOwner(player);

        int expectedRent = RENT * 2;
        assertThat(street.calculateRent()).isEqualTo(expectedRent);
        assertThat(anotherStreet.calculateRent()).isEqualTo(expectedRent);
    }

    @Test
    public void shouldReturnCost() {
        assertThat(street.getCost()).isEqualTo(COST);
    }

    @Test
    public void shouldAddPropertyToGroup() {
        assertThat(group.size()).isEqualTo(1);
        assertThat(group.contains(street)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfHasNoOwner() {
        assertThat(street.ownedBy(player)).isFalse();
    }

    @Test
    public void shouldReturnFalseIfOwnedByAnotherPlayer() {
        street.setOwner(new Player("ANOTHER PLAYER"));

        assertThat(street.ownedBy(player)).isFalse();
    }

    @Test
    public void shouldReturnTrueIfOwnedByPlayer() {
        street.setOwner(player);

        assertThat(street.ownedBy(player)).isTrue();
    }

}
