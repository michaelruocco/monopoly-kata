package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    private static final String NAME = "NAME";
    private static final int COST = 20;

    @Test
    public void shouldReturnName() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.getName()).isEqualTo(NAME);
    }

    @Test
    public void defaultCostShouldBeZero() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.getCost()).isEqualTo(0);
    }

    @Test
    public void shouldReturnTrueIfEqualsName() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.nameEquals(NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfDoesNotEqualName() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.nameEquals("NOT_EQUAL")).isFalse();
    }

    @Test
    public void shouldReturnCost() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME, COST);
        assertThat(location.getCost()).isEqualTo(COST);
    }

    @Test
    public void shouldNotHaveOwnerByDefault() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.hasOwner()).isFalse();
        assertThat(location.getOwner()).isNull();
    }

    @Test
    public void shouldSetOwner() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        Player player = new Player("");

        location.setOwner(player);

        assertThat(location.hasOwner()).isTrue();
        assertThat(location.getOwner()).isEqualTo(player);
    }

    @Test
    public void shouldReturnIsSuperTaxFalseIfNotSuperTax() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.isSuperTax()).isFalse();
    }

    @Test
    public void shouldReturnIsSuperTaxTrueIfNotSuperTax() {
        uk.co.mruoc.monopoly.board.Location location = new uk.co.mruoc.monopoly.board.DefaultLocation(NAME);
        assertThat(location.isSuperTax()).isFalse();
    }


}
