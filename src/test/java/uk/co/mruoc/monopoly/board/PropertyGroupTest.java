package uk.co.mruoc.monopoly.board;

import org.junit.Before;
import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyGroupTest {

    private static final int COST = 100;
    private static final int RENT = 200;

    private final Player player1 = new Player("Player 1");
    private final Player player2 = new Player("Player 2");

    private final Property street1 = new Street("Street 1", COST, RENT);
    private final Property street2 = new Street("Street 2", COST, RENT);
    private final Property street3 = new Street("Street 3", COST, RENT);

    private final PropertyGroup group = new PropertyGroup();

    @Before
    public void setUp() {
        group.addProperty(street1);
        group.addProperty(street2);
        group.addProperty(street3);
    }

    @Test
    public void shouldReturnFalseIfAllPropertiesInGroupAreNotOwned() {
        assertThat(group.allOwned()).isFalse();
    }

    @Test
    public void shouldReturnTrueIfAllPropertiesInGroupAreOwned() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player2);

        assertThat(group.allOwned()).isTrue();
    }

    @Test
    public void shouldReturnFalseIfAllPropertiesInGroupAreNotOwnedBySamePlayer() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player2);

        assertThat(group.allOwnedBy(player1)).isFalse();
    }

    @Test
    public void shouldReturnTrueIfAllPropertiesInGroupAreOwnedBySamePlayer() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player1);

        assertThat(group.allOwnedBy(player1)).isTrue();
    }

}
