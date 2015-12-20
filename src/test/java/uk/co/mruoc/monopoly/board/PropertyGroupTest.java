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

    private final PropertyGroup group = new PropertyGroup();

    private final Property street1 = new Street("Street 1", group, COST, RENT);
    private final Property street2 = new Street("Street 2", group, COST, RENT);
    private final Property street3 = new Street("Street 3", group, COST, RENT);

    @Test
    public void shouldReturnPropertyGroup() {
        assertThat(street1.getGroup()).isEqualTo(group);
        assertThat(street2.getGroup()).isEqualTo(group);
        assertThat(street3.getGroup()).isEqualTo(group);
    }

    @Test
    public void shouldReturnSize() {
        assertThat(group.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnFalseIfAllPropertiesInGroupAreNotOwned() {
        assertThat(group.allOwned()).isFalse();
    }

    @Test
    public void shouldReturnNumberOfPropertiesOwned() {
        assertThat(group.getNumberOfPropertiesOwned()).isEqualTo(0);
    }

    @Test
    public void shouldReturnTrueIfAllPropertiesInGroupAreOwned() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player2);

        assertThat(group.allOwned()).isTrue();
        assertThat(group.getNumberOfPropertiesOwned()).isEqualTo(3);
    }

    @Test
    public void shouldReturnNumberOfPropertiesOwnedByPlayer() {
        assertThat(group.getNumberOfPropertiesOwnedBy(player1)).isEqualTo(0);
    }

    @Test
    public void shouldReturnFalseIfAllPropertiesInGroupAreNotOwnedBySamePlayer() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player2);

        assertThat(group.allOwnedBy(player1)).isFalse();
        assertThat(group.getNumberOfPropertiesOwnedBy(player1)).isEqualTo(2);
        assertThat(group.getNumberOfPropertiesOwnedBy(player2)).isEqualTo(1);
    }

    @Test
    public void shouldReturnTrueIfAllPropertiesInGroupAreOwnedBySamePlayer() {
        street1.setOwner(player1);
        street2.setOwner(player1);
        street3.setOwner(player1);

        assertThat(group.allOwnedBy(player1)).isTrue();
        assertThat(group.getNumberOfPropertiesOwnedBy(player1)).isEqualTo(3);
        assertThat(group.getNumberOfPropertiesOwnedBy(player2)).isEqualTo(0);
    }

    @Test
    public void shouldContainProperty() {
        assertThat(group.contains(street1)).isTrue();
        assertThat(group.contains(street2)).isTrue();
        assertThat(group.contains(street3)).isTrue();
    }

}
