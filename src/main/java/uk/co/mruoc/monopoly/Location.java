package uk.co.mruoc.monopoly;

public class Location {

    private final String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isGoToJail() {
        return getName().equalsIgnoreCase("Go To Jail");
    }

    public boolean isIncomeTax() {
        return getName().equalsIgnoreCase("Income Tax");
    }

    public boolean isSuperTax() {
        return getName().equalsIgnoreCase("Super Tax");
    }

}
