package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLocationTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;

    @Test
    public void shouldReturnName() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.getName()).isEqualTo(NAME);
    }

    @Test
    public void defaultCostShouldBeZero() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.getCost()).isEqualTo(0);
    }

    @Test
    public void shouldReturnTrueIfEqualsName() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.nameEquals(NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfDoesNotEqualName() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.nameEquals("NOT_EQUAL")).isFalse();
    }

    @Test
    public void shouldReturnCost() {
        Location location = new DefaultLocation(NAME, COST);
        assertThat(location.getCost()).isEqualTo(COST);
    }

    @Test
    public void shouldNotHaveOwnerByDefault() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.hasOwner()).isFalse();
        assertThat(location.getOwner()).isNull();
    }

    @Test
    public void shouldSetOwner() {
        Location location = new DefaultLocation(NAME);
        Player player = new Player("");

        location.setOwner(player);

        assertThat(location.hasOwner()).isTrue();
        assertThat(location.getOwner()).isEqualTo(player);
    }

    @Test
    public void shouldReturnIsSuperTaxFalseIfNotSuperTax() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.isSuperTax()).isFalse();
    }

    @Test
    public void shouldReturnIsSuperTaxTrueIfNotSuperTax() {
        Location location = new DefaultLocation(NAME);
        assertThat(location.isSuperTax()).isFalse();
    }

}
