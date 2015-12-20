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
        for (Property property : properties)
            if (!property.hasOwner())
                return false;
        return true;
    }

    public boolean allOwnedBy(Player player) {
        for (Property property : properties)
            if (!player.ownsProperty(property))
                return false;
        return true;
    }

}
