package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

import java.util.ArrayList;
import java.util.List;

public class PropertyGroup {

    private final List<Property> properties = new ArrayList<>();

    public void addProperty(Property street) {
        properties.add(street);
    }

    public boolean allOwned() {
        return getNumberOfPropertiesOwned() == size();
    }

    public boolean allOwnedBy(Player player) {
        return getNumberOfPropertiesOwnedBy(player) == size();
    }

    public int getNumberOfPropertiesOwned() {
        int count = 0;
        for (Property property : properties)
            if (property.hasOwner())
                count++;
        return count;
    }

    public int getNumberOfPropertiesOwnedBy(Player player) {
        int count = 0;
        for (Property property : properties)
            if (player.ownsProperty(property))
                count++;
        return count;
    }

    public int size() {
        return properties.size();
    }

}
