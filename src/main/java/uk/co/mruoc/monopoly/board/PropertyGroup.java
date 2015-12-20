package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

import java.util.ArrayList;
import java.util.List;

public class PropertyGroup {

    private final List<Property> properties = new ArrayList<>();

    public void addProperty(Property property) {
        properties.add(property);
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
            if (property.ownedBy(player))
                count++;
        return count;
    }

    public int size() {
        return properties.size();
    }

    public boolean contains(Property property) {
        return properties.contains(property);
    }

}
